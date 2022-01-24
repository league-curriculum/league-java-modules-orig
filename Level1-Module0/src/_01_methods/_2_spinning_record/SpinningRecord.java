package _01_methods._2_spinning_record;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javazoom.jl.player.advanced.AdvancedPlayer;
import processing.core.PApplet;
import processing.core.PImage;

/*
 * Goal: Make a record spin and play music!
 * 
 * 1. Make an int variable to keep track of how much the record will spin.
 * 
 * In the setup() method:
 * 2. Load a picture of a record using the loadImage() method:
 *    pictureOfRecord = loadImage("images/record.png");
 * 
 * 3. Call the image variable's resize() method to set the image's width and
 *    height to the window's width and height.
 * 
 * 4. Call the image() method to display the record image. Do you see it?
 * 
 * In the draw() method:
 * 
 * 5. Make the record spin by increasing the variable from step 1.
 * 
 * 6. Call the rotateImage() method to rotate record by the specified amount
 *    rotateImage(PImage image, int amountToRotate);
 * 
 * 7. Call the image() method to display the record image
 *    Make sure to put this code AFTER the rotateImage() method.
 * 
 * 8. Does the record rotate when the mouse is pressed?
 * 
 * 9. Modify your code so the record only spins when the mouse is pressed.
 * 
 * 10.Use the song.play() and song.stop() methods to play a song ONLY when
 *    the record is spinning.
 */
public class SpinningRecord extends PApplet {
    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    
    Song song = new Song("src/awesomeTrack.mp3");
    PImage pictureOfRecord;
    
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        
    }

    @Override
    public void draw() {
        
    }

    static public void main(String[] args) {
        PApplet.main(SpinningRecord.class.getName());
    }
    
    /*********************** DO NOT MODIFY THE CODE BELOW ********************/

    void rotateImage(PImage image, int amountToRotate) {
        translate(width / 2, height / 2);
        rotate(amountToRotate * TWO_PI / 360);
        translate(-image.width / 2, -image.height / 2);
    }

    class Song {
        private int duration;
        private String songAddress = null;
        private AdvancedPlayer mp3Player = null;
        private InputStream songStream = null;

        public Song(String songAddress) {
            this.songAddress = songAddress;
        }

        public void play() {
            if (songStream == null) {
                loadFile();
                if (songStream != null) {
                    loadPlayer();
                    start();
                } else {
                    System.err.println("ERROR: Unable to load file: " + songAddress);
                }
            }
        }

        public void setDuration(int seconds) {
            this.duration = seconds;
        }

        public void stop() {
            if (mp3Player != null) {
                mp3Player.close();
            }
            songStream = null;
        }

        private void start() {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        if (duration > 0) {
                            mp3Player.play(duration);
                        } else {
                            mp3Player.play();
                        }
                    } catch (Exception e) {
                    }
                }
            };
            t.start();
        }

        private void loadPlayer() {
            try {
                this.mp3Player = new AdvancedPlayer(songStream);
            } catch (Exception e) {
            }
        }

        private void loadFile() {
            if (songAddress.contains("http"))
                this.songStream = loadStreamFromInternet();
            else
                this.songStream = loadStreamFromComputer();
        }

        private InputStream loadStreamFromInternet() {
            try {
                return new URL(songAddress).openStream();
            } catch (Exception e) {
                return null;
            }
        }

        private InputStream loadStreamFromComputer() {
            try {
                return new FileInputStream(songAddress);
            } catch (FileNotFoundException e) {
                return this.getClass().getResourceAsStream(songAddress);
            }
        }
    }
}
