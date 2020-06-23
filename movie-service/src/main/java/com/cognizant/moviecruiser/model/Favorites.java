package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorites {

	private List<Movie> movieList;

	public Favorites(List<Movie> movieList) {
		super();
		this.movieList=movieList; 
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	@Override
	public String toString() {
		return "Favorites [movieList=" + movieList + "]";
	}
}