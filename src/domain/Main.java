package domain;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * The Main class generates a matrix and finds the second largest number in it.
 */
public class Main {

    public static void startExecution(int rows, int columns) {
        int[][] matrix = generateMatrix(rows, columns);     
        findSecondLargestNumber(matrix);
    }
    
    /**
     * Generates a matrix of random integers between 0 and 99, based on the given number of rows and columns.
     * @param rows The number of rows in the matrix.
     * @param columns The number of columns in the matrix.
     * @return The generated matrix.
     */
    private static int[][] generateMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];

        Arrays.setAll(matrix, row -> new Random().ints(columns, 0, 100).toArray());

        System.out.println("Матриця:");
        
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        
        return matrix;
    }

    /**
     * Finds the second largest number in the given matrix and prints it to the console.
     * @param matrix The matrix to find the second largest number in.
     */
    private static void findSecondLargestNumber(int[][] matrix) {
        int[] sortedNumbersOfMatrix = Arrays.stream(matrix)
            .flatMapToInt(Arrays::stream)
            .sorted()
            .distinct()
            .toArray();

        int secondLargestNumber = sortedNumbersOfMatrix.length < 2 
                ? sortedNumbersOfMatrix[0] 
                : sortedNumbersOfMatrix[sortedNumbersOfMatrix.length - 2];
        
        System.out.println("Друге найбільше число: " + secondLargestNumber);      
    }
}
