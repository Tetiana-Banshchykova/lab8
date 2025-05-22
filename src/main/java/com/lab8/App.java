package com.lab8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lab8.filesystem.FileSystemWriter;

public class App {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(App.class);

        new FileSystemWriter().writeRandomNumbersToFile("numbers.txt", 1, 100, 10);
        logger.info("Random numbers written to file.");
        new FileSystemWriter().readfile("numbers.txt");
        logger.info("Random numbers read from file.");
    }
}
