package Week_3_Task_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class SampleFileAnalyzer {
    public static void main(String[] args) {
        String fileName = "E:\\AAA-YUNUS_BSc\\TY\\TY-SEM-2\\Data-Inn-Internship\\Java-Project-Container\\DataInn_Internship_Tasks\\src\\Week_3_Task_2\\sample.txt";

        String longestWord = "";
        String shortestWord = null;
        HashSet<String> uniqueWords = new HashSet<>();

        System.out.println();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {

                // Remove punctuation from the line for clean word extraction
                line = line.replaceAll("[^a-zA-Z0-9\\s']", "");
                // Example: removes commas, periods, etc., but keeps apostrophes in words like "BMW’s"

                // Trim for safety
                line = line.trim();

                if (!line.isEmpty()) {
                    String[] words = line.split("\\s+"); // split by whitespace

                    for (String word : words) {

                        // Skip any accidental empty word
                        if (word.isEmpty()) continue;

                        // Add to unique set
                        uniqueWords.add(word.toLowerCase());

                        // Longest word check
                        if (word.length() > longestWord.length()) {
                            longestWord = word;
                        }

                        // Shortest word check
                        if (shortestWord == null || word.length() < shortestWord.length()) {
                            shortestWord = word;
                        }
                    }
                }
            }

            // Print results
            System.out.println("Longest Word: " + longestWord);
            System.out.println("Shortest Word: " + shortestWord);
            System.out.println("Number of Unique Words: " + uniqueWords.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
