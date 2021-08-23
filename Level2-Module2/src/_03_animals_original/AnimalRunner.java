package _03_animals_original;

/*
 * 1. Run the code and see the output.
 * 
 * 2. Look at the Dog and Cat classes to familiarize yourself with the code.
 * 
 * 3. Go look at theAnimalRunner class in the _04_animals_inheritance package.
 */
public class AnimalRunner {
	public static void main(String[] args) {
		Dog d = new Dog("Lucy", "brown", true);
		d.printName();
		d.play();
		d.eat();
		d.sleep();
		
		Cat c = new Cat("Tom", "black", false);
		c.printName();
		c.play();
		c.eat();
		c.sleep();
	}
}
