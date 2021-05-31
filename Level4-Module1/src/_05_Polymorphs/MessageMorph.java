package _05_Polymorphs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class MessageMorph extends Polymorph{
    
    private Rectangle collisionBox;

    public MessageMorph(int x, int y, int width, int height) {
        super(x, y, width, height);
        collisionBox = new Rectangle(x,y,width,height);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
    
    public void displayMessage() {
        JOptionPane.showMessageDialog(null, "This is a message!");
    }

    @Override
    public void update() {
        
    }

    public Rectangle getCollisionBox() {
        return collisionBox;
    }

    public void setCollisonBox(Rectangle collisionBox) {
        this.collisionBox = collisionBox;
    }
}
