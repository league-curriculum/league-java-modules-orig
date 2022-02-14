package _01_intro_to_static;

import java.awt.Color;

/*
 * Goal: See how the static keyword changes the objects
 * 
 * Member variable vs Class variable:
 * 1. Run the program and move the sliders.
 *    Notice that changing the radius or color of one of the sliders only
 *    affects one of the circles.
 * 
 * 2. Add "static" to the beginning of the radius and color member
 *    variables in the Circle class in this package
 * 
 * 3. Run the program again and move the sliders.
 *    Notice that changing the radius or color of one of the sliders now
 *    affects all of the circles.
 * 
 *    This is because adding static makes the variable apply for each object
 *    of the Circle class. In other words, each time
 *    new Circle()
 *    is called it will have the same static variables as all the other circles.
 *    - A variable in a class with static is called a class variable.
 *    - A variable in a class without static is called a member variable
 * 
 * Lifetime of member variables vs. class variables
 * 4. Add the following 2 lines of code at the top of the addCircles() method,
 *    before the circle objects are created:
 *      System.out.println("circle radius = " + Circle.radius);
 *      System.out.println("circle color = " + Circle.color);
 * 
 * 5. Run the program. The console should print out:
 *      circle radius = 0
 *      circle color = null
 * 
 * 6. In the Circle class, remove the static keyword from the radius and color
 *    variables.
      You should now see an error on Circle.radius and Circle.color
 *    This is because when a variable is static it can be used BEFORE a circle
 *    object is created.
 * 
 * 7. Move the prints below the code that makes the Circle objects and change:
 *    Circle.radius to circle1.radius
 *    Circle.color to circle1.color
 * 
 * 8. Run the program. The console should print the radius and color of just
 *    ONE of the circles. A variable without static (member variable) only
 *    exists AFTER the circle object is created.
 * 
 * Mixing static and non-static methods
 * 9. In this class, add static to the beginning of the addCircles() method.
 *    You should now see an error under the canvas variable.
 *    This is because canvas is a member variable and Java doesn't allow member
 *    variables inside static methods since member variables don't exist
 *    before an object is created.
 * 
 * 10.Add static to the beginning of the canvas variable at the beginning of
 *    the class. The error should now be gone because there are no longer
 *    member variables inside the static addCircles() method.
 */
public class StaticKeywordDemo {
    Canvas canvas;
    
    StaticKeywordDemo() {
        canvas = new Canvas();
        addCircles();
    }
    
    void addCircles() {
        
        Circle circle1 = new Circle(20, Color.BLUE);
        Circle circle2 = new Circle(50, Color.RED);
        Circle circle3 = new Circle(100, Color.GREEN);
        
        canvas.addCircle(circle1);
        canvas.addCircle(circle2);
        canvas.addCircle(circle3);
    }
}
