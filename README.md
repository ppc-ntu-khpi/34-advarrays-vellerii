
# Практична робота "Поглиблене використання масивів"
> **Завдання 4.** Знайти друге за величиною число у матриці розміром N x M.

## В рамках практичної роботи я зробила наступне:
* проаналізувала обране завдання і обрала оптимальний алгоритм для його вирішення;
* написала клас, який містить методи для розв'язання обраного мною завдання та тестовий клас, який дозволяє перевірити його роботу;
* в кінці своєї роботи над класом `Main` я додала javadoc-коментарі.
---
Програмний код класу `Main` наведений нижче.

```java
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
```

Програмний код класу `MainTest` наведений нижче.

```java
package test;

import domain.Main;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введіть кількість рядків матриці: ");
        int rows = scanner.nextInt();

        System.out.print("Введіть кількість стовпців матриці: ");
        int columns = scanner.nextInt();
        
        Main.startExecution(rows, columns);
    }
}
```
Перевірка працездатності класу `Main` ✅. Результат запуска коду наведений нижче.
![alt-текст](https://github.com/ppc-ntu-khpi/34-advarrays-vellerii/blob/master/result.png "result.png")
