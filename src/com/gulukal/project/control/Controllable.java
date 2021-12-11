package com.gulukal.project.control;

import java.util.ArrayList;
import org.hibernate.Session;

import com.gulukal.project.utils.HibernateUtils;

public interface Controllable<T> {

	public void add(T entity);// ekleme

	public void delete(T entity);// silmek

	public void update(T entity);// guncelleme

	default ArrayList<T> list() {// listeleme
		return null;
	}

	default T find(String str) {
		return null;
	}

	default T find(long id) {
		return null;
	}

	default T singleResult(long id) {
		return null;
	}

	// govdeli method
	default Session databaseConnectionHibernate() {
		return HibernateUtils.getSessionFactory().openSession();
	}
}