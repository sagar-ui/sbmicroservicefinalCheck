package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.FavoritesService;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	FavoritesService favoritesService;
	
	@PostMapping("/{userId}/{movieId}")
	public void addFavoritesItem(@PathVariable long userId, @PathVariable long movieId) {
		favoritesService.addFavoritesItem(userId, movieId);
	}
	@GetMapping("/{userId}")
	public List<Movie> getAllFavoritesItems(@PathVariable long userId) throws FavoritesEmptyException {
		return favoritesService.getAllFavoritesItems(userId);
	}
	@DeleteMapping("/{userId}/{movieId}")
	public void deleteFavoritesItem(@PathVariable long userId, @PathVariable long movieId) {
		favoritesService.deleteFavoritesItem(userId, movieId);
	}
}