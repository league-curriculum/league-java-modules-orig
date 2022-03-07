package _10_turf_war;

import java.awt.Color;

import processing.core.PApplet;

public class TurfWar extends PApplet {

    class Player {
        /*
         * 1. Create a constructor for Player that takes all these variables in
         * as parameters and initializes them using the this keyword.
         */
        int x;
        int y;
        int speed;
        int playerSize;
        int playerColor;
        int upKey;
        int leftKey;
        int downKey;
        int rightKey;

        /*
         * The member variables below do not need to be initialized in the
         * constructor.
         */
        boolean moveUp = false;
        boolean moveDown = false;
        boolean moveLeft = false;
        boolean moveRight = false;
        int pixelCount = 0;

        void drawPlayer() {
            /*
             * 2. Draw a rectangle to represent the the Player using its color,
             * coordinates and size.
             */
            
        }

        void update() {
            /*
             * This piece of codes makes the player move up without
             * leaving the bounds of the sketch if its up key is pressed.
             * 
             * Note: statsBoardLine is used instead of 0 because that is 
             * where the area detailing game stats(timer, score, etc.) ends.
             * 
             */     
            if (moveUp && y > statsBoardLine) {
                y-=speed;
            }
            
            /* 
             * 3. Make the Player move in every other direction.
             * 
             * Note: You do not need to use the statsBoardLine for the 
             * other directions.
             */
            
        }

        // You do not need to change any other Player methods.
        void enableMovement(int keyDown) {
            if (keyDown == upKey) {
                moveUp = true;
            }
            if (keyDown == leftKey) {
                moveLeft = true;
            }
            if (keyDown == downKey) {
                moveDown = true;
            }
            if (keyDown == rightKey) {
                moveRight = true;
            }
        }

        void disableMovement(int keyDown) {
            if (keyDown == upKey) {
                moveUp = false;
            }
            if (keyDown == leftKey) {
                moveLeft = false;
            }
            if (keyDown == downKey) {
                moveDown = false;
            }
            if (keyDown == rightKey) {
                moveRight = false;
            }
        }

        void countPixels() {
            pixelCount = 0;
            
            for (int i = 0; i < width * height; i++) {
                if (pixels[i] == playerColor) {
                    pixelCount++;
                }
            }

        }
    }

    /*
     * 4. Declare two variables of the Player class called player1 and player2.
     * Do not initialize them yet.
     */

    

    // Do not change these variables
    boolean gameOver = false;
    final int W = 87;
    final int S = 83;
    final int A = 65;
    final int D = 68;
    final int statsBoardLine = 100;
    final int statsBoardSpacing = 24;

    /*
     * Optional: You can change this if you want a shorter or longer game. Right
     * now the game will run for 30 seconds (30000 milliseconds).
     */
    int endOfGame = 30000;

    @Override
    public void settings() {
        // 5. Set the size for your sketch. Make it at least 300x300.
       
    }

    @Override
    public void setup() {
        /*
         * Do not change this code. It makes it so you can press the keys
         * to control the Players without clicking on the window first.
         */
        ((java.awt.Canvas) surface.getNative()).requestFocus();

        // 6. Set the background color.


        // 7. Call the noStroke Method.
        
        
        /*
         * 8. Initialize the two Player objects. For one use UP, LEFT, DOWN,
         * RIGHT for the keys, for the second use the W,A,S,D final int 
         * variables created above. 
         * 
         * Note: Make sure to place your players' y positions below the statsBoardLine
         * or else they will be hidden behind the game stats.
         * 
         * Note: Use the Color class for the color, e.g. Color.BLUE.getRGB(). Do
         * not select black, white or the color you used for your background as it
         * will give that player an unfair advantage.
         */

        
    }

    /*
     * 9. Uncomment these methods once you have created and initialized player 1
     * and player 2
     */

//    public void isGameOver() {
//        if (millis() >= endOfGame && !gameOver) {
//            gameOver = true;
//        }
//    }
//
//    public void endGame() {
//        
//        String winMessage = "";
//        
//        double player1Percentage = calculateRoundedPixelPercentage(player1.pixelCount);
//        double player2Percentage = calculateRoundedPixelPercentage(player2.pixelCount);
//        
//        
//        if (player1Percentage == player2Percentage) {
//            winMessage = "TIE";
//
//        } else if (player1Percentage > player2Percentage) {
//            
//            winMessage = "PLAYER 1 WINS!";
//            
//        } else {
//            winMessage = "PLAYER 2 WINS!";
//        }
//        
//        text(winMessage, (width/2 - (winMessage.length()*statsBoardSpacing) / 4)  , statsBoardSpacing*4);
//        
//        noLoop();
//    }
//    
//    public void displayStats() {
//        
//        fill(Color.BLACK.getRGB());
//        rect(0,0, width, 100);
//        fill(Color.WHITE.getRGB());
//        textSize(24);
//        
//        int gameTimeLeft = (endOfGame / 1000) - (int)(millis() / 1000);
//        String timerDisplay = "Seconds Left: " + gameTimeLeft;
//        text(timerDisplay, (width/2 - (timerDisplay.length()*statsBoardSpacing) / 4)  , statsBoardSpacing);
//        
//        loadPixels();
//        player1.countPixels();
//        player2.countPixels();
//        
//        String player1Display = "Player 1 Coverage: " + calculateRoundedPixelPercentage(player1.pixelCount) + "%";
//        text(player1Display, (width/2 - (player1Display.length()*statsBoardSpacing) / 4)  , statsBoardSpacing*2);
//        
//        String player2Display = "Player 2 Coverage: " + calculateRoundedPixelPercentage(player2.pixelCount) + "%";
//        text(player2Display, (width/2 - (player2Display.length()*statsBoardSpacing) / 4)  , statsBoardSpacing*3);
//    }
//    
//    public double calculateRoundedPixelPercentage(int pixelCount) {
//        double pixelPercentage = (pixelCount / (double) (width * height - width * statsBoardLine )) * 100;
//        double pixelsRounded = Math.round(pixelPercentage * 100) / 100.0;
//        return pixelsRounded;
//    }

    @Override
    public void draw() {
        // 10. Call the drawPlayer method for both players.
        
        // 11. Call the update method for both players.

        // 12. Call the isGameOver method.
        
        // 13. Call the displayStats method.

        // 14. If gameOver is true call the endGame method.

    }

    @Override
    public void keyPressed() {
        /*
         * 15. Call the enableMovement method for both players and pass keyCode
         * to the method.
         */        

    }

    @Override
    public void keyReleased() {
        /*
         * 16. Call the disableMovement method for both players and pass keyCode
         * to the method.
         */

    }

    /*
     * 17. Try to play a game of Turf War with someone nearby if possible. The
     * goal of the game is to fill in more of the sketch with your color than
     * the other player.
     */

    // Challenge: Try to add more players to the game. If you need to figure out
    // additional keycodes for controls try using https://keycode.info/

    static public void main(String[] args) {
        PApplet.main(TurfWar.class.getName());
    }
}