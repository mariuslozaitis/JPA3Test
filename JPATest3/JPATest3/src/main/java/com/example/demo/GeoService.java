package com.example.demo;

interface GeoService {
	void persistGeoEntity(GeoEntity ge);
	GeoEntity findGeoEntityByID(Long id);
}
