
package _03_remainder._4_fizz_buzz;


/**
* Fizz Buzz
* 
* In this project, we're going to build FizzBuzz. It's a children's game where
* you count from 1 to 20. Easy, right? Here's the catch: 
* 
* Instead of saying a number that is divisible by 3, say "Fizz".
* And instead of saying a number that is divisible by 5, say "Buzz".
* For numbers divisible by both 3 and 5, say "FizzBuzz".
* 
* Print your results to the console.
* 
* If your code is correct, the output will be:
*  
* 1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz
* 
**/

public class FizzBuzz {
	/*
	 * FILL OUT THE IF STATEMENTS TO GET THE PROGRAM TO WORK
	 */
	public static void main(String[] args) {
		
		for( int i = 1 ; i <= 20; i++ ) {
			// Divisible by 3 and divisible by 5
			if() {
				System.out.println("FizzBuzz");
			}
			// Divisible by 3
			else if() { 
				System.out.println("Fizz");
			}
			// Divisible by 5
			else if() {
				System.out.println("Buzz");
			}
			else {
				System.out.println(i);
			}
		}
	}
}

