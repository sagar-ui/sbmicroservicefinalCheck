package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;
@Component("favoritesDao")
public class FavoritesDaoCollectionImpl implements FavoritesDao {
	private static HashMap<String, Favorites> userFavorites = null;

	public FavoritesDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<String, Favorites>();
		}
	}

	@Override
	public void addFavoritesItem(long userId, long movieId) {
		String user=Long.toString(userId);
		MovieDao movieDao = new MovieDaoCollectionImpl();
		Movie movie = movieDao.getMovie(movieId);
		if (!userFavorites.containsKey(user)) {
			userFavorites.put(user, new Favorites(new ArrayList<Movie>()));
		}
		List<Movie> movieList = userFavorites.get(user).getMovieList();
		movieList.add(movie);
	}

	@Override
	public List<Movie> getAllFavoritesItems(long userId) throws FavoritesEmptyException {
		String user=Long.toString(userId);
		if (!userFavorites.containsKey(user) || userFavorites.get(user).getMovieList().isEmpty()) {
			throw new FavoritesEmptyException();
		}
		Favorites favorites = userFavorites.get(user);
		return favorites.getMovieList();
	}

	@Override
	public void deleteFavoritesItem(long userId, long movieId) {
		List<Movie> movieList = userFavorites.get(Long.toString(userId)).getMovieList();
		for (Movie movie : movieList) {
			if (movie.getId() == movieId) {
				movieList.remove(movie);
				break;
			}
		}
	}
}
