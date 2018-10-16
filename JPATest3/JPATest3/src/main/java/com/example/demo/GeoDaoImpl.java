package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
class GeoDaoImpl implements GeoDao {
	
	GeoRepository gr;
	
	public GeoRepository getGr() {
		return gr;
	}
	
	@Autowired
	public void setGr(GeoRepository gr) {
		this.gr = gr;
	}

	@Override
	public void persistGeoEntity(GeoEntity ge) {
		gr.save(ge);
	}
	
	@Override
	public GeoEntity findGeoEntityByID(Long id) {
		return gr.findById(id).get();
	}
}
