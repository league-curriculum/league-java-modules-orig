package _04_Maze_Maker;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MazeDisplay extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	
	private JFrame window;
	
	private Maze maze;
	
	MazeDisplay(){
		super();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		window = new JFrame();
		
		window.add(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		
		maze = MazeMaker.generateMaze(5, 5);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g){
		maze.draw(g);
	}
	
	public static void main(String[] args) {
		MazeDisplay md = new MazeDisplay();
	}
}
