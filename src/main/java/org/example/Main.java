package org.example;

import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        final Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        try {
            FileHandler java11Features = new FileHandler();
            String file = "src/main/resources/Input.txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            java11Features.readFileBuffer(bufferedReader);
            java11Features.writeFileBuffer();
        } catch (Exception e) {
            log.info("Exception occurred due to : " + e.getMessage());
        }
    }
}