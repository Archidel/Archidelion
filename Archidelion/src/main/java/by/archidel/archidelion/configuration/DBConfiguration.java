package by.archidel.archidelion.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import by.archidel.archidelion.bean.Account;
import by.archidel.archidelion.bean.User;

import static org.hibernate.cfg.Environment.*;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
@ComponentScan({ "by.archidel.archidelion.bean" })
public class DBConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		Properties props = new Properties();
		// Setting JDBC properties
		props.put(DRIVER, env.getProperty(PropertyConst.DB_DRIVER));
		props.put(URL, env.getProperty(PropertyConst.DB_URL));
		props.put(USER, env.getProperty(PropertyConst.DB_USER));
		props.put(PASS, env.getProperty(PropertyConst.DB_PASS));

		// Setting Hibernate properties
		props.put(SHOW_SQL, env.getProperty(PropertyConst.HBT_SHOW_SQL));
		props.put(HBM2DDL_AUTO, env.getProperty(PropertyConst.HBT_HBM2DDL_AUTO));
		props.put(DIALECT, env.getProperty(PropertyConst.HBT_DIALECT));

		// Setting C3P0 properties
		props.put(C3P0_MIN_SIZE, env.getProperty(PropertyConst.C3P0_MIN_SIZE));
		props.put(C3P0_MAX_SIZE, env.getProperty(PropertyConst.C3P0_MAX_SIZE));
		props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty(PropertyConst.C3P0_ACQUIRE_INCREMENT));
		props.put(C3P0_TIMEOUT, env.getProperty(PropertyConst.C3P0_TIMEOUT));
		props.put(C3P0_MAX_STATEMENTS, env.getProperty(PropertyConst.C3P0_MAX_STATEMENTS));

		factoryBean.setHibernateProperties(props);
		factoryBean.setAnnotatedClasses(User.class);
		// factoryBean.setAnnotatedClasses(Person.class);
		// factoryBean.setAnnotatedClasses(PersonLocation.class);
		factoryBean.setPackagesToScan(new String[] { "com.archidel.universe.bean" });
		return factoryBean;
	}

	/*
	 * @Bean public HibernateTransactionManager getTransactionManager() {
	 * HibernateTransactionManager transactionManager = new
	 * HibernateTransactionManager();
	 * transactionManager.setSessionFactory(getSessionFactory().getObject()); return
	 * transactionManager; }
	 */

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
}
