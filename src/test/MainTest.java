package test;

import domain.Main;
import java.util.Scanner;

/**
 *
 * @author vkrychevska
 */
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
