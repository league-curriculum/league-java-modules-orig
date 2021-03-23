package _02_Pixel_Art;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GridPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private int windowWidth;
	private int windowHeight;
	private int pixelWidth;
	private int pixelHeight;
	private int rows;
	private int cols;
	
	private Pixel[][] pixels;
	
	private Color color;
	
	public GridPanel(int w, int h, int r, int c) {
		this.windowWidth = w;
		this.windowHeight = h;
		this.rows = r;
		this.cols = c;
		
		this.pixelWidth = windowWidth / cols;
		this.pixelHeight = windowHeight / rows;
		
		color = Color.BLACK;
		
		setPreferredSize(new Dimension(windowWidth, windowHeight));
		
		pixels = new Pixel[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				pixels[i][j] = new Pixel(i, j);
			}
		}
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public void clickPixel(int mouseX, int mouseY) {	
		Pixel p = pixels[mouseY / pixelHeight][mouseX / pixelWidth];
		p.color = color;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				g.setColor(pixels[i][j].color);
				g.fillRect(j * pixelWidth, i * pixelHeight, pixelWidth, pixelHeight);
				g.setColor(Color.BLACK);
				g.drawRect(j * pixelWidth, i * pixelHeight, pixelWidth, pixelHeight);
			}
		}
	}
}
