package com.ramesh;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class hibernateUtil {
	static SessionFactory sessionfactory = null;
	static {
		try {
			Configuration cfg = new Configuration();
			Properties myprops = new Properties();
			myprops.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			myprops.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
			myprops.put(Environment.USER, "root");
			myprops.put(Environment.PASS, "root");
			myprops.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			myprops.put(Environment.SHOW_SQL, true);
			myprops.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			myprops.put(Environment.HBM2DDL_AUTO, "update");
			cfg.setProperties(myprops);
			cfg.addAnnotatedClass(Customer.class);
			// configuration end

			StandardServiceRegistryBuilder ssrbuilder = new StandardServiceRegistryBuilder();
			ServiceRegistry sr = ssrbuilder.applySettings(cfg.getProperties()).build();
			sessionfactory = (SessionFactory) cfg.buildSessionFactory(sr);

			// start session factory

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	public static SessionFactory getSessionFactory() {
		return sessionfactory;
	}
}
