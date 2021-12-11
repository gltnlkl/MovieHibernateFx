package com.gulukal.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "movies")
public class MovieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ToString.Exclude
	private Long              movieId;
	private String            title;
	private int               year;
	private String            genres;

	@OneToMany(mappedBy = "movieId", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)

	private List<RatingEntity> ratings = new ArrayList<>();

	@OneToMany(mappedBy = "movieId", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)

	private List<TagEntity> tags = new ArrayList<>();

	public MovieEntity(Long movieId, String title, int year, String genres) {
		super();
		this.movieId = movieId;
		this.title   = title;
		this.year    = year;
		this.genres  = genres;
	}

}
