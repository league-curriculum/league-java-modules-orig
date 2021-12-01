/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */

/** This program makes a virtual record player **/
 
// If you want to add your own picure, find an image of a record, save it to your computer. 
// Then drag and drop it onto your code window before proceeding.

PImage pictureOfRecord;   // This variable will hold your image

// Create a variable to keep track of the image rotation angle. Initialize it to zero.


// The setup method is run once when the program starts
void setup() {
  
  // Set the size of your sketch here

  
  pictureOfRecord= loadImage("record.png");  // This loads the image. Change the name if you added a new image.  
  // Resize the pictureOfRecord to be the height and width of the sketch
  
}


// The draw method runs continuously (in a loop) until the program ends
void draw() {

  // Call the rotateImage method to rotate the image by the amount of the angle variable
  
  image (pictureOfRecord, 0, 0);  //draws the record image after it has been rotated
  
  // Increase the angle variable to add more rotation 
  
  // Run the program. The record should spin!
  
  // Now change the code above, so the record only spins when the mouse is pressed.
    
}

/* ONLY DO THIS NEXT PART IF YOUR COMPUTER CAN PLAY SOUNDS FROM JAVA 
   You may need to import the Minim library. Ask your teacher if you're not sure */

// If you want to use your own sound, find a small song file (mp3). 
// Drop the song file onto your code window.
// Now add the following lines of code where it tells you to put them

// import ddf.minim.*;             //at the very top of your sketch
//  Minim minim;                   //as a member variable
//  AudioPlayer song;              //as a member variable
//  minim = new Minim(this);       //in the setup method
//  song = minim.loadFile("awesomeTrack.mp3", 512);   //in the setup method

// Only play the song when the mouse is pressed.
// Hint: you will need the methods below
//       song.play()
//       song.pause()

// DO NOT CHANGE THIS METHOD - CALL IT FROM THE DRAW METHOD 
// The rotateImage method will rotate a given image by the number of degrees specified
   void rotateImage(PImage image, int amountToRotate) {
        translate(width/2, height/2);
        rotate(amountToRotate*TWO_PI/360);
        translate(-image.width/2, -image.height/2);
    }
