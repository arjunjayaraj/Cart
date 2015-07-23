package com.Cart.start.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties
public class Filter implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 9043062042905534249L;
private String search;
private String ageGroup;
private List<String> brand;
private List<Integer> category;
private double maximumPrice;
private Integer availability;


public double getMaximumPrice() {
	return maximumPrice;
}
public void setMaximumPrice(double maximumPrice) {
	this.maximumPrice = maximumPrice;
}
public Integer getAvailability() {
	return availability;
}
public void setAvailability(Integer availability) {
	this.availability = availability;
}



public List<Integer> getCategory() {
	return category;
}
public void setCategory(List<Integer> category) {
	this.category = category;
}
public String getSearch() {
	return search;
}
public void setSearch(String search) {
	this.search = search;
}
public String getAgeGroup() {
	return ageGroup;
}
public void setAgeGroup(String ageGroup) {
	this.ageGroup = ageGroup;
}
public List<String> getBrand() {
	return brand;
}
public void setBrand(List<String> brand) {
	this.brand = brand;
}



}
