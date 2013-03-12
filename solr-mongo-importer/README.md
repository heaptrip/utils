# Solr Mongo Importer
Welcome to the Solr Mongo Importer project. This project provides MongoDb support for the Solr Data Import Handler. 
This project is based on [SolrMongoImporter] (https://github.com/james75/SolrMongoImporter). The main difference - you can work with a replica.

## Features
* Retrive data from a MongoDb collection
* Authenticate using MongoDb authentication
* Map Mongo fields to Solr fields

## Classes

* MongoDataSource - Provides a MongoDb datasource
    * database (**required**) - The name of the data base you want to connect to
    * urls     (*optional* - default: localhost:27017)
    * username (*optional*)
    * password (*optional*)
* MongoEntityProcessor - Use with the MongoDataSource to query a MongoDb collection
    * collection (**required**)
    * query (**required**)
* MongoMapperTransformer - Map MongoDb fields to your Solr schema
    * mongoField (**required**)

## Installation
1. Firstly you will need a copy of the Solr Mongo Importer jar.
2. You will also need the [Mongo Java driver JAR]   (https://github.com/mongodb/mongo-java-driver/downloads)
3. Place both of these jar's in your Solr libaries folder ( I put mine in 'dist' folder with the other jar's)
4. Add lib directives to your solrconfig.xml

```xml
    <lib path="../../dist/solr-mongo-importer.jar" />
    <lib path="../../dist/mongo.jar" />
```

##Usage
Here is a sample data-config.xml showing the use of all components

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<dataConfig>
     <dataSource name="heaptrip" 
	type="org.apache.solr.handler.dataimport.MongoDataSource" 
	urls="5.61.36.145:27017, 5.61.32.48:27017" 
	database="heaptrip"
	username="heaptrip" 
	password="Qazwsx321" />
     <document>
         <entity name="geoName" 
		processor="org.apache.solr.handler.dataimport.MongoEntityProcessor"
		transformer="org.apache.solr.handler.dataimport.MongoMapperTransformer"
		datasource="heaptrip"                
		collection="geo"
		query="{'Active':1}" >
             <field mongoField="_id" column="id" />
	     <field mongoField="nazvanie_1" column="text_ru"/>
	     <field mongoField="nazvanie_2" column="text_en"/>             
          </entity>
     </document>
 </dataConfig>
 ```
