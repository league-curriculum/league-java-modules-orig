package _03_Conways_Game_of_Life;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
	private int cellsPerRow;
	private int cellSize;
	private Cell[][] cells;
	private Timer timer;
	
	public WorldPanel(int w, int h, int cpr) {
		setPreferredSize(new Dimension(w, h));
		addMouseListener(this);
		timer = new Timer(500, this);
		this.cellsPerRow = cpr;
	
		cellSize = h / cellsPerRow;
		
		cells = new Cell[cellsPerRow][cellsPerRow];
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells[0].length; j++) {
				cells[i][j] = new Cell(j * cellSize, i * cellSize, cellSize);
			}
		}
	}
	
	public void randomizeCells() {
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells[0].length; j++) {
				cells[i][j].isAlive = new Random().nextBoolean();
			}
		}
		repaint();
	}
	
	public void clearCells() {
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells[0].length; j++) {
				cells[i][j].isAlive = false;
			}
		}
		repaint();
	}
	
	public void startAnimation() {
		timer.start();
	}
	
	public void stopAnimation() {
		timer.stop();
	}
	
	public void setAnimationDelay(int sp) {
		timer.setDelay(sp);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells[0].length; j++) {
				cells[i][j].draw(g);
			}
		}
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}
	
	//advances world one step
	public void step() {
		//iterate through cells and get their neighbors
		//check if each cell should live or die
		int[][] numLivingNbors = new int[cellsPerRow][cellsPerRow];
		for(int i = 0; i < cellsPerRow; i++) {
			for(int j = 0; j < cellsPerRow; j++) {
				numLivingNbors[i][j] = getLivingNeighbors(i, j);
			}
		}
		for(int i = 0; i < cellsPerRow; i++) {
			for(int j = 0; j < cellsPerRow; j++) {
				cells[i][j].liveOrDie(numLivingNbors[i][j]);
			}
		}
		repaint();
	}
	
	//returns an array list of the  8 or less neighbors of the 
	//cell identified by x and y
	public int getLivingNeighbors(int x, int y){
		int livingNeighbors = 0;
		
		if(x != 0) {
			if(cells[x - 1][y].isAlive) livingNeighbors++;
		}
		
		if(x != cellsPerRow - 1) {
			if(cells[x + 1][y].isAlive) livingNeighbors++;
		}
		if(y != 0) {
			if(cells[x][y - 1].isAlive) livingNeighbors++;
		}
		if(y != cellsPerRow - 1) {
			if(cells[x][y + 1].isAlive) livingNeighbors++;
		}
		if(x != 0 && y != 0) {
			if(cells[x - 1][y - 1].isAlive) livingNeighbors++;
		}
		if(x != cellsPerRow - 1 && y != cellsPerRow - 1) {
			if(cells[x + 1][y + 1].isAlive) livingNeighbors++;
		}
		if(x != 0 && y != cellsPerRow - 1) {
			if(cells[x - 1][y + 1].isAlive) livingNeighbors++;
		}
		if(x != cellsPerRow - 1 && y != 0) {
			if(cells[x + 1][y - 1].isAlive) livingNeighbors++;
		}
		
		return livingNeighbors;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mousePressed(MouseEvent e) {
		for(int i = 0; i < cellsPerRow; i++) {
			for(int j = 0; j < cellsPerRow; j++) {
				Cell c = cells[i][j];
				if(e.getX() > c.getX() && e.getX() < (c.getX() + cellSize) &&
				   e.getY() > c.getY() && e.getY() < (c.getY() + cellSize)) {
					c.isAlive = !c.isAlive;
				}
			}
		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		step();		
	}
}
