package com.harman.apiserv.services.sfp;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "places")

public class PlacesHolder implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "pointX")
	private List<Place> places;
	
	public List<Place> getPlaces() {
		return places;
	}
	
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
}
