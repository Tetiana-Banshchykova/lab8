package com.lab8.filesystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;
import java.util.logging.Logger;

public class FileSystemWriter {
    Random random = new Random();
    static Logger logger = Logger.getLogger(FileSystemWriter.class.getName());

    public void writeRandomNumbersToFile(String filename, int min, int max, int count) {
        File file = new File(filename);
        try {
            if (!file.exists()) {
                logger.info("File doesn't exist " + filename);
                boolean created = file.createNewFile();
                if (created) {
                    logger.info("File created: " + filename);
                } else {
                    logger.info("File could not be created: " + filename);
                }
            }
            try (FileWriter writer = new FileWriter(file)) {
                for (int i = 0; i < count; i++) {
                    int number = random.nextInt(max - min + 1) + min;
                    writer.write(number + System.lineSeparator());
                }
            }
            logger.info("Numbers successfully written in file.");
        } catch (IOException e) {
            logger.info("Error during writting in file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            logger.info("Using: java FileWriter <filename> <min> <max> <count>");
            return;
        }
        String filename = args[0];
        int min = Integer.parseInt(args[1]);
        int max = Integer.parseInt(args[2]);
        int count = Integer.parseInt(args[3]);

        FileSystemWriter fw = new FileSystemWriter();
        fw.writeRandomNumbersToFile(filename, min, max, count);
    }

    public void readfile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                logger.info(line);
            }
        } catch (IOException e) {
            logger.info("Error reading file: " + e.getMessage());
        }
    }
}
