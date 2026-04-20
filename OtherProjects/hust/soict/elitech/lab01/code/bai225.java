package hust.soict.elitech.lab01.code;
import javax.swing.JOptionPane;

public class bai225
 {
    public static void main(String[] args) {
        // Nhập hai số từ người dùng
        String strNum1 = JOptionPane.showInputDialog("Nhập số thứ nhất:");
        String strNum2 = JOptionPane.showInputDialog("Nhập số thứ hai:");

        // Chuyển đổi từ String sang double
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        // Thực hiện các phép toán
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        String quotient;

        // Kiểm tra nếu số thứ hai là 0 để tránh lỗi chia cho 0
        if (num2 != 0) {
            quotient = String.valueOf(num1 / num2);
        } else {
            quotient = "Không thể chia cho 0!";
        }

        // Hiển thị kết quả
        String message = "Tổng: " + sum +
                         "\nHiệu: " + difference +
                         "\nTích: " + product +
                         "\nThương: " + quotient;

        JOptionPane.showMessageDialog(null, message);
    }
}
