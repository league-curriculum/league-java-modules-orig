package arrays;
import processing.core.PApplet;
import processing.core.PImage;

/*
 * Goal: Create a program to paint some Van Gogh paintings!
 * 
 * In this class:
 * 1. Declare a PImage array variable as a member variable in this class.
 *    DO NOT initialize it.
 * 
 * 2. In the initializePaintings() method, initialize the PImage array to
 *    contain 4 images.
 * 
 * 3. Use the loadImage() method to assign each of the 4 images in the /images
 *    folder to an index in the PImage array
 *    "starryNight.jpg", "strawHatPortrait.jpg",
 *    "wheatField.jpg", "painterOnRoad.jpg"
 * 
 * 4. Declare a member variable to keep track of the current image index from the
 *    array. This variable will indicate which image to display from the array.
 * 
 * 5. In the initializePaintings() method, initialize the variable to 0
 *    so the first painting to select is the first one in the array.
 * 
 * 6. Call the setNewPainting() method from the brush object and pass in
 *    the current painting as an input variable. It should be similar to this:
 *    brush.setNewPainting(paintings[currentIndex]);
 * 
 * 7. Run the program. You should be able to paint with your brush when
 *    pressing the mouse and dragging. The paint will be thicker the faster
 *    the mouse moves and more detailed when moving the mouse slowly.
 *    Press 'r' to remove all the paint from the canvas and start over.
 * 
 * 8. In the selectNextPainting() method, increase the image index variable
 *    by 1. Add code to make sure the index variable is never larger than the
 *    size of the painting array and wraps back to the first painting.
 * 
 * 9. Call the setNewPainting() method from the brush object similar to step 6.
 * 
 * 10.Run the program. Press the spacebar to move to the next painting.
 *    Make sure that pressing the spacebar on the fourth painting returns
 *    back to the first one.
 * 
 * 11.EXTRA: Find more paintings and add them to your code.
 *           Watercolor paintings work the best!
 */

public class _03_VanGogh extends PApplet {
    PImage canvas;
    PImage paintbrushCursor;
    boolean initializeCanvas = true;
    
    /*
     * Write your code below
     */
    Brush brush;
    
    void initializePaintings() {
        
    }
    
    void selectNextPainting() {
        
    }

    @Override
    public void settings() {
        // Arbitrary initial size.
        // These values are changed when the first painting is loaded in setup().
        size(800, 600);
    }

    @Override
    public void setup() {
        surface.setResizable(true);
        
        canvas = loadImage("canvas.jpg");
        
        brush = new Brush(this);

        paintbrushCursor = loadImage("paintbrushCur.png");
        paintbrushCursor.resize(22 * 2, 28 * 2);
        cursor(paintbrushCursor);

        initializePaintings();
    }

    @Override
    public void draw() {
        if (initializeCanvas) {
            canvas.resize(width, height);
            image(canvas, 0, 0);
            initializeCanvas = false;
        }

        brush.update();
        brush.draw();
    }

    @Override
    public void keyPressed() {
        if (keyPressed) {
            if (key == 'r') {
                image(canvas, 0, 0);
            } else if (key == 32) {
                // SPACE key pressed--go to next painting
                selectNextPainting();

                //canvas.resize(width, height);
                initializeCanvas = true;
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main(_03_VanGogh.class.getName());
    }
}
