package com.packtpub.springmvc.chocolatestore.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.packtpub.springmvc.chocolatestore.app.AppImpl;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.packtpub.springmvc.chocolatestore")
@EnableJpaRepositories
@EnableTransactionManagement
public class ApplicationConfig {

	@Autowired
    private Environment env;

	@Bean(name="myApp")
    public AppImpl myApp() {
		System.out.println("--- myApp");
        return new AppImpl();
    }

	@Bean
	public PlatformTransactionManager transactionManager() {
		System.out.println("--- transactionManager");
		EntityManagerFactory factory = entityManagerFactory().getObject();
		return new JpaTransactionManager(factory);
	}

	@Bean
	public DataSource dataSource() {
		System.out.println(">>> dataSource");
		BasicDataSource dataSource = new BasicDataSource();
		String jv1 = env.getProperty("db.driver");
		System.out.println("jv1 :"+jv1+":");
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		System.out.println("<<< dataSource");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		System.out.println(">>> entityManagerFactory");
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		System.out.println("entityManagerFactory - stage 1");

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(Boolean.TRUE);
		vendorAdapter.setShowSql(Boolean.TRUE);
		System.out.println("entityManagerFactory - stage 2");

		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.packtpub.springmvc.chocolatestore");
		System.out.println("entityManagerFactory - stage 3");

		Properties jpaProperties = new Properties();
		System.out.println("entityManagerFactory - stage 3a");
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		System.out.println("entityManagerFactory - stage 3b");
		factory.setJpaProperties(jpaProperties);
		System.out.println("entityManagerFactory - stage 3c");
		System.out.println("entityManagerFactory - stage 4");

//		factory.afterPropertiesSet();
//		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		System.out.println("<<< entityManagerFactory");
		return factory;
	}
}
