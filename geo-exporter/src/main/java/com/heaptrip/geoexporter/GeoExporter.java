package com.heaptrip.geoexporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.heaptrip.geoexporter.entity.mysql.City;

public class GeoExporter {

private static String cityFiles = "file.city";
	
	private static String argParseCVS = "parse";
	private static String argExport = "export";

	private static Database database;
	
	public static void main(String[] args) {
		try {
			
			Properties prop = new Properties();
    		prop.load(new FileInputStream("config.properties"));
 
    		if (args[0].equals(argParseCVS)) {
				
				File file = new File(prop.getProperty(cityFiles));  
				File[] files = file.listFiles();  
				
				if (files.length > 0) { 
					
					database = new Database();
					database.connectToMySql(prop);
					
					System.out.println("parse cvs started");
					
					for (int fileInList = 0; fileInList < files.length; fileInList++)  
					{  
						System.out.println("file = " + files[fileInList].toString());
						parseCityCSV(files[fileInList]);
					}  
					
					database.closeConnectionToMySQL();
					
					System.out.println("parse cvs finished");
				} else {
					System.out.println("cvs files not found");
				}
    		} else if (args[0].equals(argExport)) {
    			
    			database = new Database();
				database.connectToMongo(prop);
				database.connectToMySql(prop);
				
				database.exportCountryToMongo();
				database.exportRegionToMongo();
				database.exportCityToMongo();
				
				database.closeToMongo();
				database.closeConnectionToMySQL();
    		}
		} catch (Exception e){
			System.err.println("Exception: " + e.getMessage());
		}
	}
	
	private static void parseCityCSV(File file) throws IOException, SQLException {
		ICsvBeanReader beanReader = null;
        try {
        		beanReader = new CsvBeanReader(new FileReader(file), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
                
                final String[] header = beanReader.getHeader(false);
                final CellProcessor[] processors = Processor.getCellProcessors();
                
                City city;
                while( (city = beanReader.read(City.class, header, processors)) != null ) {
                        System.out.println(String.format("lineNo=%s, rowNo=%s, customer=%s", 
                        									beanReader.getLineNumber(),
                        									beanReader.getRowNumber(), 
                        									city));
                        database.insertCityToMySQL(city);
                }
        }
        finally {
                if( beanReader != null ) {
                        beanReader.close();
                }
        }
	}
}