package _02_Intro_To_Abstract_Classes_and_Interfaces;

/*
 * Abstract classes are classes that can contain abstract methods and cannot be 
 * instantiated.
 * 
 * They are most often used when you have a class that has common traits for 
 * other classes you are using, but would not be used on its own.
 * 
 * e.g. GameObject in LeagueInvaders would have been a good candidate for an
 * abstract class for its x,y,width and height member variables and its draw() 
 * and update() methods.
 */

/*
 * The abstract keyword is added to the class declaration to make it an abstract
 * class here.
 */
public abstract class AbstractClassDemo {

    // An abstract class can contain member variables.
    int num;

    /*
     * This is an example of an abstract method. Notice that the abstract
     * keyword is also used here and it ends in a semi-colon instead of having a
     * body defined in curly brackets.
     * 
     * Any class that extends the abstract class will be required to implement
     * its abstract methods with the same method header minus the abstract
     * keyword.
     */
    public abstract void abstractDemo();

    /*
     * An abstract method without a void return type will only require curly
     * brackets to be considered "implemented", but if it has a return type it
     * also requires a return statement that returns an appropriate value.
     */
    public abstract int abstractNumDemo();

    // An abstract class can also still contain implemented methods.
    public void demo() {
        System.out.println("Demo");
    }

}

/*
 * 1. Create a class that extends the AbstractClassDemo class and implement its
 * methods.
 */