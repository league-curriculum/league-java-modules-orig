package _05_Minesweeper;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

/*
 * Goal: Use streams to finish the Minesweeper game!
 * 
 * The Minesweeper game below is nearly finished. Your job is to use streams
 * to complete the remaining methods.
 * 
 * Background:
 * Minesweeper is a game where you try and reveal each cell without revealing
 * a mine. Under each cell there is either a mine, a number, or empty space.
 *   - If you click on a cell and it's a mine, you lose.
 *   - If you click on a cell and it's empty space, you're safe and can
 *     continue revealing other cells.
 *   - If you click on a cell and it's a number, you're safe. The number tells
 *     you how many mines are around that cell, for instance
 *       - - M         M = mine
 *       - 2 -         - = empty space
 *       - M -         2 = empty space and there are 2 mines around this cell
 *   - You use the numbers to determine where the mines are.
 *   - When all the cells without mines are revealed, you win.
 *   - You can right click on a cell and place a flag on it as a reminder that
 *     there's a mine there.
 */
public class Minesweeper extends PApplet {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 440;

    int rows, cols;
    Button startButton;
    boolean gameReady = false;
    boolean gameInProgress = false;
    int gameTimeSec;
    int nowMs;

    /*
     * Game settings
     */
    int cellWidth = 40;             // in pixels
    int headerHeight = cellWidth;   // height of game info header
    int numOfMines = 10;            // total number of mines in the game
    int minesFlagged = 0;           // number of mines flagged
    int cellColor = 0xBFC0BB;       // color of unrevealed cell
    
    /*
     * The cells list below contains the cells for the game. Each cell in the
     * list has the following member variables:
     * boolean mine;        // true = this cell is a mine
     * boolean revealed;    // true = this cell has been clicked and revealed
     * boolean flagged;     // true = this cell has a flag
     */
    List<Cell> cells;
    
    /*
     * Complete the method below using streams. Use the forEach() method so all
     * the Cell objects in the cell list are marked as revealed.
     * 
     * *Note* This can be done using a for loop, but try to do it with Streams.
     */
    void revealAllCells() {
        
    }
    
    /*
     * Complete the method below using streams so that it returns true if all
     * the cells without mines have been revealed. Otherwise return false.
     * You may find the following stream methods useful:
     *  filter()    // keep the items in the stream if the filter condition
     *                 returns true, remove all others
     *  count()     // returns how many items are in the stream
     *  noneMatch() // returns true if no items in the stream match the condition
     */
    boolean checkWin() {
        return false;
    }
    
    /*
     * A cell was clicked and this method needs to:
     * 1. Only do the following steps if the cell is NOT a mine.
     * 2. Mark the cell as revealed.
     * 3. If there are no mines around this cell (cell.minesAround == 0),
     *    call the getNeighbors() method to return a list of all the
     *    surrounding Cell objects.
     * 4. Use a stream to reveal any of the neighboring cells in the list.
     *    The filter() and/or forEach() methods may be useful.
     * 5. Call revealCell() recursively to check if any neighbors (and
     *    neighbors of those neighbors) also need to be revealed.
     *    For example:
     *        M 1 - -       // When the cell with the X is clicked all
     *        1 1 - X       // cells with '-' should be revealed
     *        - - - -
     */
    void revealCell(Cell cell) {
        
    }
    
