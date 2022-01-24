package _09_HungryHungryHippos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Hippo {
    /*
     * Member variables
     */
    String location;
    int startNeckSpeed = 15;
    int neckMoveDistance = 100;

    /*
     * Constructor
     */
    public Hippo(String location) {
        this.location = location;
        
        setupPosition();
    }
    
    void draw(Graphics g) {
        /*
         * Local variables
         */
        Color bodyColor = Color.GRAY;
        String hippoName = "Hippie Hippo";
        
        drawScore(g, hippoName);
        
        // Body
        g.setColor(bodyColor);
        g.fillOval(x, y, width, height);

        // Neck
        g.setColor(bodyColor);
        g.fillRect(neckX, neckY, neckLength, neckWidth);
        
        // Teeth (draw before head)
        g.setColor(Color.WHITE);
        g.fillRect(teethX, teethY, teethLength, teethWidth);
        g.fillRect(teethX2, teethY2, teethLength, teethWidth);

        // Ears (draw before head)
        g.setColor(bodyColor);
        g.fillOval(earX, earY, earLength, earLength);
        g.fillOval(earX2, earY2, earLength, earLength);
        g.setColor(Color.WHITE);
        g.fillOval(earX, earY, earLength - 10, earLength - 10);
        g.fillOval(earX2, earY2, earLength - 10, earLength - 10);

        // Head
        g.setColor(bodyColor);
        g.fillOval(headX, headY, headWidth, headLength - 20);
        g.fillOval(headX2, headY2, headWidth + 20, headLength);

        // Eyes
        g.setColor(Color.BLACK);
        g.fillOval(eyeX, eyeY, eyeWidth, eyeLength);
        g.fillOval(eyeX2, eyeY2, eyeWidth, eyeLength);

        // Nose
        g.setColor(Color.BLACK);
        g.fillOval(noseX, noseY, noseWidth, noseLength);
        g.fillOval(noseX2, noseY2, noseWidth, noseLength);
        
        update(g);
    }
    
    
    
    
    /*
     * ====================== DO NOT EDIT THE CODE BELOW ======================
     */
    
    int x, y, width, height;
    int neckX, neckY, neckWidth, neckLength, neckSpeed = 0;
    int headX, headX2, headY, headY2, headWidth, headLength;
    int earX, earX2, earY, earY2, earLength = 30;
    int teethX, teethX2, teethY, teethY2, teethWidth, teethLength;
    int eyeX, eyeX2, eyeY, eyeY2, eyeWidth, eyeLength;
    int noseX, noseX2, noseY, noseY2, noseWidth, noseLength;
    int melonsEaten;
    boolean isEating = false;
    Rectangle collisionBox;
    
    void eat() {
        if (!isEating) {
            neckSpeed = startNeckSpeed;
            isEating = true;
        }
    }

    void drawScore(Graphics g, String hippoName) {
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.BLACK);
        
        if( location.equalsIgnoreCase("up") ){
            g.drawString("Melons eaten: " + melonsEaten, headX + headWidth, neckY);
            g.drawString(hippoName, headX + headWidth, neckY + 20);
        }
        else if( location.equalsIgnoreCase("down") ) {
            g.drawString("Melons eaten: " + melonsEaten, headX + headWidth, y + 10);
            g.drawString(hippoName, headX + headWidth, y + 10 + 20);
        }
        else if( location.equalsIgnoreCase("left")) {
            g.drawString("Melons eaten: " + melonsEaten, 5, neckY + height);
            g.drawString(hippoName, 5, neckY + height + 20);
        }
        else if( location.equalsIgnoreCase("right")) {
            g.drawString("Melons eaten: " + melonsEaten, x - 30, neckY + height);
            g.drawString(hippoName, x - 30, neckY + height + 20);
        }
    }
    
    private void update(Graphics g) {
        if (isEating) {
            if (location.equalsIgnoreCase("up") || location.equalsIgnoreCase("down")) {
                
                if (neckWidth > neckMoveDistance) {
                    neckSpeed = -neckSpeed;
                } else if (neckWidth + neckSpeed < height / 4) {
                    neckWidth = height / 4;
                    neckSpeed = 0;
                    isEating = false;
                }
                
                collisionBox.setBounds(headX, headY2, headWidth, headLength);
                neckWidth += neckSpeed;
                
                if( location.equalsIgnoreCase("down") ){
                    neckY -= neckSpeed;
                }
                
            } else if (location.equalsIgnoreCase("left") || location.equalsIgnoreCase("right") ) {
                
                if (neckLength > neckMoveDistance) {
                    neckSpeed = -neckSpeed;
                } else if (neckLength + neckSpeed < width / 4) {
                    neckLength = width / 4;
                    neckSpeed = 0;
                    isEating = false;
                }
                
                neckLength += neckSpeed;
                
                if( location.equalsIgnoreCase("right") ) {
                    neckX -= neckSpeed;
                    collisionBox.setBounds(headX2, headY, headWidth, headLength);
                } else {
                    collisionBox.setBounds(headX2, headY, headWidth, headLength);
                }
            }
            
            updatePosition();
        }
    }

    private void updatePosition() {
        if (location.equalsIgnoreCase("up")) {
            this.x = (HungryHungryHippos.GAME_WIDTH - this.width) / 2;
            this.y = -height / 2;
            this.neckX = x + ((width - neckLength) / 2);
            this.neckY = y + height - 10;
            this.headWidth = width - 20;
            this.headLength = width/2 + 10;
            this.headX = x + 10;
            this.headX2 = x;
            this.headY = neckY + neckWidth;
            this.headY2 = headY + width / 4;
            this.earX = headX - 5;
            this.earX2 = earX + headWidth - earLength / 2;
            this.earY = this.earY2 = headY;
            this.teethLength = 10;
            this.teethWidth = 15;
            this.teethX = neckX;
            this.teethX2 = neckX + 20;
            this.teethY = this.teethY2 = headY + headWidth - 5;
            this.eyeWidth = 15;
            this.eyeLength = 20;
            this.eyeX = neckX - eyeWidth / 2;
            this.eyeX2 = eyeX + neckLength;
            this.eyeY = this.eyeY2 = headY + headLength/4;
            this.noseWidth = 10;
            this.noseLength = 20;
            this.noseX = eyeX;
            this.noseX2 = eyeX2 + noseWidth / 2;
            this.noseY = this.noseY2 = headY2 + headLength / 2;

        } else if (location.equalsIgnoreCase("down")) {

            this.x = (HungryHungryHippos.GAME_WIDTH - this.width) / 2;
            this.y = HungryHungryHippos.GAME_HEIGHT - ((3 * this.height) / 4) + 20;
            this.neckX = x + ((width - neckLength) / 2);
            this.neckY = y - neckWidth + 10;
            this.headWidth = width - 20;
            this.headLength = width / 2 + 10;
            this.headX = x + 10;
            this.headX2 = x;
            this.headY = neckY - headLength/2 - 5;
            this.headY2 = headY - width / 4 - headWidth / 4;
            this.earX = headX - 5;
            this.earX2 = earX + headWidth - earLength / 2;
            this.earY = this.earY2 = neckY - 10;
            this.teethLength = 10;
            this.teethWidth = 15;
            this.teethX = neckX;
            this.teethX2 = neckX + 20;
            this.teethY = this.teethY2 = headY - headLength + 5;
            this.eyeWidth = 15;
            this.eyeLength = 20;
            this.eyeX = neckX - eyeWidth / 2;
            this.eyeX2 = eyeX + neckLength;
            this.eyeY = this.eyeY2 = this.headY + 10;
            this.noseWidth = 10;
            this.noseLength = 20;
            this.noseX = eyeX;
            this.noseX2 = eyeX2 + noseWidth / 2;
            this.noseY = this.noseY2 = headY2 + headLength / 2 - noseLength;

        } else if (location.equalsIgnoreCase("left")) {

            this.x = -width / 2;
            this.y = (HungryHungryHippos.GAME_HEIGHT - this.height) / 2;
            this.neckX = x + width - 10;
            this.neckY = y + ((height - neckWidth) / 2);
            this.headWidth = height / 2;
            this.headLength = height;
            this.headX = neckX + neckLength;
            this.headX2 = headX + height / 4;
            this.headY = y + 10;
            this.headY2 = y;
            this.earX = this.earX2 = headX;
            this.earY = y;
            this.earY2 = this.earY + height - earLength;
            this.teethLength = 15;
            this.teethWidth = 10;
            this.teethX = this.teethX2 = headX2 + headWidth + 20 - 5;
            this.teethY = neckY;
            this.teethY2 = neckY + 20;
            this.eyeWidth = 20;
            this.eyeLength = 15;
            this.eyeX = this.eyeX2 = headX + 20;
            this.eyeY = neckY - 10;
            this.eyeY2 = neckY + neckWidth - 10;
            this.noseWidth = 20;
            this.noseLength = 10;
            this.noseX = this.noseX2 = headX + height / 2;
            this.noseY = neckY - noseLength;
            this.noseY2 = neckY + neckWidth - noseLength / 2;

        } else if (location.equalsIgnoreCase("right")) {

            this.x = HungryHungryHippos.GAME_WIDTH - ((3 * this.width) / 4) + 20;
            this.y = (HungryHungryHippos.GAME_HEIGHT - this.height) / 2;
            this.neckX = x - neckLength + 10;
            this.neckY = y + ((height - neckWidth) / 2);
            this.headWidth = height / 2;
            this.headLength = height;
            this.headX = neckX - headWidth;
            this.headX2 = headX - height / 4 - headWidth / 2 + 10;
            this.headY = y + 10;
            this.headY2 = y;
            this.earX = this.earX2 = neckX - earLength + 5;
            this.earY = y;
            this.earY2 = this.earY + height - earLength;
            this.teethLength = 15;
            this.teethWidth = 10;
            this.teethX = this.teethX2 = headX2 - teethLength + 5;
            this.teethY = neckY;
            this.teethY2 = neckY + 20;
            this.eyeWidth = 20;
            this.eyeLength = 15;
            this.eyeX = this.eyeX2 = headX + 20;
            this.eyeY = neckY - 10;
            this.eyeY2 = neckY + neckWidth - 10;
            this.noseWidth = 20;
            this.noseLength = 10;
            this.noseX = this.noseX2 = headX - headLength / 4;
            this.noseY = neckY - noseLength;
            this.noseY2 = neckY + neckWidth - noseLength / 2;
        }
    }

    private void setupPosition() {
        if (location.equalsIgnoreCase("up") || location.equalsIgnoreCase("down")) {
            this.width = 125;
            this.height = 200;
            this.neckLength = width / 5;
            this.neckWidth = height / 4;
            
            if( location.equalsIgnoreCase("down") ) {
                this.collisionBox = new Rectangle(headX2, headY, headWidth, headLength);
            } else {
                this.collisionBox = new Rectangle(headX, headY, headWidth, headLength);
            }
            
        } else if(location.equalsIgnoreCase("left") || location.equalsIgnoreCase("right")) {
            this.width = 200;
            this.height = 125;
            this.neckLength = width / 4;
            this.neckWidth = height / 5;
            this.collisionBox = new Rectangle(headX, headY, headX2 + headWidth, headY2 + headLength);
        }

        updatePosition();
    }
}
