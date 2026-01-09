package Week_3_Task_2;

import java.io.FileReader;
import java.io.IOException;

public class SampleFileReader {
    public static void main(String[] args) {
        String fileName = "E:\\AAA-YUNUS_BSc\\TY\\TY-SEM-2\\Data-Inn-Internship\\Java-Project-Container\\DataInn_Internship_Tasks\\src\\Week_3_Task_2\\sample.txt";
        System.out.println();

        try (FileReader fr = new FileReader(fileName)) { // sample.txt is placed in root directory of the project folder
            int ch;

            while ((ch = fr.read()) != -1) { // read() returns ASCII decimal value which is later on is type cast into character
                System.out.print((char) ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//        fr.close() -> No requirement as try...catch block automatically closes the FileReader resources
//        This way of automatic resources closing is called try-with-resources
    }
}
