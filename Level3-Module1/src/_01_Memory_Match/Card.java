package _01_Memory_Match;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Card extends JButton {
    private static final long serialVersionUID = 1L;
    
    /*
     * Use this for the accessing the card images
     */
    public static String cardImagesPath = "/CardImages/";
    
    private int value;
    private boolean faceUp = false;
    private boolean matched = false;
    private String faceUpImageFilename = null;
    private ImageIcon faceUpIcon = null;
    private static String faceDownImageFilename = cardImagesPath + "B1.png";
    public static ImageIcon faceDownIcon = null;;

    public Card( int value ) {
        this.value = value;
        setup();
    }
    
    private void setup() {
        setHorizontalTextPosition(JButton.CENTER);
        setBorder(new LineBorder(Color.BLACK));
        setSize(new Dimension(72, 96));
        setPreferredSize(new Dimension(72, 96));
        
        // Set the image for the card face down
        if( faceDownIcon == null ) {
            faceDownIcon = createImageIcon(faceDownImageFilename);
        }
        
        // Set the image for the card face up
        if( this.faceUpImageFilename != null ) {
            this.faceUpIcon = createImageIcon(this.faceUpImageFilename);
        }
        
        setIcon(faceDownIcon);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public boolean isMatched() {
        return this.matched;
    }
    
    public boolean isFaceUp() {
        return this.faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }
    
    public void setFaceUpIcon(String filename) {
        this.faceUpIcon = createImageIcon(filename);
    }
    
    public ImageIcon createImageIcon(String filename) {
        ImageIcon icon = null;
        
        try {
            Image image = ImageIO.read(getClass().getResource(filename));
            icon = new ImageIcon(image.getScaledInstance(72, 96, Image.SCALE_SMOOTH));
        } catch (IOException ex) {
            System.out.println("ERROR: Unable to get image from: " + filename);
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println("ERROR: Unable to get image from: " + filename);
        }
        
        return icon;
    }
    
    public void remove() {
        setFaceUp(false);
        setMatched(true);
        setIcon(null);
        setText(null);
        setBorder(null);
        setEnabled(false);
    }
    
    public void draw() {
        if( !this.matched ) {
            // This card is still on the board
            
            if( this.faceUp ) {
                if( this.faceUpIcon == null ) {
                    setText("" + this.value);
                }
                setIcon(faceUpIcon);
            } else {
                setText("");
                setIcon(faceDownIcon);
            }
        }
    }
    
    public boolean isSame(Card otherCard) {
        if( this.faceUpIcon == null ) {
            return this.getValue() == otherCard.getValue();
        }
        return (this.getValue() / 4) == (otherCard.getValue() / 4);
    }
}