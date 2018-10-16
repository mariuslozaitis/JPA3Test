package com.example.demo;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories ("com.example.demo")
@EnableTransactionManagement
class BeansConfiguration {
	@Bean (name = "transactionManager")
    JpaTransactionManager transactionManager () {
		JpaTransactionManager jtm = new JpaTransactionManager();
		jtm.setEntityManagerFactory(entityManagerFactory().getObject());
        return jtm;
    }

	@Bean  (name = "entityManagerFactory")
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setDataSource(dataSourceFactory());
		lcemfb.setJpaVendorAdapter(vendorAdapterFactory());
		//lcemfb.setLoadTimeWeaver(getloadTimeWeaver());
		//lcemfb.setJpaDialect(getJpaDialect());
		lcemfb.setPackagesToScan("com.example.demo");
		return  lcemfb;
	}

	@Bean (name = "dataSourceFactory")
    DataSource dataSourceFactory() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/db3");
		ds.setUsername("user2");
		return ds;	        		   
    }
	
	@Bean (name = "vendorAdapterFactory")
    protected EclipseLinkJpaVendorAdapter vendorAdapterFactory() {
		EclipseLinkJpaVendorAdapter eljva = new EclipseLinkJpaVendorAdapter();
		eljva.setGenerateDdl(true);
		eljva.setShowSql(false);
        return eljva;
    }
	
    /*@Bean (name = "loadTimeWeaver")
	public LoadTimeWeaver getloadTimeWeaver() {
	    return new org.springframework.context.weaving.DefaultContextLoadTimeWeaver();
	    //return new org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver();
	}*/
    
    /*@Bean (name = "jpaDialect")
	public JpaDialect getJpaDialect() {
		return new EclipseLinkJpaDialect();
	}*/
}

