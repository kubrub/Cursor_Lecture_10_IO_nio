package com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class task2 {
    public static final Logger LOGGER = LogManager.getLogger(task2.class);
    public static void main(String[] args) {
        LOGGER.info("~~~~~~~~~~readFromPDF~~~~~~~~~~");
        readFromPDF();
        LOGGER.info("~~~~~~~~~~readFromPDFWithBuffer~~~~~~~~~~");
        readFromPDFWithBuffer();
    }
    public static void readFromPDF() {
        long startTime = System.currentTimeMillis();
        try (InputStream inputStream = new FileInputStream("SystemRequirements.pdf");){
            int data = inputStream.read();
            while (data != -1) {
                data = inputStream.read();
            }
        }catch (Exception e){
            LOGGER.error(e);
        }
        finally {
            long endTime = System.currentTimeMillis();
            long seconds = (endTime - startTime) / 1000;
            LOGGER.info("file of 1MB reads for seconds: " + seconds);
        }
    }

    public static void readFromPDFWithBuffer() {
        long startTime = System.currentTimeMillis();
        try(InputStream inputStream = new FileInputStream("SystemRequirements.pdf");) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
            while (true) {
                byte b = dataInputStream.readByte();
            }
        }catch (Exception e){
            LOGGER.error(e);
        }
        finally {
            long endTime = System.currentTimeMillis();
            long seconds = (endTime - startTime) / 1000;
            LOGGER.info("file of 1MB reads for seconds: " + seconds);
        }
    }
}
