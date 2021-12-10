package com.gulukal.project.control;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.gulukal.project.entity.Controllable;
import com.gulukal.project.model.Movie;

public class deneme implements Controllable<Movie> {

	@Override
	public void create(Movie entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			System.out.println(session);
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("ekleme tamamdır" + Controllable.class);
		} catch (Exception e) {
			System.out.println("ekleme an�nda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Movie entity) {

		try {
			Movie findEntity = find(entity.getMovieId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				System.out.println("Silme Ba�ar�l� " + Movie.class);
			}
		} catch (Exception e) {
			System.out.println("silme an�nda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}

	}

	@Override
	public void update(Movie entity) {
		try {
			Movie findEntity = find(entity.getMovieId());
			if (findEntity != null) {
				findEntity.setGenres(entity.getGenres());
				// findEntity.setLinks(entity.getLinks());
				// findEntity.setRatings(entity.getRatings());
				// findEntity.setTags(entity.getTags());
				findEntity.setTitle(entity.getTitle());

				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				System.out.println("G�ncelleme Ba�ar�l� " + Movie.class);
			}

		} catch (Exception e) {
			System.out.println("g�ncelleme an�nda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Movie> list() {
		Session session = databaseConnectionHibernate();

		String hql = "select str from Movie as str where str.movieId=1";
		TypedQuery<Movie> typedQuery = session.createQuery(hql, Movie.class);

		// typedQuery.setParameter("key", 0L);

		ArrayList<Movie> arrayList = (ArrayList<Movie>) typedQuery.getResultList();
		System.out.println("listelendi " + Movie.class);
		return arrayList;
	}

	@Override
	public Movie find(long id) {
		Session session = databaseConnectionHibernate();
		Movie entity;
		try {
			entity = session.find(Movie.class, id);

			if (entity != null) {
				System.out.println("bulundu... " + entity);
				session.close();
				return entity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamad� ...");
				session.close();
				return null;
			}
		} catch (Exception e) {
			System.out.println("find an�nda hata meydana geldi !!!!! " + Controllable.class);
			session.close();
			e.printStackTrace();
		}
		session.close();
		return null;
	}

	@Override
	public Movie singleResult(long id) {
		return Controllable.super.singleResult(id);
	}

}
