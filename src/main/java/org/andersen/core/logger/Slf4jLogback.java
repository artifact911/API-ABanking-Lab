package org.andersen.core.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Slf4jLogback {
    private static final Logger logger = LoggerFactory.getLogger(Slf4jLogback.class);

    private static final String FILENAME = "/file/does/not/exist";

    // test Logger
    public static void main(String[] args) {

        logger.info("Just a log message");
        logger.debug("Message for debug level.");
        logger.warn("Warning");

        try {
            Files.readAllBytes(Paths.get(FILENAME));
        } catch (IOException e) {
            logger.error("Failed to read file {}", FILENAME, e);
        }
    }
}
