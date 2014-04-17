package org.apache.solr.handler.dataimport;

import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class MongoMapperTransformer extends Transformer {

    public static final String MONGO_FIELD = "mongoField";

    public static final String NONE_FIELD = "none";

    @Override
    public Object transformRow(Map<String, Object> row, Context context) {

        for (Map<String, String> map : context.getAllEntityFields()) {
            String mongoFieldName = map.get(MONGO_FIELD);

            if (StringUtils.isEmpty(mongoFieldName)) {
                continue;
            }

            String columnFieldName = map.get(DataImporter.COLUMN);

            if (StringUtils.isEmpty(columnFieldName) || columnFieldName.equalsIgnoreCase(NONE_FIELD)) {
                continue;
            }

            // process [mongoFieldName] in solr columnFieldName
            if (columnFieldName.indexOf("[") > 0 && columnFieldName.indexOf("]") > 0) {
                String fieldName = columnFieldName.substring(columnFieldName.indexOf("[") + 1, columnFieldName.indexOf("]"));
                if (StringUtils.isNotEmpty(fieldName)) {
                    Object fieldValue = row.get(fieldName);
                    if (fieldValue != null && fieldValue instanceof String && StringUtils.isNotEmpty((String) fieldValue)) {
                        columnFieldName = columnFieldName.substring(0, columnFieldName.indexOf("[")) + fieldValue;
                    }
                }
            }

            row.put(columnFieldName, row.get(mongoFieldName));
        }

        return row;
    }
}
