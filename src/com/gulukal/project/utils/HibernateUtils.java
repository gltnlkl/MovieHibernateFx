package com.gulukal.project.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gulukal.project.entity.LoginEntity;
import com.gulukal.project.entity.MovieEntity;
import com.gulukal.project.entity.RatingEntity;
import com.gulukal.project.entity.TagEntity;

public class HibernateUtils {

	private static final SessionFactory sessionFactory = sessionFactory();

	private static SessionFactory sessionFactory() {
		try {
			Configuration configuration = new Configuration();

			// entity classlarimizi buraya ekleyecegiz

			configuration.addAnnotatedClass(MovieEntity.class);
			configuration.addAnnotatedClass(TagEntity.class);
			configuration.addAnnotatedClass(RatingEntity.class);
			configuration.addAnnotatedClass(LoginEntity.class);
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

			return factory;
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
