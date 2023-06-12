package com.fileProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileProcessor {
    private static final String INPUT_DIRECTORY = "/app/in";
    private static final String OUTPUT_DIRECTORY = "/app/out";

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            processInputFiles();
            Thread.sleep(5000);
        }
    }

    private static void processInputFiles() {
        try {
            File inputDirectory = new File(INPUT_DIRECTORY);
            File[] inputFiles = inputDirectory.listFiles();

            if (inputFiles != null) {
                for (File inputFile : inputFiles) {
                    if (inputFile.isFile()) {
                        if (inputFile.getName().equals("InstrumentDetails.csv")) {
                            processInstrumentDetailsFile(inputFile);
                        } else if (inputFile.getName().equals("PositionDetails.csv")) {
                            processPositionDetailsFile(inputFile);
                        }
                        moveProcessedFile(inputFile);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processInstrumentDetailsFile(File inputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        // Skip the header line
        String line = reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] columns = line.split(",");
            String id = columns[0];
            String name = columns[1];
            String isin = columns[2];
            double unitPrice = Double.parseDouble(columns[3]);

            // Process the data as needed
            // For example, you can store the information in a data structure or perform calculations
        }

        reader.close();
    }

    private static void processPositionDetailsFile(File inputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        // Skip the header line
        String line = reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] columns = line.split(",");
            String id = columns[0];
            String instrumentId = columns[1];
            int quantity = Integer.parseInt(columns[2]);

            // Process the data as needed
            // For example, you can store the information in a data structure or perform calculations
        }

        reader.close();
    }

    private static void generatePositionReport() throws IOException {
        // Generate the PositionReport.csv file
        File outputFile = new File(OUTPUT_DIRECTORY, "PositionReport.csv");
        FileWriter writer = new FileWriter(outputFile);

        // Write the column headers
        writer.write("ID,PositionID,ISIN,Quantity,TotalPrice\n");

        // Process the data and write to the file
        // You can retrieve the necessary information from the data structure or perform calculations
        String id = "";
        String positionId = "";
        String isin = "";
        int quantity = 0;
        double totalPrice = 0.0;

        writer.write(id + "," + positionId + "," + isin + "," + quantity + "," + totalPrice + "\n");

        writer.close();
    }

    private static void moveProcessedFile(File inputFile) throws IOException {
        Path inputPath = inputFile.toPath();
        Path outputPath = Paths.get(OUTPUT_DIRECTORY + File.separator + inputFile.getName());
        Files.move(inputPath, outputPath, StandardCopyOption.REPLACE_EXISTING);
    }
}


