package edu.ti.filesandstreams.structured;

import edu.ti.filesandstreams.dataobject.Species;

import java.io.*;
import java.util.Scanner;

public class newSpeciesFromCsv {
    public static void main(String[] args) {
        String resourceFolder = "src/main/resources";
        String fileName = resourceFolder + "/" + "file.dat";
        String csvFileName = resourceFolder + "/" + "info.csv";
        Scanner inputStream = null;
        try {
            File file = new File(csvFileName);

            inputStream = new Scanner(file);

            String line = inputStream.nextLine();
            while (inputStream.hasNextLine()) {
                line = inputStream.nextLine();
                String[] dataArray = line.split(",");

                String name = dataArray[0];
                int population = Integer.parseInt(dataArray[1]);
                double growth_rate = Double.parseDouble(dataArray[2]);
                Species[] initSpecies = {
                        new Species(name, population, growth_rate)};
                String binaryFileName = resourceFolder + "/" + "file.dat";
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(binaryFileName))) {
                    objectOutputStream.writeObject(initSpecies);
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException thrown writing to file " + binaryFileName + ":" + e.getMessage());
                } catch (IOException e) {
                    System.out.println("IOException thrown writing to file " + binaryFileName + ":" + e.getMessage());
                }

                System.out.println("Array written to file " + binaryFileName + " and file is closed.");
            }
        } catch (IOException e) {
            System.out.println("Problem with input from file " + fileName + ": " + e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
