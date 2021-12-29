package _02_boolean._4_red_square;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class RedSquare {
	
	static boolean drewRedSquare = false;
	static boolean drewBlueSquare = false;
	static boolean drewRedTriangle = false;
	static boolean drewBlueTriangle = false;
	
	public static void main(String[] args) {
		
		boolean isRed = false;
		boolean isSquare = true;
		
		// The && shown here means that both booleans must be true for the 
		// entire if statement to be true. It is referred to as the "and"
		// operator. 
		if(isRed && isSquare) {
			drawRedSquare();
		}
		else {
            JOptionPane.showMessageDialog(null, "No shape was drawn!");
        }
		
		// 1. Run the program and notice no shape is drawn.
		
		// 2. Initialize isRed to true instead of false and run the program 
		//    again.
		
		// 3. Write an else if statement after the if statement that calls 
		//    drawBlueSquare if isRed is false AND isSquare is true. 
		//    Hint: Use ! and &&.
		
		// 4. Write an else if statement that calls drawRedTriangle() if isRed
		//    is true and isSquare is false.
		
		// 5. Write an else if statement that calls drawBlueTriangle if both
		//    isRed and isSquare are false.
		
		// 6. Keep rerunning your program, initializing isRed and isSquare to 
		//    different values until you've seen a red square, red triangle, 
		//    blue square and blue triangle drawn.
		
		// Much like the "and" operator, the "or" operator || can be used to 
		// combine two boolean statements. However the statement becomes true
		// if either boolean is true rather than only if both are true.
		
		// 7. Write an if statement using the static booleans at the top of 
		//    the program. If drewRedSquare OR drewBlueSquare are true, then
		//    tell the user they drew a square in a pop-up. Hint: ||
		
		//    Notice these static booleans start off false, but update to true 
		//    whenever you call their matching method.
		
		// 8. Write an else if statement that tells the user they drew a 
		//    triangle if drewRedTriangle or drewBlueTriangle are true.
		
		// 9. Keep rerunning the program and change the isRed and isSquare 
		//    variables like you did in step 6. Make sure that when it draws
		//    a shape that the pop-up correctly says what it drew. 
		
	}
	
	static void drawRedSquare() {
		Robot rob = new Robot();
		rob.penDown();
		rob.setSpeed(100);
		rob.setPenColor(Color.red);
		for (int i = 0; i < 4; i++) {
			rob.turn(90);
			rob.move(100);
		}
		
		drewRedSquare = true;
	}	
	
	static void drawBlueSquare() {
		Robot rob = new Robot();
		rob.penDown();
		rob.setSpeed(100);
		rob.setPenColor(Color.blue);
		for (int i = 0; i < 4; i++) {
			rob.turn(90);
			rob.move(100);
		}
		
		drewBlueSquare = true;
	}
	
	static void drawRedTriangle() {
		Robot rob = new Robot();
		rob.penDown();
		rob.setSpeed(100);
		rob.setPenColor(Color.red);
		for (int i = 0; i < 3; i++) {
			rob.turn(120);
			rob.move(100);
		}
		
		drewRedTriangle = true;
	}
	
	static void drawBlueTriangle() {
		
		Robot rob = new Robot();
		rob.penDown();
		rob.setSpeed(100);
		rob.setPenColor(Color.blue);
		for (int i = 0; i < 3; i++) {
			rob.turn(120);
			rob.move(100);
		}
		
		drewBlueTriangle = true;
		
	}
}
