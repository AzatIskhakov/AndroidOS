package com.harman.apiserv;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.harman.apiserv.services.sfp.Place;

public class BusinessManager {
	
	private static final Logger log = Logger.getLogger(BusinessManager.class.getName());
	private static BusinessManager INSTANCE = new BusinessManager();
	
	private static BusinessManager INSTATNCE = new BusinessManager();
	
	public static BusinessManager getInstance() {
		return INSTATNCE;
	}
	
private BusinessManager() {
		
	}

public Place getPlace(int pointX, int pointY) {
	
	log.info("BusinessManager::findUser started");
	
	Place place = new Place();
	
	place.setPointX(150);
	place.setPointY(100);
	place.setColor(0);
	
	return place;
}

public List<Place> getPlaces() {
	
	List<Place> places = new ArrayList<Place>();
	
	Place place1 = new Place();
	place1.setPointX(150);
	place1.setPointY(100);
	place1.setColor(0);
	
	Place place2 = new Place();
	place2.setPointX(150);
	place2.setPointY(250);
	place2.setColor(255);
	
	places.add(place1);
	places.add(place2);
	
	return places;
//	return DataManager.getInstance().findAllUsers();
}

public Place addPlace(Place place) {
	
//	Place newPlace = DataManager.getInstance().insertUser(place);
	place.setPointX(255);
	place.setColor(89);
	
	return place;
}

public Place updateColorAttribute(int pointX, int pointY, String attribute, int color) {
	
	Place place = new Place();
	place.setPointX(pointX);
	place.setPointY(pointY);
	
	if(attribute.equals("color")) {
		place.setColor(color);
	}
	
	return place;
	
//     return DataManager.getInstance().updateColorAttribute(pointX, pointY, attribute, color);  
}

}