    /*
     * Complete this method using streams to set the number of surrounding
     * mines, cell.minesAround, for each cell in the cells List.
     * 1. Convert the cells list to a stream.
     * 2. Use forEach() to iterate through each cell.
     * 3. Call getNeighbors() to get a List of all the surrounding cell objects
     * 4. Convert the list of neighbors to a stream.
     * 5. Use a map() or mapToInt() to convert each neighbor that is a mine
     *    to a 1.
     * 6. Use reduce() or sum() to count the number of 1s, i.e. mines
     */
    void setNumberOfSurroundingMines() {
        
    }
    
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        initializeGameData();
    }

    @Override
    public void draw() {
        if (gameReady) {
            drawGameHeader();

            for (Cell c : cells) {
                c.draw();
            }

            updateGameTime();
        }
    }

    public static void main(String[] args) {
        PApplet.main(Minesweeper.class.getName());
    }

    // =================== DO NOT MODIFY THE CODE BELOW ======================

    /*
     * Draw top game header with # mines, start button, elapsed time
     */
    void drawGameHeader() {
        background(0xBFC0BB);
        fill(0);
        textSize(30);
        text(numOfMines - minesFlagged, 0, 30);
        text(String.format("%3d", gameTimeSec), WIDTH - 75, 30);
        startButton.draw();
    }

    /*
     * Win or lose, reveal all cells
     */
    void gameEnd(String state) {
        gameInProgress = false;

        if (state.equalsIgnoreCase("won")) {
            Cell.mineImg = Cell.wonImg;
        }
        
        revealAllCells();
    }

    /*
     * Return the cell that the mouse is currently hovering over
     */
    Cell checkCellPressed() {
        Cell cell = null;

        for (Cell c : cells) {
            if (c.x < mouseX && (c.x + cellWidth) > mouseX && c.y < mouseY && (c.y + cellWidth) > mouseY) {
                cell = c;
                break;
            }
        }

        return cell;
    }

    /*
     * Setup cell size, images, and start button
     */
    void initializeGameData() {

        this.rows = width / cellWidth;
        this.cols = (height - headerHeight) / cellWidth;

        Cell.initializeImages(this, cellWidth);
        Button.initialize(this);

        gameTimeSec = 0;

        if (startButton == null) {
            startButton = new Button("Start", (width / 2) - 50, 0, 100, cellWidth);
        }

        initializeCells();
        initializeMines();
    }

    /*
     * Setup cells, place mines, start game timer
     */
    void initializeCells() {
        cells = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells.add(new Cell(i, j, cellColor, headerHeight));
            }
        }
    }

    /*
     * Randomize mines in cells, set number of surrounding mines
     */
    void initializeMines() {

        // Don't place any mines if more than the number of cells--invalid starting
        // state
        if (numOfMines < (rows * cols)) {
            minesFlagged = 0;
            int mines_placed = 0;

            while (mines_placed != numOfMines) {
                Cell rand_cell = cells.get((int) (random(0, (rows * cols))));

                if (!rand_cell.mine) {
                    rand_cell.mine = true;
                    mines_placed += 1;
                }
            }
            gameReady = true;
        }

        // Set number of mines around each cell, zero to eight
        setNumberOfSurroundingMines();
    }

    /*
     * Start game timer at the very end for best accuracy
     */
    void startGameTimer() {
        nowMs = millis();
    }

    /*
     * Tracks game timer ~1 sec increments
     */
    void updateGameTime() {
        if (gameInProgress) {
            if (millis() > nowMs + 1000) {
                gameTimeSec += 1;
                nowMs = millis();
            }
        }
    }

    /*
     * Return list of all cells around specified cell
     */
    List<Cell> getNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<>();
        
        for (Cell c : cells) {
            if ((c.i >= cell.i - 1) &&
                (c.i <= cell.i + 1) &&
                (c.j >= cell.j - 1) &&
                (c.j <= cell.j + 1))
            {
                neighbors.add(c);
            }
        }
        
        return neighbors;
    }

    /*
     * Right mouse button: flag cell Left mouse button: reveal cell (mine, number,
     * or empty)
     */
    @Override
    public void mousePressed() {
        if (startButton.mouseIsOver()) {
            gameInProgress = true;
            initializeGameData();

            startGameTimer();
            return;
        } else if (!gameInProgress) {
            // Don't allow clicking on the cells before pressing the start button
            return;
        }

        Cell cell = checkCellPressed();

        if (cell != null) {
            if (mouseButton == RIGHT) {
                if (!cell.revealed) {
                    cell.flagged = !cell.flagged;
                    if (cell.flagged) {
                        minesFlagged += 1;
                    } else {
                        minesFlagged -= 1;
                    }
                }

            } else if (mouseButton == LEFT) {
                // Don't reveal pinned/marked cells. User must unpin to reveal.
                if (cell.flagged) {
                    return;
                }
                revealCell(cell);

                if (cell.mine) {
                    gameEnd("Lost");
                } else {
                    if( checkWin() ) {
                        gameEnd("Won");
                    }
                }
            }
        }
    }
}
