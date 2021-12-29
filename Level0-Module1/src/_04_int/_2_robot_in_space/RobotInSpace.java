//    Copyright (c) The League of Amazing Programmers 2013-2019
//    Level 0

package _04_int._2_robot_in_space;

import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.jointheleague.graphical.robot.KeyboardAdapter;
import org.jointheleague.graphical.robot.Robot;

public class RobotInSpace extends KeyboardAdapter {

	Robot rob = new Robot("mini");
	private boolean movingForward = false;
	private boolean movingBackward = false;
	private boolean turningLeft = false;
	private boolean turningRight = false;

	/*
	 * Make the Robot move around the screen when the arrow keys are pressed...
	 * 
	 * 1. IMPORTANT: For this recipe, use rob.move(distance) to move your Robot
	 * and rob.setAngle(angle) to change the direction of your Robot. //Do not add
	 * code here - go to step 2
	 */

	private void moveRobot(int keyPressed) {
		// 2. Print out the keyPressed variable and write down the numbers for
		// each arrow key
		
		// 3. If the up arrow is pressed, move the Robot up the screen.
		
		// 4. If the down arrow is pressed, move the Robot down.
		
		// 5. If the left arrow is pressed, make the Robot go left.
		
		// 6. If right is pressed, move the Robot right.
		
		// 7. Run your program and move the Robot to R2-D2 for a surprise!
		
	}

	private void checkIfR2D2Found() {
		int robotLocationX = rob.getX();
		int robotLocationY = rob.getY();

		if (robotLocationX <= 7300 && robotLocationX >= 720 && robotLocationY >= 150 && robotLocationY <= 160)
			playEureka();
	}

	public static void main(String[] args) {
		new RobotInSpace().controlTheRobot();
	}

	private void controlTheRobot() {
		rob.addKeyboardAdapter(this);
		Robot.setWindowImage("planet.jpg");
		rob.penUp();
		rob.setSpeed(10);
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			
			if (movingForward && !movingBackward) {
				moveRobot(KeyEvent.VK_UP);
			} else if (movingBackward && !movingForward) {
				moveRobot(KeyEvent.VK_DOWN);
			} else if (turningRight && !turningLeft) {
				moveRobot(KeyEvent.VK_RIGHT);
			} else if (turningLeft && !turningRight) {
				moveRobot(KeyEvent.VK_LEFT);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			movingForward = true;
			break;
		case KeyEvent.VK_DOWN:
			movingBackward = true;
			break;
		case KeyEvent.VK_LEFT:
			turningLeft = true;
			break;
		case KeyEvent.VK_RIGHT:
			turningRight = true;
			break;
		default:
		}

		checkIfR2D2Found();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			movingForward = false;
			break;
		case KeyEvent.VK_DOWN:
			movingBackward = false;
			break;
		case KeyEvent.VK_LEFT:
			turningLeft = false;
			break;
		case KeyEvent.VK_RIGHT:
			turningRight = false;
			break;
		default:
		}
	}

	public static void playEureka() {
		String fileName = "src/_04_int/_2_robot_in_space/r2d2-eureka.wav";
		// Note: use .wav files
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName));
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					System.out.println("play sound error: " + e.getMessage() + " for " + fileName);
				}
			}
		}).start();
	}

}
