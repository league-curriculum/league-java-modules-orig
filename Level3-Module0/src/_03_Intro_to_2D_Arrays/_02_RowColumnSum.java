package _03_Intro_to_2D_Arrays;

public class _02_RowColumnSum {
    public int getSumByRow(int[][] matrix, int row) {
        int sum = 0;

        for (int i = 0; i < matrix[row].length; i++) {
            sum += matrix[row][i];
        }

        return sum;
    }

    public int getSumByColumn(int[][] matrix, int col) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][col];
        }

        return sum;
    }
}
