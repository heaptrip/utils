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
			city.setParent(country.getId());
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
