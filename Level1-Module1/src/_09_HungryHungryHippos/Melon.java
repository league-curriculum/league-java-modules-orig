package _09_HungryHungryHippos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Melon {
    static final int RADIUS = 10;
    static final int DIAMETER = 2 * RADIUS;
    int x, y, speed;
    double xSpeed, ySpeed, angle;
    Rectangle collisionBox;
    
    boolean insideBoard = true;

    public Melon(int x, int y) {
        /*
         * X/Y center of circle, not upper left corner
         */
        this.x = x - RADIUS;
        this.y = y - RADIUS;
        
        speed = new Random().nextInt(10) + 5;
        angle = Math.toRadians(new Random().nextDouble() * 360);
        xSpeed = Math.sin(angle) * speed;
        ySpeed = -Math.cos(angle) * speed;
        
        collisionBox = new Rectangle(x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);
    }

    void update() {
        x += xSpeed;
        y += ySpeed;
        
        checkCollision();
    }

    void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);
    }

    boolean checkCollision() {
        boolean isCollision = false;
        float gameBoardCenterX = HungryHungryHippos.GAME_BOARD_X + (HungryHungryHippos.GAME_BOARD_WIDTH / 2);
        float gameBoardCenterY = HungryHungryHippos.GAME_BOARD_Y + (HungryHungryHippos.GAME_BOARD_WIDTH / 2);
        float distX = gameBoardCenterX - x;
        float distY = gameBoardCenterY - y;
        double distance = Math.sqrt((distX * distX) + (distY * distY));
        
        collisionBox.setBounds(x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);
        
        if( distance > (HungryHungryHippos.GAME_BOARD_WIDTH / 2) + RADIUS ) {
            /*
             * Reset if way outside board for some reason
             */
            x = HungryHungryHippos.GAME_BOARD_X + (HungryHungryHippos.GAME_BOARD_WIDTH / 2);
            y = HungryHungryHippos.GAME_BOARD_Y + (HungryHungryHippos.GAME_BOARD_WIDTH / 2);
        }
        else if( insideBoard && distance >= (HungryHungryHippos.GAME_BOARD_WIDTH / 2) - RADIUS) {
            /*
             * 5 deg of random spin angle to melons don't bounce back and forth
             * along the same line
             */
            double randomSpin = Math.toRadians((new Random().nextDouble() * 10) - 5);
            double tangent = Math.atan2(distY, distX);
            this.angle = (2 * tangent) - this.angle;
            
            /*
             * For the reflection angle the opposite and adjacent
             * angle sides are swapped
             */
            xSpeed = Math.sin(angle + randomSpin) * speed;
            ySpeed = -Math.cos(angle + randomSpin) * speed;
            
            insideBoard = false;
            isCollision = true;
        } else {
            insideBoard = true;
        }
        
        return isCollision;
    }
}
