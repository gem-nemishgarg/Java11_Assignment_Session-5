package org.example;

import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FileHandler {
    private static final Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    List<Integer> integerList = new ArrayList<>();
    Predicate<Integer> checkZeroValue = integer -> integer == 0;

    public void readFileBuffer(BufferedReader read) {
        try {
            log.info("Reading input file...");
            String line;
            while ((line = read.readLine()) != null)
                integerList.add(Integer.parseInt(line.trim()));
        } catch (Exception e) {
            log.info("Exception occurred due to : " + e.getMessage());
        }
    }

    public void writeFileBuffer() {
        try {
            //create the temporary file
            Path path = Files.createTempFile(Path.of("src/main/resources"), "Output", ".txt");
            integerList.stream()
                    .filter(Predicate.not(checkZeroValue))
                    .forEach(i -> {
                        try {
                            i = i + 5;
                            Files.write(path, String.valueOf(i).getBytes(), StandardOpenOption.APPEND);
                            Files.write(path, "\n".getBytes(), StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            log.info("Exception occurred due to : " + e.getMessage());
                        }
                    });
            log.info("Output file generated and saved in src/main/resources directory.");
        } catch (Exception e) {
            log.info("Exception occurred due to : " + e.getMessage());
        }
    }

}