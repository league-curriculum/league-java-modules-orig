package _03_Intro_to_2D_Arrays;

/*
 *  A 2D array is comparable to a matrix/grid ordered by rows and columns.
 *  A 2D array that holds 3, 1D arrays with each 1D array having 3 elements
 *  can be thought of a 3x3 matrix/grid:
 *                 col0 col1 col2
 *                  \/   \/   \/
 *          row 0  { 1,  2,  3 }
 *          row 1  { 4,  5,  6 }
 *          row 2  { 7,  8,  9 }
 *          
 *  Where row 0 contains the numbers 1, 2, 3.
 *  and column 0 contains the numbers 1, 4, 7.
 *  
 *  Java stores a 2D array in 'row-major order', meaning the row number is
 *  the first number in the square brackets. The row 0 elements are:
 *  
 *  Row 0 = matrix[0][0], matrix[0][1], matrix[0][2]    // 1, 2, 3  
 * 
 *  The second number in the square brackets is the column number.
 *  The column 0 elements are:
 *  
 *  Column 0 = matrix[0][0], matrix[1][0], matrix[2][0] // 1, 4, 7
 */
public class _02_2DArrayPractice {
    /*
     * Return a 2D array that can accommodate the grid of values below:
     *          0, 1, 2
     *          3, 4, 5
     *          6, 7, 8
     */
    public Integer[][] test1() {

        return new Integer[3][3];
    }

    /*
     * Return a 2D array that can accommodate the grid of values below:
     *          "a", "b", "c", "d",
     *          "e", "f", "g", "e"
     */
    public String[][] test2() {

        return new String[2][4];
    }

    /*
     * Return a 2D array that can accommodate the grid of values below:
     *          true, false,
     *          false, false,
     *          false, true,
     *          true, true,
     *          true, false
     */
    public Boolean[][] test3() {

        return new Boolean[5][2];
    }

    /*
     * Draw the grid of values for the following 2D array of ints:
     * Assume all the elements in the 2D array are initialized to random ints
     * 
     * int[][] grid = new int[2][3];
     * 
     * 
     * 1, 2, 3
     * 4, 5, 6
     * Show your teacher the grid you created
     */

    /*
     * Draw the grid of values for the following 2D array of Robots
     * Assume all the elements in the 2D array are initialized.
     * 
     * Robot[][] robots = new Robot[4][2];
     * 
     * 
     * 1, 2,
     * 3, 4,
     * 5, 6,
     * 7, 8
     * Show your teacher the grid you created
     */

    /* Given the array of Objects below, return the element that is not null
     *          null, null, null, null
     *          null, null, null, Object
     */
    public Object test4() {
        Object[][] objects = { {null, null, null, null}, {null, null, null, new Object()} }; 

        return objects[1][3];
    }

    /* Given the array of Objects below, return the element that is not null
     *          null, null, Object, null
     *          null, null, null, null
     */
    public Object test5() {
        Object[][] objects = { {null, null, new Object(), null}, {null, null, null, null} }; 

        return objects[0][2];
    }

    /*
     * Write an algorithm to return the sum of all the numbers in the
     * first row (row 0)
     */
    public Integer test6() {
        int[][] nums = { {8, 7, 6, 5}, {4, 3}, {2, 1, 0} };
        
        int sum = 0;
        for (int i = 0; i < nums[0].length; i++) {
            sum += nums[0][i];
        }
        return sum;
    }

    /*
     * Write an algorithm to return the sum of all the numbers in the
     * second column (column 1)
     */
    public Integer test7() {
        int[][] nums = { {8, 7, 6, 5}, {4, 3}, {2, 1, 0} };

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i][0];
        }
        return sum;
    }

    /*
     * Write an algorithm to return the sum of all the numbers in the
     * specified row
     */
    public int getSumByRow(int[][] matrix, int row) {
        int sum = 0;

        for (int i = 0; i < matrix[row].length; i++) {
            sum += matrix[row][i];
        }

        return sum;
    }

    /*
     * Write an algorithm to return the sum of all the numbers in the
     * specified column
     */
    public int getSumByColumn(int[][] matrix, int col) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][col];
        }

        return sum;
    }
}