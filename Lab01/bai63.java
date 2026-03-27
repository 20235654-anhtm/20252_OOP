package Lab01;

import java.util.Scanner;

public class bai63 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Bước 1: Nhập chiều cao n từ người dùng
        System.out.print("Enter the height of the triangle (n): ");
        int n = keyboard.nextInt();

        // Bước 2: Vòng lặp để in từng dòng
        for (int i = 1; i <= n; i++) {
            // In khoảng trắng để căn giữa tam giác
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // In dấu sao (*). Số sao ở mỗi dòng là (2*i - 1)
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

            // Xuống dòng sau khi in xong một hàng
            System.out.println();
        }
        
        keyboard.close();
    }    
}
