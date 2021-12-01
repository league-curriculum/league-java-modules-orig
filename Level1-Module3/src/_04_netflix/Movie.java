package _04_netflix;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */


public class Movie implements Comparable<Movie> {

	private String title;
	private int stars;

	/**
	 * Constructor for the movie
	 * 
	 * @param title The Title of the movie
	 * @param stars The movies rating
	 */
	public Movie(String title, int stars) {
		this.title = title;
		this.stars = stars;
	}

	public String getTitle() {
		return this.title;
	}

	public int getRating() {
		return this.stars;
	}

	/**
	 * Printing this object will print with title and stars
	 */
	public String toString() {
		return "\"" + title + "\" - " + stars + " stars";
	}

	/**
	 * 
	 * @return The ticket price based on star rating
	 */
	public String getTicketPrice() {
		if (this.stars > 2) {
			return "That will be $12 please.";
		} else if (this.title.contains("Twilight")) {
			return "This movie is so bad, we'll pay YOU to watch it!";
		} else {
			return "Don't waste your money on this horrible rubbish.";
		}
	}

	/**
	 * When sorted as part of a collection 
	 * @param otherMovie The movie being compared to this object
	 * @return The difference between the rating of the other movie and this
	 */
	public int compareTo(Movie otherMovie) {
		int compareQuantity = otherMovie.getRating();

		// return this.stars - compareQuantity; //ascending order
		return compareQuantity - this.stars; // descending order
	}
}
