package _01_shapes_original;

import java.awt.Color;

/*
 * This package contains several classes(Hexagon, Square, Triangle). This runner
 * class creates an object of each and calls their methods.
 * 
 * Look at all the code in the Hexagon, Square, and Triangle classes.
 * 
 * This should look familar. Run the code to see what happens.
 * 
 * Now go to the _02_shapes_inheritance package and open that ShapeRunner class.
 */
public class ShapeRunner {
	public static void main(String[] args) {
		Square sq = new Square(200,450,400,Color.BLUE);
		sq.setupRobot();
		sq.draw();
		
		Hexagon hex = new Hexagon(225,350,200,Color.RED);
		hex.setupRobot();
		hex.draw();
		
		Triangle tri = new Triangle(325,375,250,Color.GREEN);
		tri.setupRobot();
		tri.draw();
	}
}
