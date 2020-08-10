package JVM;

import java.io.FileWriter;
import java.io.IOException;


public class GenerateString {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("words.txt");
        for (int i = 0; i < 100000; i++) {
            int length = (int) (Math.random() * (10 - 1 + 1) + 1);
            fileWriter.write(getString(length) + "\n");
        }
        fileWriter.close();
    }

    private static String getString(int length) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int num = (int) (Math.random() * (90 - 65 + 1) + 65) + (int) (Math.random() * 2) * 32;
            str.append((char) num);
        }
        return str.toString();
    }
}
