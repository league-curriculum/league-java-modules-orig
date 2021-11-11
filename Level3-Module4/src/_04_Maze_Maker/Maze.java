package _04_Maze_Maker;
import java.awt.Graphics;

public class Maze {
	private Cell[][] maze;

	private int width;
	private int height;

	public Maze(int w, int h) {
		this.width = w;
		this.height = h;

		maze = new Cell[w][h];

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				maze[i][j] = new Cell(i, j);
			}
		}
	}

	public void draw(Graphics g) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				maze[i][j].draw(g);
			}
		}
	}
	
	public Cell getCell(int x, int y){
		return maze[x][y];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
