package Week_3_Task_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SampleBufferedReader {
    public static void main(String[] args) {
        String fileName = "E:\\AAA-YUNUS_BSc\\TY\\TY-SEM-2\\Data-Inn-Internship\\Java-Project-Container\\DataInn_Internship_Tasks\\src\\Week_3_Task_2\\sample.txt";
        System.out.println();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) { // readLine() returns String and null if no more lines exist
                System.out.println(line);
            }

        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
