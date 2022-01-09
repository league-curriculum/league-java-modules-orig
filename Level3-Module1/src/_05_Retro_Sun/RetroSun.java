package _05_Retro_Sun;

import processing.core.PApplet;

/*
 * Goal: Create an animated retro sun image!
 * 
 * Follow the inline instructions below. Open RetroSun.html in this folder to
 * see final image and what each step should look like.
 */
public class RetroSun extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    // RGB colors
    int[] sunColors = {
            color(212, 202, 11), color(214, 198, 30), color(211, 170, 26),
            color(216, 157, 51), color(217, 124, 64), color(213, 104, 81),
            color(212, 51, 98), color(215, 29, 121), color(217, 11, 139),
            color(217, 0, 151) };

    int bgColor = color(31, 0, 48);

    @Override
    public void settings() {
        // 1. Set the size of your sketch to at least 800 width, 600 height
        
    }

    @Override
    public void setup() {
        // 2. Set bgColor as the background color
        
    }

    @Override
    public void draw() {
        /*
         * PART 1: Drawing the sun
         */

        // Draw an ellipse for the sun in the center of the window
        // Use fill(sunColors[0]) to make it yellow
        // Use noStroke() to remove the black outline

        // Do you see a yellow sun like in the 1st image?
        // If not, fix your code before proceeding.

        
        /*
         * PART 2: Drawing a color gradient on the sun
         *
         * This will make the sun have gradually different colors from the top to bottom
         */

        // Call the loadPixels() method to put all the pixel colors into
        // the pixels[] array
        // https://processing.org/reference/loadPixels_.html

        // We want to change the color of our sun so use an if statement
        // to check if the pixel is the color of the yellow circle.

        // If pixel[i] is the same color as the color of our circle (sunColors[0]),
        // we need to map the pixel to a color in our sunColors[] array
        // (see 2nd gradient image in RetroSun.html)

        // The top of the sun is yellow (sunColors[0]) and the bottom
        // of the sun is red (sunColors[sunColors.length - 1]

        // In order to get the right color, the y value from the top of
        // the sun to the bottom has to be mapped to a range from 0 to 1.
        // Use the map() function to do that:
        // int y = i / width;
        // float step = map(y, sunTopY, sunBottomY, 0, 1);

        // Call interpolateColor(sunColors, step) and save the color
        // variable that's returned

        // Set pixels[i] to the returned color

        // Call updatePixels() after your loop through all the pixels to
        // update the pixel colors
        // https://processing.org/reference/updatePixels_.html

        
        /*
         * PART 3: Drawing the missing sections at the bottom of the sun
         *
         * The missing parts of the sun are created by drawing rectangles over the sun
         * with the same color as the background.
         */

        // Set the fill color to the background color

        // To draw each rectangle we need to find its x, y, width, height
        // *The y position can be any value within the sun:
        //  float y = width / 2;
        // *The height can be any value you choose:
        //  float h = 40;
        // *The x position can be the center of the sun's x position minus the radius:
        //  float x = sunCenterX - sunRadius
        // *The width can be 2 times the radius
        //  float w = 2 * sunRadius
        
        // Do you see a section missing from the sun like in the 3rd image?

        
        /*
         * PART 4: Moving the missing sun sections
         *
         * To move a section upwards each rectangle's y value needs to decrease. To make
         * the section get smaller, its height needs to also decrease.
         */

        // Decrease the y variable of the rectangular section created in PART 3.
        // If there isn't a variable, declare a float variable OUTSIDE of the
        // draw function AND initialize it in the setup() function.

        // Do you see the rectangle moving upwards?

        // Pick a y positon to be the location when the sections stop moving up.
        // If the rectangle's y positon is above this, move the rectangle's
        // y position back to the bottom of the sun.

        // Does the rectangle move back to the bottom?

        // Decrease the the height of the rectangle as it moves upwards.
        // Similar to the y positon, a float variable for the height needs to be
        // created if it doesn't already exist.

        // Adjust the amount to decrease so that it disappears close to the top.
        // HINT: You can use the map() function again,
        // h = map(y, missingSectionTopY, missingSectionBottomY, 1, 40);

        // The map() function will make the value of h = 1 if y is at the top,
        // and h = 40 if y is at the bottom.

        
        /*
         * PART 5: Managing the missing sun sections
         *
         * Using a list to manage moving multiple missing sun sections
         */

        // Figure out how to create the other missing sun sections using the
        // code you wrote for the 1 missing sun section.
        // HINT: You can use the Rectangle class defined below to create
        // a list of Rectangles.

        
        /*
         * PART 6: Adding extras
         *
         * If you want to make your retro sun look more unique, try adding
         * reflections and stars. See RetroSun.html in this folder for some
         * example classes
         */
    }

    static public void main(String[] passedArgs) {
        PApplet.main(RetroSun.class.getName());
    }

    /*********************** DO NOT MODIFY THE CODE BELOW ********************/

    // Placed here so it can be used by all classes
    // Variable step should be between 0 and 1, inclusive
    int interpolateColor(int[] arr, float step) {
        int sz = arr.length;

        if (sz == 1 || step <= 0.0) {
            return arr[0];
        } else if (step >= 1.0) {
            return arr[sz - 1];
        }

        float scl = step * (sz - 1);
        int i = (int) scl;

        return lerpColor(arr[i], arr[i + 1], scl - i);
    }

    // Feel free to use this class to create a list of missing
    // sections in the sun, for example:
    // ArrayList<Rectangle> sections = new ArrayList<Rectangle>();
    class Rectangle {
        float x, y, w, h;

        Rectangle(float x, float y, float w, float h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
    }
}
