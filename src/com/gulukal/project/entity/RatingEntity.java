package com.gulukal.project.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table(name = "raitings")
public class RatingEntity  {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long        userId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movieId")
	@ToString.Exclude
	private MovieEntity movieId;
	private float       rating;

}
