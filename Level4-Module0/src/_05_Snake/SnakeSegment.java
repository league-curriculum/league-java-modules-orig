package _05_Snake;

import java.awt.Graphics;

public class SnakeSegment {
    private Location location;
    private int size;

    public SnakeSegment(Location loc, int size) {
        this.location = loc;
        this.size = size;
    }
    
    public void setLocation(Location loc) {
        this.location = loc;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public void draw(Graphics g) {
        g.setColor(Snake.SNAKE_COLOR);
        g.drawRect(location.getX() * size, location.getY() * size, size, size);;
    }
}
