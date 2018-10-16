package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class GeoEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false, length = 50)
	private String City;
	
	@Column(nullable = false, length = 50)
	private String Country;
	
	@Column(nullable = false, length = 10)
	private Double Longitude;
	
	@Column(nullable = false, length = 10)
	private Double Latitude;
	
	public GeoEntity() {
		super();
	}

	public GeoEntity(String city, String country, Double longitude, Double latitude) {
		super();
		City = city;
		Country = country;
		Longitude = longitude;
		Latitude = latitude;
	}

	public Long getId() {
		return id;
	}
	
	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Double getLongitude() {
		return Longitude;
	}

	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}

	public Double getLatitude() {
		return Latitude;
	}

	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}
}

