package com.gulukal.project.control;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.gulukal.project.entity.Controllable;
import com.gulukal.project.entity.MovieEntity;
import com.gulukal.project.model.Movie;

public class MovieEntityController implements Controllable<MovieEntity> {

	@Override
	public void add(MovieEntity entity) {
		try {

			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			System.out.println(session);
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("ekleme tamamdir" + Controllable.class);

		}
		catch (Exception e) {
			System.out.println("ekleme aninda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}

	}

	@Override
	public void delete(MovieEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(MovieEntity entity) {
		// TODO Auto-generated method stub

	}

	public MovieEntity findTry(String str) {

		Session session = databaseConnectionHibernate();

		String hql = "select str from MovieEntity as str where str.title like '%key%' ";

		TypedQuery<MovieEntity> typedQuery = session.createQuery(hql, MovieEntity.class);

		typedQuery.setParameter("key", "str");
		typedQuery.setMaxResults(1); // limit 1

		MovieEntity movie = typedQuery.getSingleResult();

		return movie;
	}

	@Override
	public MovieEntity find(String str) {

		Session session = databaseConnectionHibernate();

		String hql = "select str from MovieEntity as str where str.title=:key";

		TypedQuery<MovieEntity> typedQuery = session.createQuery(hql, MovieEntity.class);

		typedQuery.setParameter("key", str);
		typedQuery.setMaxResults(1); // limit 1

		MovieEntity movie = typedQuery.getSingleResult();

		return movie;
	}

	public MovieEntity findById(long id) {

		Session session = databaseConnectionHibernate();

		String hql = "select str from MovieEntity as str where str.movieId=:key";

		TypedQuery<MovieEntity> typedQuery = session.createQuery(hql, MovieEntity.class);

		typedQuery.setParameter("key", id);
		
		typedQuery.setMaxResults(1); // limit 1

		MovieEntity movie = typedQuery.getSingleResult();

		System.out.println(movie);

		return movie;
	}

}