package com.gulukal.project.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Movie {

	private Long         movieId;
	private String       title;
	private int          year;
	private String       genres;
	private List<Rating> ratings = new ArrayList<>();
	private List<Tag>    tags    = new ArrayList<>();

}
