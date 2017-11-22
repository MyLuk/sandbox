package chap14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileWrirterAndReader {

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("MyFile.txt");
            writer.write("First/first2\nSecond/second2");
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            File myFile = new File("MyFile.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            String[] result = null;

            while ((line=reader.readLine())!=null) {
                result = line.split("/");
                System.out.println(line);
                for (String word : result)
                    System.out.println(word);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
