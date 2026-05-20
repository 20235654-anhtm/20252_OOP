package hust.soict.elitech.lab01.code;
import java.util.Scanner;

public class bai63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter the height of the triangle
        System.out.print("Enter the height of the triangle: ");
        int n = scanner.nextInt();
        
        // Loop to print the triangle
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line
        }
        
        scanner.close();
    }
}
