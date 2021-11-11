package _04_Maze_Maker;
import java.awt.Color;
import java.awt.Graphics;

public class Cell {
	public static final int X_MARGIN = 100;
	public static final int Y_MARGIN = 100;
	
	private int x;
	private int y;
	
	private int size = 100;
	
	private boolean visited;
	
	private boolean northWall;
	private boolean southWall;
	private boolean eastWall; 
	private boolean westWall;
	
	public Cell(int x, int y){
		this.x = x;
		this.y = y;
		
		visited = false;
		
		northWall = true;
		southWall = true;
		eastWall = true;
		westWall = true;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillOval((x * size) + (size / 2) + X_MARGIN, (y * size) + (size / 2) + Y_MARGIN, 4, 4);
		
		g.setColor(Color.RED);
		if(northWall){
			g.drawLine((x * size) + X_MARGIN, (y * size) + Y_MARGIN, (x * size) + size + X_MARGIN, (y * size) + Y_MARGIN);
		}
		if(southWall){
			g.drawLine((x * size) + X_MARGIN, (y * size) + size + Y_MARGIN, (x * size) + size + X_MARGIN, (y * size) + size + Y_MARGIN);
		}
		if(eastWall){
			g.drawLine((x * size) + size + X_MARGIN, (y * size) + Y_MARGIN, (x * size) + size + X_MARGIN, (y * size) + size + Y_MARGIN);
		}
		if(westWall){
			g.drawLine((x * size) + X_MARGIN, (y * size) + Y_MARGIN, (x * size) + X_MARGIN, (y * size) + size + Y_MARGIN);
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean hasBeenVisited() {
		return visited;
	}

	public void setBeenVisited(boolean beenVisited) {
		this.visited = beenVisited;
	}

	public boolean hasNorthWall() {
		return northWall;
	}

	public void setNorthWall(boolean northWall) {
		this.northWall = northWall;
	}

	public boolean hasSouthWall() {
		return southWall;
	}

	public void setSouthWall(boolean southWall) {
		this.southWall = southWall;
	}

	public boolean hasEastWall() {
		return eastWall;
	}

	public void setEastWall(boolean eastWall) {
		this.eastWall = eastWall;
	}

	public boolean hasWestWall() {
		return westWall;
	}

	public void setWestWall(boolean westWall) {
		this.westWall = westWall;
	}
}
