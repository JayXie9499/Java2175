package me.jay.Java2175.Week04;

public class Exercise01 {
    public static void main(String[] args) {
        final int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Matrix:");
        printMatrix(matrix);

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] matrixT = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixT[j][i] = matrix[i][j];
            }
        }
        System.out.println("Matrix T:");
        printMatrix(matrixT);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[\t");
            for (int e : row) {
                System.out.printf("%d\t", e);
            }
            System.out.print("]\n");
        }
    }
}
