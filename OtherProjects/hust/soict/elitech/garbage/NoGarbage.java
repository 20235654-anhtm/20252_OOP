package hust.soict.hedspi.garbage;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "test.txt";
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        
        long startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
        	outputStringBuilder.append((char)b);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Thời gian chạy (ms): " + (endTime - startTime));
    }
}
