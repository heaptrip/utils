package org.apache.solr.handler.dataimport;

import com.mongodb.*;
import com.mongodb.util.JSON;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.util.*;

import static org.apache.solr.handler.dataimport.DataImportHandlerException.SEVERE;
import static org.apache.solr.handler.dataimport.DataImportHandlerException.wrapAndThrow;

public class MongoDataSource extends DataSource<Iterator<Map<String, Object>>> {

    private static final Logger LOG = LoggerFactory.getLogger(TemplateTransformer.class);

    public static final String DATABASE = "database";
    public static final String URLS = "urls";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    private static final String ADMIN_DB_NAME = "admin";
    private static final int DEFAULT_PORT = 27017;

    private DBCollection mongoCollection;
    private DB mongoDb;

    private DBCursor mongoCursor;

    private List<String> mongoFields = new ArrayList<String>();

    @Override
    public void init(Context context, Properties initProps) {
        String databaseName = initProps.getProperty(DATABASE);
        String dbUrls = initProps.getProperty(URLS, "localhost:27017");
        String username = initProps.getProperty(USERNAME);
        String password = initProps.getProperty(PASSWORD);
        for (Map<String, String> map : context.getAllEntityFields()) {
            mongoFields.add(map.get(MongoMapperTransformer.MONGO_FIELD));
        }

        if (databaseName == null) {
            throw new DataImportHandlerException(SEVERE, "Database must be supplied");
        }

        try {
            String[] urls = dbUrls.split(",");
            if (urls != null && urls.length > 0 && !urls[0].isEmpty()) {
                List<ServerAddress> saList = new ArrayList<ServerAddress>();
                for (String url : urls) {
                    String[] arr = url.split(":");
                    String host = arr[0];
                    int port = (arr.length > 1) ? Integer.parseInt(arr[1]) : DEFAULT_PORT;
                    saList.add(new ServerAddress(host, port));
                    LOG.info("Add mongodb server: {}:{}", host, port);
                }
                MongoClient mongoClient = new MongoClient(saList);

                if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
                    DB db = mongoClient.getDB(ADMIN_DB_NAME);
                    boolean auth = db.authenticate(username, password.toCharArray());
                    if (!auth) {
                        throw new DataImportHandlerException(SEVERE, "Mongo Authentication Failed");
                    }
                }

                this.mongoDb = mongoClient.getDB(databaseName);
            } else {
                throw new DataImportHandlerException(SEVERE, "MongoClient not initialized: databese urls not filled");
            }
        } catch (UnknownHostException e) {
            throw new DataImportHandlerException(SEVERE, "Unable to connect to Mongo");
        }
    }

    @Override
    public Iterator<Map<String, Object>> getData(String query) {

        DBObject queryObject = (DBObject) JSON.parse(query);
        LOG.debug("Executing MongoQuery: " + query.toString());

        long start = System.currentTimeMillis();
        mongoCursor = this.mongoCollection.find(queryObject);
        LOG.trace("Time taken for mongo :" + (System.currentTimeMillis() - start));

        ResultSetIterator resultSet = new ResultSetIterator(mongoCursor);
        return resultSet.getIterator();
    }

    public Iterator<Map<String, Object>> getData(String query, String collection) {
        this.mongoCollection = this.mongoDb.getCollection(collection);
        return getData(query);
    }

    private class ResultSetIterator {
        DBCursor MongoCursor;

        Iterator<Map<String, Object>> rSetIterator;

        public ResultSetIterator(DBCursor MongoCursor) {
            this.MongoCursor = MongoCursor;

            rSetIterator = new Iterator<Map<String, Object>>() {
                public boolean hasNext() {
                    return hasnext();
                }

                public Map<String, Object> next() {
                    return getARow();
                }

                public void remove() {/* do nothing */
                }
            };

        }

        public Iterator<Map<String, Object>> getIterator() {
            return rSetIterator;
        }

        private Map<String, Object> getARow() {
            Map<String, Object> result = new HashMap<String, Object>();
            DBObject mongoObject = getMongoCursor().next();
            for (String key : mongoFields) {
                String[] fields = key.trim().split("\\.");
                Object innerObject = mongoObject.get(fields[0]);
                if (fields.length > 1) {
                    for (int i = 1; i < fields.length; i++) {
                        innerObject = ((DBObject) innerObject).get(fields[i]);
                    }
                }
                result.put(key, innerObject);
            }
            return result;
        }

        private boolean hasnext() {
            if (MongoCursor == null)
                return false;
            try {
                if (MongoCursor.hasNext()) {
                    return true;
                } else {
                    close();
                    return false;
                }
            } catch (MongoException e) {
                close();
                wrapAndThrow(SEVERE, e);
                return false;
            }
        }

        private void close() {
            try {
                if (MongoCursor != null)
                    MongoCursor.close();
            } catch (Exception e) {
                LOG.warn("Exception while closing result set", e);
            } finally {
                MongoCursor = null;
            }
        }
    }

    private DBCursor getMongoCursor() {
        return this.mongoCursor;
    }

    @Override
    public void close() {
        if (this.mongoCursor != null) {
            this.mongoCursor.close();
        }
    }
}
