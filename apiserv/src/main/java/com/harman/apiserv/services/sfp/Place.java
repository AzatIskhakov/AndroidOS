package com.harman.apiserv.services.sfp;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "place")

public class Place implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "pointX")
	private int pointX;
	
	@XmlElement(name = "pointY")
	private int pointY;
	
	@XmlElement(name = "color")
	private int color;

	public int getPointX() {
		return pointX;
	}

	public void setPointX(int pointX) {
		this.pointX = pointX;
	}

	public int getPointY() {
		return pointY;
	}

	public void setPointY(int pointY) {
		this.pointY = pointY;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
}
