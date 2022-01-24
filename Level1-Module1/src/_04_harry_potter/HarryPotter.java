package _04_harry_potter;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

		/* Create a HarryRunner class in the harry_potter package with a main method.
		 * The main method should:
		 * 
		* 1. create harry potter
		* 2. make him become invisible
		* 3. spy on Professor Snape
		* 4. make him become visible again
		* 5. cast a "stupefy" spell
		*/

public class HarryPotter {

	private boolean cloakOn;

	HarryPotter() {
		System.out.println("making Harry Potter...");
	}

	void castSpell(String spell) {
		System.out.println("casting spell: " + spell);
	}

	void makeInvisible(boolean invisible) {
		this.cloakOn = invisible;

		if (cloakOn)
			System.out.println("Harry is invisible");
		else
			System.out.println("Harry is visible");
	}

	void spyOnSnape() {
		System.out.println("Harry sees Professor Snape doing nefarious things.");
	}

}
