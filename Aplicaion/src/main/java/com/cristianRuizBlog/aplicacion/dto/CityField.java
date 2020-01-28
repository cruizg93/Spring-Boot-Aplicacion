package com.cristianRuizBlog.aplicacion.dto;

public class CityField {

	private Long countryID;
	
	private Long cityID;

	public CityField(Long countryID, Long cityID) {
		this.countryID = countryID;
		this.cityID = cityID;
	}

	public Long getCountryID() {
		return countryID;
	}

	public void setCountryID(Long countryID) {
		this.countryID = countryID;
	}

	public Long getCityID() {
		return cityID;
	}

	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}

	@Override
	public String toString() {
		return "CityField [countryID=" + countryID + ", cityID=" + cityID + "]";
	}
	
	
}
