package com.demo.mock.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestUtils.class);

    private static final int BUFF_SIZE = 2048;
    private static final String DEFAULT_ENCODING = "utf-8";

    /**
     * Function to get the string from file
     * 
     * @param filePath
     * @return String of the file
     */
    public static String getStringFromFile(String filePath) {
        String input = "";
        try {
            input = readFile(filePath);
        } catch (IOException e) {
            new AssertionError("Exception occured during conversion", e);
        }
        return input;
    }

    /**
     * Function to read the file from the resources folder
     * 
     * @param filename
     * @return String from the filename
     * @throws IOException
     */
    private static String readFile(String filename) throws IOException {

        StringBuffer content = new StringBuffer();

        FileInputStream fis = new FileInputStream(TestUtils.class.getResource(filename).getPath());

        try {
            byte[] buffer = new byte[BUFF_SIZE];
            int bytesRead = 0;
            while ((bytesRead = fis.read(buffer)) != -1) {
                content.append(new String(buffer, 0, bytesRead, DEFAULT_ENCODING));
            }
        } finally {
            if (fis != null) {
                fileSafeClose(fis);
            }
        }
        return content.toString();

    }

    private static void fileSafeClose(FileInputStream fis) {
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException ex) {
                LOGGER.error("There was an exception during your operation", ex);
            }
        }
    }
}
