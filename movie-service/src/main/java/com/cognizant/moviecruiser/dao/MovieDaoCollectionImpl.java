package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;
@Component("movieDao")
public class MovieDaoCollectionImpl implements MovieDao {
	private static List<Movie> movieList = null;

	public MovieDaoCollectionImpl() {
		super();
		ApplicationContext context = new ClassPathXmlApplicationContext("moviecruiser.xml");
		try {
			if (movieList == null) {
				movieList = (ArrayList) context.getBean("movieList");
			}
		} catch (Exception e) {
		}
	}

	@Override
	public List<Movie> getMovieListAdmin() {
		return movieList;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		ArrayList<Movie> arrayList = new ArrayList<Movie>();
		Date currdate = null;
		try {
			currdate = DateUtil.convertToDate("16/04/2020");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Movie movie : movieList) {
			if (currdate.compareTo(movie.getDateOfLaunch()) >= 0 && movie.isActive()) {
				arrayList.add(movie);
			}
		}
		return arrayList;
	}

	@Override
	public void modifyMovie(Movie movie) {
		for (Movie movies : movieList) {
			if (movie.getId() == movies.getId()) {
				movies.setTitle(movie.getTitle());
				movies.setActive(movie.isActive());
				movies.setHasTeaser(movie.isHasTeaser());
				movies.setGenre(movie.getGenre());
				movies.setBoxOffice(movie.getBoxOffice());
				movies.setDateOfLaunch(movie.getDateOfLaunch());
				break;
			}
		}
	}

	@Override
	public Movie getMovie(long movieId) {
		for (Movie movie : movieList) {
			if(movie.getId()==movieId) {
				return movie;
			}
		}
		return null;
	}
}
