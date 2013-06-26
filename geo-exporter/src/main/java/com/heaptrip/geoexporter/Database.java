package com.heaptrip.geoexporter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.heaptrip.geoexporter.entity.mongo.ExtendedRegion;
import com.heaptrip.geoexporter.entity.mongo.MultiLangText;
import com.heaptrip.geoexporter.entity.mongo.Region;
import com.heaptrip.geoexporter.entity.mongo.RegionEnum;
import com.heaptrip.geoexporter.entity.mysql.City;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class Database {

	private Connection mysqlConnect = null;
	private Statement mysqlStatement = null;
	
	private static String MySQL_url = "mysql.url";
	private static String MySQL_db = "mysql.db";
	private static String MySQL_driver = "mysql.driver";
	private static String MySQL_user = "mysql.user";
	private static String MySQL_pswd = "mysql.pswd";
	
	private MongoClient mongoClient = null;
	private DB db = null;
	private Jongo jongo = null;
	private MongoCollection regions = null;
	
	private static String Mongo_url = "mongodb.url";
	private static String Mongo_db = "mongodb.db";
	private static String Mongo_user = "mongodb.user";
	private static String Mongo_pswd = "mongodb.pswd";
	private static String Mongo_type_server = "mongodb.typeserver";
	
	public Database() {
	}
	
	public void connectToMySql(Properties prop) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Class.forName(prop.getProperty(MySQL_driver)).newInstance();
		mysqlConnect = DriverManager.getConnection(prop.getProperty(MySQL_url) + prop.getProperty(MySQL_db), prop.getProperty(MySQL_user), prop.getProperty(MySQL_pswd));
		mysqlStatement = mysqlConnect.createStatement();
	}
	
	public void connectToMongo(Properties prop) throws Exception {
		
		if (prop.getProperty(Mongo_type_server).compareTo("test") == 0) {
			
			mongoClient = new MongoClient(Arrays.asList(new ServerAddress(prop.getProperty(Mongo_url), 27017)));
			db = mongoClient.getDB(prop.getProperty(Mongo_db));
			jongo = new Jongo(db);
			regions = jongo.getCollection(Region.COLLECTION_NAME);
		} else if (prop.getProperty(Mongo_type_server).compareTo("production") == 0) {
			
			mongoClient = new MongoClient(Arrays.asList(new ServerAddress(prop.getProperty(Mongo_url), 27017)));
			db = mongoClient.getDB("admin");
			
			if (db.authenticate(prop.getProperty(Mongo_user), prop.getProperty(Mongo_pswd).toCharArray())) {
				db = mongoClient.getDB(prop.getProperty(Mongo_db));
				jongo = new Jongo(db);
				regions = jongo.getCollection(Region.COLLECTION_NAME);
			} else {
				throw new Exception("Error mongo connection ");
			}
		}
	}
	
	public void exportCountryToMongo() throws SQLException {
		PreparedStatement statement = null;
		ResultSet result = null;
		ExtendedRegion region;
		
		statement = mysqlConnect.prepareStatement("SELECT id, naselenie, nazvanie_1, nazvanie_2 FROM strana");
		result = statement.executeQuery();
		
		while (result.next()) {
			System.out.println("id=" + result.getString("id") + " nazvanie_1=" + result.getString("nazvanie_1"));
			
			region = new ExtendedRegion();
			region.setName(new MultiLangText(result.getString("nazvanie_1"), result.getString("nazvanie_2")));
			region.setPath(new MultiLangText(result.getString("nazvanie_1"), result.getString("nazvanie_2")));
			region.setGeoWNId(result.getString("id"));
			region.setPopulation(result.getInt("naselenie"));
			region.setType(RegionEnum.COUNTRY);			
			regions.insert(region);
		}
		result.close();
		statement.close();
	}
	
	public void exportRegionToMongo() throws SQLException {
		PreparedStatement statement = null;
		ResultSet result = null;
		ExtendedRegion country;
		ExtendedRegion region;
		
		Object[] parameters = new Object[2];
		parameters[0] = RegionEnum.COUNTRY;
		String[] ancestors = new String[1];
				
		statement = mysqlConnect.prepareStatement("SELECT r.id, r.naselenie, r.strana_id, r.nazvanie_1 AS region_name_ru, r.nazvanie_2 AS region_name_en " +
													"FROM region r " +
													"WHERE r.uroven < 2 AND ((r.strana_id IN (25, 107, 58, 152, 167, 78, 170)) OR (r.strana_id = 1 AND r.tip <> 1))");
		result = statement.executeQuery();
		
		while (result.next()) {
			System.out.println("id=" + result.getString("id") + " region_name_ru=" + result.getString("region_name_ru"));
			parameters[1] = result.getString("strana_id");
			
			country = regions.findOne("{'type': #, 'geoWNId': #}", parameters).as(ExtendedRegion.class);
			ancestors[0] = country.getId();
			System.out.println("country id=" + country.getId());
			
			region = new ExtendedRegion();
			region.setParent(country.getId());
			region.setPath(new MultiLangText(country.getName().get("ru") + ", " + result.getString("region_name_ru"), country.getName().get("en") + ", " + result.getString("region_name_en")));
			region.setAncestors(ancestors);
			region.setName(new MultiLangText(result.getString("region_name_ru"), result.getString("region_name_en")));
			region.setGeoWNId(result.getString("id"));
			region.setPopulation(result.getInt("naselenie"));
			region.setType(RegionEnum.AREA);			
			regions.insert(region);
		}
		result.close();
		statement.close();
	}
	
	public void exportCityToMongo() throws SQLException {
		PreparedStatement statement = null;
		ResultSet result = null;
		ExtendedRegion country = null;
		ExtendedRegion region = null;
		ExtendedRegion city = null;
		
		Object[] country_parameters = new Object[2];
		country_parameters[0] = RegionEnum.COUNTRY;
		
		Object[] region_parameters = new Object[2];
		region_parameters[0] = RegionEnum.AREA;
		
		String[] ancestors = new String[2];
		String[] ancestor = new String[1];
		
		statement = mysqlConnect.prepareStatement("SELECT g.id, g.strana_id, g.region1_id, g.naselenie, g.nazvanie_1 AS city_name_ru, g.nazvanie_2 AS city_name_en " + 
													"FROM gorod g " + 
													"WHERE g.strana_id IN (1, 25, 107, 58, 152, 167, 78, 170)");
		result = statement.executeQuery();
		
		while (result.next()) {
			System.out.println("id=" + result.getString("id") + " city_name_ru=" + result.getString("city_name_ru"));
			
			if (country == null || !country.getGeoWNId().equals(result.getString("strana_id"))) {
				country_parameters[1] = result.getString("strana_id");
				country = regions.findOne("{'type': #, 'geoWNId': #}", country_parameters).as(ExtendedRegion.class);
				if (country == null) {
					System.out.println("country id=" + country_parameters[1] + " not found");
					continue;
				}
				ancestors[0] = country.getId();
			}
			
			if (region == null || !region.getGeoWNId().equals(result.getString("region1_id"))) {
				region_parameters[1] =  result.getString("region1_id");
				region = regions.findOne("{'type': #, 'geoWNId': #}", region_parameters).as(ExtendedRegion.class);
				if (region == null) {
					System.out.println("region id=" + region_parameters[1] + " not found");
					continue;
				}
				ancestors[1] = region.getId();
			}
			
			city = new ExtendedRegion();
			city.setParent(region.getId());
			city.setPath(new MultiLangText(country.getName().get("ru") + ", " + region.getName().get("ru") + ", " + result.getString("city_name_ru"), 
					country.getName().get("en") + ", " + region.getName().get("en") + ", " + result.getString("city_name_en")));
			city.setAncestors(ancestors);
			city.setName(new MultiLangText(result.getString("city_name_ru"), result.getString("city_name_en")));
			city.setGeoWNId(result.getString("id"));
			city.setPopulation(result.getInt("naselenie"));
			city.setType(RegionEnum.CITY);			
			regions.insert(city);
		}
		result.close();
		statement.close();
				
		statement = mysqlConnect.prepareStatement("SELECT g.id, g.strana_id, g.naselenie, g.nazvanie_1 AS city_name_ru, g.nazvanie_2 AS city_name_en " + 
													"FROM gorod g " + 
													"WHERE g.strana_id NOT IN (1, 25, 107, 58, 152, 167, 78, 170)");
		result = statement.executeQuery();
		
		while (result.next()) {
			System.out.println("id=" + result.getString("id") + " city_name_ru=" + result.getString("city_name_ru"));
			
			if (country == null || !country.getGeoWNId().equals(result.getString("strana_id"))) {
				country_parameters[1] = result.getString("strana_id");
				country = regions.findOne("{'type': #, 'geoWNId': #}", country_parameters).as(ExtendedRegion.class);
				ancestor[0] = country.getId();
				System.out.println("country id=" + country.getId());
			}
			
			city = new ExtendedRegion();
			city.setParent(region.getId());
			city.setPath(new MultiLangText(country.getName().get("ru") + ", " + result.getString("city_name_ru"), 
					country.getName().get("en") + ", " + result.getString("city_name_en")));
			city.setAncestors(ancestor);
			city.setName(new MultiLangText(result.getString("city_name_ru"), result.getString("city_name_en")));
			city.setGeoWNId(result.getString("id"));
			city.setPopulation(result.getInt("naselenie"));
			city.setType(RegionEnum.CITY);			
			regions.insert(city);
		}
		result.close();
		statement.close();
		
//		statement = mysqlConnect.prepareStatement("SELECT g.id, g.region_id, g.strana_id, g.nazvanie_1 AS city_name_ru, g.nazvanie_2 AS city_name_en " + 
//													"FROM gorod g " + 
//													"JOIN region r ON r.id = g.region_id");
//		result = statement.executeQuery();
//		
//		while (result.next()) {
//			System.out.println("id=" + result.getString("id") + " city_name_ru=" + result.getString("city_name_ru"));
//			country_parameters[1] = result.getString("strana_id");
//			country = regions.findOne("{'type': #, 'geoWNId': #}", country_parameters).as(ExtendedRegion.class);
//			ancestors[0] = country.getId();
//			System.out.println("country id=" + country.getId());
//
//			region_parameters[1] =  result.getString("region_id");
//			region = regions.findOne("{'type': #, 'geoWNId': #}", region_parameters).as(ExtendedRegion.class);
//			ancestors[1] = region.getId();
//			System.out.println("region id=" + region.getId());
//			
//			city = new ExtendedRegion();
//			city.setParent(region.getId());
//			city.setPath(new MultiLangText(country.getName().get("ru") + ", " + region.getName().get("ru") + ", " + result.getString("city_name_ru"), 
//											country.getName().get("en") + ", " + region.getName().get("en") + ", " + result.getString("city_name_en")));
//			city.setAncestors(ancestors);
//			city.setName(new MultiLangText(result.getString("city_name_ru"), result.getString("city_name_en")));
//			city.setGeoWNId(result.getString("id"));
//			city.setType(RegionEnum.CITY);			
//			regions.insert(city);
//		}
//		result.close();
//		statement.close();
	}
	
	public void exportToMongo() throws SQLException {
//		PreparedStatement statement = null;
//		ResultSet result = null;
//		BasicDBObject doc = null;
//		ArrayList<BasicDBObject> values = null;
		
//		statement = mysqlConnect.prepareStatement("SELECT id, samonazvanie, telefon, shirota_gradus, shirota_minuta, shirota_sekunda, " +
//															" dolgota_gradus, dolgota_minuta, dolgota_sekunda, nazvanie_1, nazvanie_2 " +
//													" FROM strana");
//		// country
//		result = statement.executeQuery();
//		while (result.next()) {
//			System.out.println("id" + result.getString("id") +
//								" samonazvanie" + result.getString("samonazvanie"));
//			
//			doc = new BasicDBObject("id", result.getString("id")).
//				                    append("samonazvanie", result.getString("samonazvanie")).
//				                    append("telefon", result.getString("telefon")).
//				                    append("shirota_gradus", result.getString("shirota_gradus")).
//				                    append("shirota_minuta", result.getString("shirota_minuta")).
//				                    append("shirota_sekunda", result.getString("shirota_sekunda")).
//				                    append("dolgota_gradus", result.getString("dolgota_gradus")).
//				                    append("dolgota_minuta", result.getString("dolgota_minuta")).
//				                    append("dolgota_sekunda", result.getString("dolgota_sekunda")).
//				                    append("nazvanie_1", result.getString("nazvanie_1")).
//				                    append("nazvanie_2", result.getString("nazvanie_2")).
//				                    append("ancestors", new ArrayList<BasicDBObject>()).
//				                    append("parent", null);
//			coll.insert(doc);
//		}
//		result.close();
//		statement.close();
//		
//		// region
//		statement = mysqlConnect.prepareStatement("SELECT r.id, r.vkl, r.tip, r.strana_id, r.samonazvanie, r.shirota_gradus, r.shirota_minuta, r.shirota_sekunda, " +
//						" r.dolgota_gradus, r.dolgota_minuta, r.dolgota_sekunda, r.nazvanie_1, r.nazvanie_2 " +
//						" FROM region r " +
//						" LEFT JOIN strana s ON s.id = r.strana_id " + 
//						" WHERE r.id NOT IN (SELECT rr.id FROM region rr WHERE rr.strana_id = 1 AND (rr.tip = 0 OR rr.tip = 1)) " +
//						" ORDER BY r.strana_id, r.tip");
//		result = statement.executeQuery();
//		while (result.next()) {
//			System.out.println("id" + result.getString("id") +
//			" samonazvanie" + result.getString("samonazvanie"));
//			
//			doc = new BasicDBObject("id", result.getString("id")).
//									append("vkl", result.getString("vkl")).
//									append("tip", result.getString("tip")).
//									append("strana_id", result.getString("strana_id")).
//									append("samonazvanie", result.getString("samonazvanie")).
//									append("shirota_gradus", result.getString("shirota_gradus")).
//									append("shirota_minuta", result.getString("shirota_minuta")).
//									append("shirota_sekunda", result.getString("shirota_sekunda")).
//									append("dolgota_gradus", result.getString("dolgota_gradus")).
//									append("dolgota_minuta", result.getString("dolgota_minuta")).
//									append("dolgota_sekunda", result.getString("dolgota_sekunda")).
//									append("nazvanie_1", result.getString("nazvanie_1")).
//									append("nazvanie_2", result.getString("nazvanie_2")).
//									append("ancestors", new ArrayList<BasicDBObject>().add(new BasicDBObject("id", result.getString("strana_id")))).
//									append("parent", new BasicDBObject("id", result.getString("strana_id")));
//			coll.insert(doc);
//		}
//		result.close();
//		statement.close();
		
//		// city
//		statement = mysqlConnect.prepareStatement("SELECT g.id, g.id_gn, g.strana_id, g.region_id, g.samonazvanie, g.shirota_gradus, g.shirota_minuta, g.shirota_sekunda, " +
//						" g.dolgota_gradus, g.dolgota_minuta, g.dolgota_sekunda, g.nazvanie_1, g.nazvanie_2 " +
//						" FROM gorod g " +
//						" JOIN strana s ON s.id = g.strana_id " + 
//						" JOIN region r ON r.id = g.region_id " +
//						" ORDER BY g.strana_id, g.region_id");
//		statement.setFetchSize(Integer.MIN_VALUE);
//		result = statement.executeQuery();
//		while (result.next()) {
//			System.out.println("id=" + result.getString("id") + " samonazvanie=" + result.getString("samonazvanie"));
//			
//			values = new ArrayList<BasicDBObject>();
//			values.add(new BasicDBObject("id", result.getString("strana_id"))); 
//			values.add(new BasicDBObject("id", result.getString("region_id")));
//			
//			doc = new BasicDBObject("id", result.getString("id")).
//									append("id_gn", result.getString("id_gn")).
//									append("region_id", result.getString("region_id")).
//									append("strana_id", result.getString("strana_id")).
//									append("samonazvanie", result.getString("samonazvanie")).
//									append("shirota_gradus", result.getString("shirota_gradus")).
//									append("shirota_minuta", result.getString("shirota_minuta")).
//									append("shirota_sekunda", result.getString("shirota_sekunda")).
//									append("dolgota_gradus", result.getString("dolgota_gradus")).
//									append("dolgota_minuta", result.getString("dolgota_minuta")).
//									append("dolgota_sekunda", result.getString("dolgota_sekunda")).
//									append("nazvanie_1", result.getString("nazvanie_1")).
//									append("nazvanie_2", result.getString("nazvanie_2")).
//									append("ancestors", new ArrayList<BasicDBObject>().addAll(values)).
//									append("parent", new BasicDBObject("region_id", result.getString("region_id")));
//			coll.insert(doc);
//		}
//		result.close();
//		statement.close();
	}
	
	public void insertCityToMySQL(City city) throws SQLException {
		if (city.getNazvanie_1() == null) { 
			return;
		}
			
		mysqlStatement.executeUpdate("INSERT INTO gorod (id, vkl, id_gn, samonazvanie, region_id, region1_id, region2_id, region3_id, strana_id, naselenie, shirota, dolgota, " +
											"shirota_gradus, shirota_minuta, shirota_sekunda, dolgota_gradus, dolgota_minuta, dolgota_sekunda, nazvanie_1, nazvanie_2) " + 
							" VALUE ("  + city.getId() + "," +
							city.getVkl() + "," + 
							city.getId_gn() + "," + 
		    				"'" + city.getSamonazvanie() + "'" + "," +
		    				city.getRegion_id() + "," +
							city.getRegion_1() + "," +
							city.getRegion_2() + "," +
							city.getRegion_3() + "," +
		    				city.getStrana_id() + "," + 
		    				city.getNaselenie() + "," +
		    				city.getShirota() + "," +
		    				city.getDolgota() + "," +
		    				city.getShirota_gradus() + "," + 
		    				city.getShirota_minuta() + "," + 
		    				city.getShirota_sekunda() + "," + 
		    				city.getDolgota_gradus() + "," + 
		    				city.getDolgota_minuta() + "," + 
		    				city.getDolgota_sekunda() + "," + 
		    				"'" + city.getNazvanie_1() + "'" + "," +
		    				"'" + city.getNazvanie_2() + "'" + ")");
	}
	
	public void closeConnectionToMySQL() {
		try {
			mysqlConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeToMongo() {
		mongoClient.close();
	}
}
