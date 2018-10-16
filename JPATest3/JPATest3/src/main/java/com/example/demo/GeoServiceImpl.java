package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
class GeoServiceImpl implements GeoService {
	
	private GeoDaoImpl gdi;
	
	public GeoDaoImpl getGdi() {
		return gdi;
	}
	
	@Autowired
	public void setGdi(GeoDaoImpl gdi) {
		this.gdi = gdi;
	}

	public GeoServiceImpl() {
		super();
	}

	@Override
	public void persistGeoEntity(GeoEntity ge) {
		gdi.persistGeoEntity(ge);
	}
	
	@Override
	public GeoEntity findGeoEntityByID(Long id) {
		return gdi.findGeoEntityByID(id);
	}
}
