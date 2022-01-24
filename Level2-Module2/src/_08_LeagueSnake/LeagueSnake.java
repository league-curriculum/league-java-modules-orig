package _08_LeagueSnake;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */
    

    
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        
    }

    @Override
    public void setup() {
        
    }

    void dropFood() {
        // Set the food in a new random location
        
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
        
    }

    void drawFood() {
        // Draw the food
        
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    }

    void drawTail() {
        // Draw each segment of the tail
        
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.

    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed() {
        // Set the direction of the snake according to the arrow keys pressed
        
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

        /*
        if (direction == UP) {
            // Move head up
            
        } else if (direction == DOWN) {
            // Move head down
                
        } else if (direction == LEFT) {
            
        } else if (direction == RIGHT) {
            
        }
        */
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
        
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
