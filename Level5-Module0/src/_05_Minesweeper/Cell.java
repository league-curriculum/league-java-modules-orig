package _05_Minesweeper;

import processing.core.PApplet;
import processing.core.PImage;

public class Cell {
    static PApplet processing;
    static int width = 40;
    static PImage[] images;
    static PImage empty, one, two, three, four, five, six, seven, eight;
    static PImage mineImg, flagImg, wonImg, lostImg;

    int i, j, x, y;
    int cellColor;
    int minesAround;
    boolean mine, revealed, flagged;

    public Cell(int i, int j, int cell_color, int gamePanelHeight) {
        this.i = i;                     // cell row #
        this.j = j;                     // cell col #
        this.x = i * Cell.width;        // cell x in pixels
        this.y = j * Cell.width;        // cell y in pixels
        this.y += gamePanelHeight;      // cell y adjustment
        this.cellColor = cell_color;
        this.mine = false;
        this.revealed = false;
        this.flagged = false;
        this.minesAround = 0;
    }

    static void initializeImages(PApplet p, int w) {
        Cell.processing = p;
        Cell.width = w;
        Cell.empty = processing.loadImage("empty.png");
        Cell.one = processing.loadImage("1.png");
        Cell.two = processing.loadImage("2.png");
        Cell.three = processing.loadImage("3.png");
        Cell.four = processing.loadImage("4.png");
        Cell.five = processing.loadImage("5.png");
        Cell.six = processing.loadImage("6.png");
        Cell.seven = processing.loadImage("7.png");
        Cell.eight = processing.loadImage("8.png");
        Cell.mineImg = processing.loadImage("bomb.png");
        Cell.flagImg = processing.loadImage("flag.png");
        Cell.wonImg = processing.loadImage("sunglasses.png");
        Cell.lostImg = processing.loadImage("cry.png");

        // Only add new images to the end of the array. The array index
        // is used to display the corresponding image for surrounding mines.
        Cell.images = new PImage[] {
                Cell.empty, Cell.one, Cell.two, Cell.three, Cell.four,
                Cell.five, Cell.six, Cell.seven, Cell.eight,
                Cell.mineImg, Cell.flagImg, Cell.wonImg, Cell.lostImg
                };

        for (PImage img : Cell.images) {
            img.resize(Cell.width, Cell.width);
        }
    }

    void draw() {
        if (this.revealed) {
            if (mine) {
                processing.image(Cell.mineImg, x, y);
            } else {
                processing.fill(255);
                processing.rect(x, y, Cell.width, Cell.width);
                processing.image(Cell.images[minesAround], x, y);
            }
        } else {
            processing.fill(cellColor);
            processing.rect(x, y, Cell.width, Cell.width);
        }

        // Draw pin after cell background
        if (this.flagged) {
            processing.image(Cell.flagImg, x, y);
        }

        // Draw cell border at the end on top of the images
        // for clearer cell separation
        processing.stroke(0);
        processing.strokeWeight(1);
        processing.noFill();
        processing.rect(x, y, Cell.width, Cell.width);
    }
}
