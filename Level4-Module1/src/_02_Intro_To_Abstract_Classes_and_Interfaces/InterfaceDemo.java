package _02_Intro_To_Abstract_Classes_and_Interfaces;

/*
 * An interface could be considered a class that is completely abstract. Like an 
 * abstract class it can contain abstract methods, but cannot contain member 
 * variables or implemented methods.
 * 
 * They are most useful when you have groups of methods that are useful for 
 * providing a common functionality to other classes.
 * 
 * The interfaces you have worked with the most so far have been the Listener
 * series for Swing components e.g. ActionListener, KeyListener, MouseListener.
 * 
 * Unlike classes(and by extension abstract classes) classes can implement
 * more than one interface at a time. 
 */

/*
* Instead of using the abstract or class keyword. Interfaces have their own 
* special interface keyword for getting declared.
*/
public interface InterfaceDemo {

    /*
     * Similarly, the abstract keyword is not used for abstract methods in
     * interfaces because they are all assumed to be abstract.
     */
    public double interDemo();

}

interface DemoInterface {

    public String faceDemo();
}

/*
 * 1. Implement both InterfaceDemo and DemoInterface in the class you created
 * for the AbstractClassDemo
 */