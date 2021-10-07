color bgColor = color(31, 0, 48);
float sunRadius = 200;
float y = width / 2;
float h = 40;
int numBands = 5;
float bandTopY;
float bandBottomY;
ArrayList<Rectangle> bands = new ArrayList<Rectangle>();
int numReflections = 4;
Reflection reflections;
Star[] stars;

// RGB colors
color[] sunColors = {
  color(212, 202, 11), 
  color(214, 198, 30), 
  color(211, 170, 26), 
  color(216, 157, 51), 
  color(217, 124, 64), 
  color(213, 104, 81), 
  color(212, 51, 98), 
  color(215, 29, 121), 
  color(217, 11, 139), 
  color(217, 0, 151)
};

void setup() {
  // 1. Set the size of your sketch
  size(800, 600);
  
  /*
   * Sun bands
   */
  bandTopY = (height / 2) - (sunRadius / 4);
  bandBottomY = (height / 2) + sunRadius;
  
  float x = (width / 2) - sunRadius;
  float w = 2 * sunRadius;
  float y = (height / 2) - (sunRadius / 4);
  float h = 1;
  
  for( int i = 0; i < numBands; i++ ){
    Rectangle r = new Rectangle(x, y, w, h);
    bands.add( r );
    
    y += (bandBottomY - bandTopY) / numBands;
    h = map(y, bandTopY, bandBottomY, 1, 40);
  }

  /*
   * Reflections
   */
  float topX = (width/2) - sunRadius - (sunRadius/4);
  float topY = (height/2) + sunRadius;
  reflections = new Reflection(sunRadius, numReflections, topX, topY, 0.3);

  /*
   * Stars
   */
  int starSz = int( width * height * 0.0025 );
  stars = new Star[starSz];
  
  for( int i = 0; i < stars.length; i++ ){
    int starX = int( random(0, width) );
    int starY = int( random(0, height) );
    stars[i] = new Star(starX, starY, color(255));
  }
}


void draw() {
  // 2. Draw the bgColor background color
  background(bgColor);

  /*
   * PART 1: Drawing the sun
   */

  // Draw an ellipse for the sun in the center of the window
  // Use fill(sunColors[0]) to make it yellow
  // Use noStroke() to remove the black outline
  noStroke();
  fill(sunColors[0]);
  ellipse(width/2, height/2, 2*sunRadius, 2*sunRadius);

  // Do you see a yellow sun like in the 1st image?
  // If not, fix your code before proceeding.

  /*
   * PART 2: Drawing a color gradient on the sun
   *
   * This will make the sun have gradually different colors from the 
   * top to bottom
   */

  // Call the loadPixels() method to put all the pixel colors into
  // the pixels[] array
  // https://processing.org/reference/loadPixels_.html
  loadPixels();

  // Loop through all the pixels in your window.
  // By default, a pixel is a 1x1 colored square, so if the window width is 600 
  // and the height is 400 (600x400), then there are 600 * 400 = 240,000 pixels 
  for( int i = 0; i < pixels.length; i++ ){
    // We want to change the color of our sun so use an if statement
    // to check if the pixel is the color of the yellow circle. 
    if( sunColors[0] == pixels[i] ){
      // If it's the same color we need to map the pixel to a
      // color in our sunColors[] array (see 2nd gradient image)

      // The top of the sun is yellow (sunColors[0]) and the bottom
      // of the sun is red (sunColors[sunColors.length - 1]

      // In order to get the right color, the y value from the top of
      // the sun to the bottom has to be mapped to a range from 0 to 1.
      // Use the map() function to do that:
      // int y = i / width;
      // float step = map(y, sunTopY, sunBottomY, 0, 1);
      int y = i / width;
      float step = map(y, (height/2) - sunRadius, (height/2) + sunRadius, 0, 1);

      // Call interpolateColor(sunColors, step) and save the color
      // variable that's returned
      color c = interpolateColor(sunColors, step);

      // Set pixels[i] to the returned color
      pixels[i] = c;
    }
  }

  // Call updatePixels() after your loop through all the pixels to
  // update the pixel colors
  // https://processing.org/reference/updatePixels_.html
  updatePixels();

  /*
   * PART 3: Drawing the missing sections at the bottom of the sun
   *
   * The missing parts of the sun are created by drawing rectangles
   * over the sun with the same color as the background.
   */

  // Set the fill color to the background color

  // To draw each rectangle we need to find its x, y, width, height
  // *The y position can be any value within the sun:
  //   float y = width / 2;
  // *The height can be any value you choose:
  //   float h = 40;
  // *The x position can be the center of the sun's x position minus the radius:
  //   float x = sunCenterX - sunRadius
  // * The width can be 2 times the radius
  //   float w = 2 * sunRadius
  
  // Do you see a section missing from the sun like in the 3rd image?

  /*
   * PART 4: Moving the missing sun sections
   *
   * To move a section upwards each rectangle's y value needs to decrease.
   * To make the section get smaller, its height needs to also decrease.
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

  // Add code to reset the height of the rectangle when it moves back to
  // the bottom of the sun.

  /*
   * PART 5: Managing the missing sun sections
   *
   * Using a list to manage moving multiple missing sun sections 
   */

  // Figure out how to create the other missing sun sections using the
  // code you wrote for the 1 missing sun section.
  // *HINT* You can use the Rectangle class defined below to create
  //        a list of Rectangles.

  for( Rectangle r : bands ){
    r.update();
    r.draw(); //<>//
  }
  
  fill(red(bgColor + 10), green(bgColor), blue(bgColor) + 20);
  rect(0, (height/2) + sunRadius, width, height/2);
  reflections.draw();

  loadPixels();
  for( Star s : stars ){
    if( pixels[(s.y * width) + s.x] == bgColor ){
      s.draw();
    }
  }

  /*
   * PART 6: Adding extras
   *
   * If you want to make your retro sun look more unique, try adding
   * reflections and stars.
   * See the Retro Sun webpage on the League level 3 website
   * for example code and classes.
   */
}

// Placed here so it can be used by all classes
// Variable step should be between 0 and 1, inclusive
color interpolateColor(color[] arr, float step) {
  int sz = arr.length;

  if (sz == 1 || step <= 0.0) {
    return arr[0];
  } else if (step >= 1.0) {
    return arr[sz - 1];
  }

  float scl = step * (sz - 1);
  int i = int(scl);

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
  
  void update(){
    y -= 0.3;
    h = map(y, bandTopY, bandBottomY, 1, 40);
    
    if( y < (height/2) - (sunRadius/4) ){
      y = (height/2) + sunRadius;
      h = 40;
    }
  }
  
  void draw(){
    fill(bgColor);
    rect( x, y, w, h );
  }
}
