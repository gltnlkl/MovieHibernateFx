package com.gulukal.project;

import com.gulukal.project.control.LoginEntityController;
import com.gulukal.project.control.MovieEntityController;
import com.gulukal.project.entity.LoginEntity;
import com.gulukal.project.entity.MovieEntity;

public class MainMethod {

	MovieEntityController mcont = new MovieEntityController();

	public void addMovie() {

		MovieEntity moveieEntity = new MovieEntity();

		moveieEntity.setTitle("How I Became a Developer?");
		moveieEntity.setYear(2021);
		moveieEntity.setGenres("Drama");

		mcont.add(moveieEntity);

	}

	public void loginUser() {

		LoginEntity loginEntity = new LoginEntity();

		LoginEntityController loginCont = new LoginEntityController();

		loginEntity.setMail("gulten@mail.com");
		loginEntity.setPassword("1234");

		loginCont.add(loginEntity);
	}

	public void findMovieById() {

		mcont.findById(1L);

	}

	public void findMovieByTitle() {

		String title = "How I Became a Developer?";

		mcont.find(title);

	}

}
