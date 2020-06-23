package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class FavoritesService {
	@Autowired
	FavoritesDao favoritesDao;
	public void addFavoritesItem(long userId, long movieId) {
		favoritesDao.addFavoritesItem(userId, movieId);
	}
	public List<Movie> getAllFavoritesItems(long userId) throws FavoritesEmptyException{
		return favoritesDao.getAllFavoritesItems(userId);
	}
	public void deleteFavoritesItem(long userId, long movieId) {
		favoritesDao.deleteFavoritesItem(userId, movieId);
	}
}