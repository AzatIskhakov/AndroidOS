package com.harman.apiserv;

import org.apache.log4j.Logger;

import com.harman.apiserv.services.sfp.Place;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class DataManager {

	private static final Logger log = Logger.getLogger(DataManager.class.getName());
	
	private static DB japiDB;
	
	private static DBCollection placeCollection;
	
	private static DataManager INSTANCE;
	
	public static DataManager getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new DataManager();
		}
		
		return INSTANCE;
	}
	
	private DataManager() {
		
		try {
			MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
			
			japiDB = mongoClient.getDB("apiserv");
			
			placeCollection = japiDB.getCollection("places");
			
		} catch (Exception e) {
			log.error("db connection error e=", e);
		}
	}

//
//	public Place insertPlace(Place place) {
//			
//			
//			BasicDBObject doc = new BasicDBObject();
//			
//			doc.put("pointX", place.getPointX());
//			
//			placeCollection.insert(doc);
//			
//			doc.put("pointY", place.getPointY());
//			placeCollection.insert(doc);
//			
//			doc.put("color", place.getColor());
//			placeCollection.insert(doc);
//
//			return place;
//		}
//	
	
//	
//	public Place updateColorAttribute(int pointX, int pointY, String attribute, int color) {
//		
//			int updateColor = color;
//		
//			BasicDBObject doc = new BasicDBObject();
//		
//			doc.append("$set", new BasicDBObject().append(attribute, updateColor));
//		
//		
//		return ;
//	}
	
}
