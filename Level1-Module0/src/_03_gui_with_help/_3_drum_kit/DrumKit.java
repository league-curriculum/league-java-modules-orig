package _03_gui_with_help._3_drum_kit;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import game_tools.Sound;

public class DrumKit implements MouseListener {
    static boolean canPlaySounds = true; // Set this to false if your computer cannot play sounds
    JLabel drumLabel;

    public void run() {
        //  Make a JFrame variable and initialize it using "new JFrame()"

        //  Make the frame visible and
        // set its default close operation to JFrame.EXIT_ON_CLOSE

        //  Set the title of the frame

        //  Make a JPanel variable and initialize it using "new JPanel().

        //  Add the panel to the frame. (The panel is invisible.)

        //  Use the image of a drum provided ("snare.jpg") or
        //  download an image of a drum from the Internet and drop it into the
        //  Drum Kit recipe package.

        //  Put the name of the drum image file in a String variable.

        //  Edit the next line to use your String variable
        // drumLabel = createLabelImage(drumImageString);

        //  Add the label to the panel

        //  Call the pack() method on the frame.
        // Run your program. Do you see your drum image?

        // Add this MouseListener to drumLabel

        // *** Write the code in the mouseClicked() method below

        //  Set the layout of the panel to "new GridLayout()"

        //  Add a cymbal image to make a Drum Kit (one has been provided).
        //  You will need a different sound to go with this image.
        //  Remember to add this MouseListener to it. Run the program.

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Print "mouse clicked" to the console. Run your program and watch
        // the console to see when this is printed.

        //JLabel labelClicked = (JLabel) e.getSource(); // This line gets the label
                                                        // that the mouse
                                                        // clicked on

        // You can use the drum sound provided ("drum.wav") or
        // download another drum sound (.wav) and drop it into the Drum Kit package.
        // You can find sounds on freesound.org, and to download from there, you must log in
        // Ask your teacher for The League's login information.

        //  If the user clicks on the drumImage...use the playSound method to play the drum sound.
        //  Test to see if it works before moving on.

    }

    private JLabel createLabelImage(String fileName) {
        JLabel imageLabel = new JLabel();
        URL imageURL = getClass().getResource(fileName);
        if (imageURL == null) {
            imageLabel.setText("Could not find image " + fileName);
        } else {
            Icon icon = new ImageIcon(imageURL);
            imageLabel.setIcon(icon);
        }
        return imageLabel;
    }


    public static synchronized void playSound(String fileName) {
        if (canPlaySounds) {
            Sound s = new Sound("_03_gui_with_help/_3_drum_kit/" + fileName);
            s.play();
        } else {
            JOptionPane.showMessageDialog(null, "Cannot play "+fileName, "No Sound", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
