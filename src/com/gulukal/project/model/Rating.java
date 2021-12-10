package com.gulukal.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Rating {

	private Long  userId;
	private Movie movieId;
	private float rating;

}
