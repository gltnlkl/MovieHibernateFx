package com.gulukal.project;

import com.gulukal.project.control.MovieEntityController;
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

	public void findMovieById() {

		mcont.findById(1L);

	}

	public void findMovieByTitle() {

		String title = "How I Became a Developer?";

		mcont.find(title);

	}

}
