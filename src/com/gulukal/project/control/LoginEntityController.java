package com.gulukal.project.control;

import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.gulukal.project.entity.LoginEntity;

public class LoginEntityController implements Controllable<LoginEntity> {

	  
	@Override
	public void add(LoginEntity entity) {
		
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
	public void delete(LoginEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(LoginEntity entity) {
		// TODO Auto-generated method stub

	}
	

	public Optional<LoginEntity> find(String mail, String password) {
		try {
			Session session = databaseConnectionHibernate();
			String  hql     = "select u from LoginEntity as u where u.mail=:uMail and u.password=:pwd";  
			TypedQuery<LoginEntity> typedQuery = session.createQuery(hql, LoginEntity.class);

			typedQuery.setParameter("uMail", mail.trim());
			typedQuery.setParameter("pwd", password);

			Optional<LoginEntity> user = Optional.of(typedQuery.getSingleResult());

			System.out.println(this.getClass().getSimpleName() + " - User found <<<" + user.get().getId() + ">>>");
			return user;
		}
		catch (Exception e) {
			System.err.println(this.getClass().getSimpleName() + " - " + e.getLocalizedMessage());
		}
		return Optional.empty();
	}

}
