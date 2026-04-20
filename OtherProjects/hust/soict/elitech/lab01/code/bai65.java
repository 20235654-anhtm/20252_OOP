package hust.soict.elitech.lab01.code;
import java.util.Arrays;
import java.util.Scanner;

public class bai65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask the user for array size
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        
        // Input array elements
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        // Sorting the array
        Arrays.sort(numbers);
        
        // Calculating sum
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        
        // Calculating average
        double average = (double) sum / size;
        
        // Display results
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        
        scanner.close();
    }
}