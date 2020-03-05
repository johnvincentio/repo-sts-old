package com.idc.hes.config;

import java.util.Locale;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.context.ThemeSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.idc.hes.dao.StudentDAO;
import com.idc.hes.dao.UserDAO;
import com.idc.hes.dao.UserDAOImpl;
import com.idc.hes.model.Student;
import com.idc.hes.model.User;

@Configuration
@ComponentScan("com.idc.hes")
@EnableTransactionManagement
@EnableWebMvc
public class AppConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	/* Theme specific start */
	@Bean
	public ThemeSource themeSource() {
		ResourceBundleThemeSource source = new ResourceBundleThemeSource();
		source.setBasenamePrefix("hello-");		// hello-{theme-name}.properties
		return source;
	}

	@Bean
	public ThemeResolver themeResolver() {
		CookieThemeResolver resolver = new CookieThemeResolver();
		resolver.setCookieMaxAge(2400);
		resolver.setCookieName("mythemecookie");
		resolver.setDefaultThemeName("theme1");		// sets default theme name
		return resolver;
	}

	/* End */

	/* Internationalization and Localization specific: start */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/i18/usermsg");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		resolver.setCookieName("myLocaleCookie");
		resolver.setCookieMaxAge(4800);
		return resolver;
	}

	/* End */

	// Register interceptors
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// Internationalization and Localization specific
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("mylocale");
		registry.addInterceptor(interceptor);

		// Theme specific
		ThemeChangeInterceptor themeInterceptor = new ThemeChangeInterceptor();
		themeInterceptor.setParamName("mytheme");
		registry.addInterceptor(themeInterceptor);
	}

	// Used to access CSS resource
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/student_1");
		dataSource.setUsername("student_1");
		dataSource.setPassword("student_1");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(User.class);
		sessionBuilder.addAnnotatedClasses(Student.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean(name = "studentDao")
	public StudentDAO getStudentDao(SessionFactory sessionFactory) {
		return new StudentDAO(sessionFactory);
	}

	@Autowired
	@Bean(name = "userDao")
	public UserDAO getUserDao(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}
}
