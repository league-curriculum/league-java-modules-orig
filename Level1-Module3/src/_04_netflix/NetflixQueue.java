package _04_netflix;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */

import java.util.ArrayList;
import java.util.Collections;

public class NetflixQueue {

	ArrayList<Movie> movies = new ArrayList<Movie>();

	/**
	 * Sorts the Netflix Queue then returns the best movie
	 * 
	 * @return after sorting, the best movie is at position 0
	 */
	public Movie getBestMovie() {
		this.sortMoviesByRating();
		return movies.get(0);
	}

	/**
	 * adds a movie to the Netflix Queue
	 * 
	 * @param movie
	 */
	public void addMovie(Movie movie) {
		movies.add(movie);
	}

	/**
	 * Gets a movie based on it's position in the queue
	 * 
	 * @param movieNumber the position requested
	 * @return the movie at position movieNumber
	 */
	public Movie getMovie(int movieNumber) {
		if (movieNumber < movies.size())
			return movies.get(movieNumber);
		else
			System.err.println(
					"That index is larger than the movie queue. Pass a smaller number to the getMovie() method.");
		return null;
	}

	/**
	 * Sorts movies based on rating in descending order
	 */
	public void sortMoviesByRating() {
		Collections.sort(movies);
	}

	/**
	 * Prints all movies in the queue
	 */
	public void printMovies() {
		System.out.println("Your Netflix queue contains: ");
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

}
