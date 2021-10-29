package _05_netflix;

public class Runner {
	public static void main(String[] args) {
		Movie lotr = new Movie("Lord of the Rings", 5);
		Movie twilight = new Movie("Twilight", 1);
		Movie future = new Movie("Back to the Future", 4);
		Movie fuzz = new Movie("Hot Fuzz", 3);
		Movie godzilla = new Movie("Godzilla", 2);
		
		NetflixQueue nq = new NetflixQueue();
		
		nq.addMovie(godzilla);
		nq.addMovie(fuzz);
		nq.addMovie(future);
		nq.addMovie(twilight);
		nq.addMovie(lotr);
		
		System.out.println(twilight.getTicketPrice());
		
		nq.printMovies();
		
		System.out.println("The best movie is "+ nq.getBestMovie());
		System.out.println("The second best movie is " + nq.getMovie(1));
	}
}
