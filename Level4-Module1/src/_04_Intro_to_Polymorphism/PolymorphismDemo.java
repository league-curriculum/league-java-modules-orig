package _04_Intro_to_Polymorphism;

import java.util.ArrayList;

/*
 * Polymorphism is a property that allows classes to take on multiple forms
 * that vary with the class's relationships and whether the program is
 * running or just being compiled. 
 */

abstract class Animal {
    public void speak() {
        System.out.println("I am an animal");
    }
}

class Dog extends Animal {
    public void speak() {
        System.out.println("Woof!");
    }
}

class Bird extends Animal {
    public void speak() {
        System.out.println("Tweet!");
    }
}

class Fish extends Animal {
    public void speak() {
        System.out.println("Gurgle Gurgle Gurgle!");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {

        /*
         * Since Animal is an abstract class it cannot be instantiated normally.
         * 
         * However, classes that extend from Animal(Animal subclasses) can be
         * instantiated and even saved into a variable declared as an Animal.
         * 
         * 1. Change the code below so that animal is set equal to a new Dog,
         * Bird or Fish on the right side of the equals sign while still being
         * declared as an Animal on the left side.
         */

        Animal animal = new Animal();

        /*
         * 2. Call the speak method and run the program.
         * 
         * Even though the variable was declared as an Animal, at run time it
         * will behave like whatever Animal subclass it was instantiated as.
         */

        /*
         * 3. Comment out the speak method of the Animal subclass you chose and
         * run the program again.
         * 
         * This time since there was no speak method in the Animal subclass you
         * chose, the next closest speak method in the class's inheritance was
         * called. In this case it was Animal class's version of speak.
         */

        /*
         * 4. Add another method called eat to the Animal subclass you chose and
         * have it print a description of the animal eating their favorite food
         * to the console.
         * 
         * 5. Try to call your new eat method using the animal variable.
         * 
         * You'll notice that it won't show up in the list of available options
         * because animal is still considered an Animal at compile time.
         * 
         * If the eat method was instead in the Animal class it would work as
         * expected.
         * 
         * You can also cast the Animal into the Animal subclass you chose
         * before calling the method.
         * 
         * 6. Try casting animal into the Animal subclass you chose and calling
         * the eat method.
         */

        /*
         * Polymorphism is not just limited to variables, it can also be used in
         * arrays, ArrayLists or any other data structures you are familiar
         * with.
         */
        
        ArrayList<Animal> petStore = new ArrayList<>();
        petStore.add(new Bird());
        petStore.add(new Dog());
        petStore.add(new Fish());

    }
}
