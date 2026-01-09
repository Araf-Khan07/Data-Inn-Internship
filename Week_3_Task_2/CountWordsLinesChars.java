package Week_3_Task_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordsLinesChars {
    public static void main(String[] args) {
        String fileName = "E:\\AAA-YUNUS_BSc\\TY\\TY-SEM-2\\Data-Inn-Internship\\Java-Project-Container\\DataInn_Internship_Tasks\\src\\Week_3_Task_2\\sample.txt";
        int charCount = 0, lineCount = 0, wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                lineCount++;

                charCount += line.length() + 1;

                line = line.trim();
                if (!line.isEmpty()) {
                    String[] wordArr = line.split("\\s+"); // Regular Expression for 1 or more whitespaces -> \s+
                    wordCount += wordArr.length;
                }
            }

            System.out.println("\nCharacter Count: " + charCount);
            System.out.println("Word Count: " + wordCount);
            System.out.println("Line Count: " + lineCount);

        } catch (IOException err) {
            err.printStackTrace();
        }

    }
}
