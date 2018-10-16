package com.example.demo;

import org.springframework.data.repository.CrudRepository;

interface GeoRepository extends CrudRepository<GeoEntity, Long> {
	
}
