package _04_spot_the_error;

import java.util.Random;

public class HowMany {
	
	// This program is supposed to print a random number between 1 and 100.
	// BUT it's not working. If you don't believe me, try running it.
	// Change one line of code to fix this program.
	
	public static void main(String[] args) {
		int number = 0;
		System.out.println(number);
	}
	
	public static int getRandomNumber() {
		Random random = new Random();
		int number = random.nextInt(100)+1;
		return number;
	}
}
