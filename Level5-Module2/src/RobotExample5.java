import org.jointheleague.graphical.robot.Robot;

import java.awt.*;

public class RobotExample5 {

    private static final Object talkingStick = new Object();
    private Robot vic = new Robot("vic");
    private Robot june = new Robot("june");
    private boolean juneDone = false;
    private boolean vicDone = false;
    private Runnable vicsPart = () -> {
        vic.setPos(300, 300);
        firstMovement(vic);
        vicIsDone();
        waitForJune();
        secondMovement(vic);
        waitForJune();
        vic.setSpeed(5);
        vic.move(-200);
        vic.hide();
    };
    private Runnable junesPart = () -> {
        june.setPos(600, 300);
        waitForVic();
        firstMovement(june);
        june.sleep(500);
        juneIsDone();
        secondMovement(june);
        june.turn(180);
        june.sleep(500);
        juneIsDone();
        june.setSpeed(5);
        june.move(200);
        june.hide();
    };

    public static void main(String[] args) {
        new RobotExample5().play();
    }

    private void play() {
        Robot.setWindowColor(Color.WHITE);
        new Thread(vicsPart).start();
        new Thread(junesPart).start();
    }

    private void firstMovement(Robot robot) {
        robot.setSpeed(2);
        robot.setPenColor(Color.GRAY);
        robot.penUp();
        robot.move(-10);
        robot.penDown();
        robot.move(20);
        robot.penUp();
        robot.move(-10);
        robot.turn(90);
        robot.move(-10);
        robot.penDown();
        robot.move(20);
        robot.penUp();
        robot.move(-10);
        robot.setSpeed(10);
        robot.turn(-144);
        robot.move(123);
        robot.turn(144);
    }

    private void secondMovement(Robot robot) {
        robot.setPenWidth(8);
        robot.penDown();
        for (int i = 0; i < 10; i++) {
            robot.setRandomPenColor();
            robot.move(200);
            robot.turn(108);
        }
        robot.penUp();
    }

    private void waitForJune() {
        synchronized (talkingStick) {
            juneDone = false;
            try {
                while (!juneDone) {
                    talkingStick.wait();
                }
            } catch (InterruptedException e) {
                assert false; // No interrupts expected
            }
        }
    }

    private void juneIsDone() {
        synchronized (talkingStick) {
            juneDone = true;
            talkingStick.notify();
        }
    }

    private void waitForVic() {
        synchronized (talkingStick) {
            vicDone = false;
            try {
                while (!vicDone) {
                    talkingStick.wait();
                }
            } catch (InterruptedException e) {
                assert false; // No interrupts expected
            }
        }
    }

    private void vicIsDone() {
        synchronized (talkingStick) {
            vicDone = true;
            talkingStick.notify();
        }
    }
}
