package edu.ti.filesandstreams.structured;
//Write a program that reads a file and counts the number of lines and words
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class InfoReader {
    public static void main(String[] args) {
        String resourceFolder = "src/main/resources";
        String fileName = resourceFolder + "/" + "blabla.txt";
        String rawFileName = "blabla.txt";
        Scanner inputStream = null;

        int totalLines = 0;
        int totalWords = 0;
        try {
            File file = new File(fileName);

            inputStream = new Scanner(file);



            String line = inputStream.nextLine();

            while (inputStream.hasNextLine()) {
                line = inputStream.nextLine();
                totalLines += 1;
                String[] dataArray = line.split(" ");
                totalWords += dataArray.length;
            }
            totalLines += 1;

        System.out.printf("Total words in " + rawFileName + " is " + totalWords + " \n" + " and total lines is " + totalLines);

        } catch (IOException e) {
            System.out.println("Problem with input from file " + fileName + ": " + e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}