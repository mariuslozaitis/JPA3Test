package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class JpaTest3Application {
	private static GeoServiceImpl gsi;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaTest3Application.class, args);
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(BeansConfiguration.class);
		gsi.persistGeoEntity(new GeoEntity("Vilnius", "Lithuania", 25.279652, 54.687157));
		gsi.persistGeoEntity(new GeoEntity("Riga", "Latvia", 24.105078, 56.946285));
		gsi.persistGeoEntity(new GeoEntity("Tallinn", "Estonia", 24.753574, 59.436962));
		gsi.persistGeoEntity(new GeoEntity("Warsaw", "Poland", 21.017532, 52.237049));
		gsi.persistGeoEntity(new GeoEntity("Minsk", "Belarus", 27.567444, 53.893009));
		System.out.println(">>>>>>>>> " +gsi.findGeoEntityByID(5L).getCity() +" <<<<<<<<<");
		acac.close();
	}
	
	public GeoServiceImpl getGsi() {
		return gsi;
	}
	
	@Autowired
	public void setGsi(GeoServiceImpl gsi) {
		JpaTest3Application.gsi = gsi;
	}	
}