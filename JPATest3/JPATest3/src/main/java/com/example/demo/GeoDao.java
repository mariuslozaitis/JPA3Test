package com.example.demo;

interface GeoDao {
	void persistGeoEntity(GeoEntity ge);
	GeoEntity findGeoEntityByID(Long id);
}
