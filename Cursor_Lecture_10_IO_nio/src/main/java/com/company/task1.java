package com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class task1 {
    public static final Logger LOGGER = LogManager.getLogger(task1.class);
    public static void main(String[] args) {
        LOGGER.info("~~~~~~~~~~writeToFileByteStream~~~~~~~~~~");
        writeToFileByteStream();
        LOGGER.info("~~~~~~~~~~readFromFileByteStream~~~~~~~~~~");
        readFromFileByteStream();
        LOGGER.info("~~~~~~~~~~writeToFileCharacterStream~~~~~~~~~~");
        writeToFileCharacterStream();
        LOGGER.info("~~~~~~~~~~readFromFileCharacterStream~~~~~~~~~~");
        readFromFileCharacterStream();
    }
    public static void writeToFileByteStream() {
        try(OutputStream outputStream = new FileOutputStream("test.txt", true);) {
            String text = "hello)";
            outputStream.write(text.getBytes());
            LOGGER.info("Write in file - " + text + " - using Byte Stream");
        }catch (Exception e){
            LOGGER.error(e);
        }
    }

    public static void readFromFileByteStream() {
        try (InputStream inputStream = new FileInputStream("test.txt");){
            byte[] byteArray = inputStream.readAllBytes();
           String textInput = new String(byteArray);
            LOGGER.info("From file we get: " + textInput + " - using Byte Stream");
        }catch (Exception e){
            LOGGER.error(e);
        }
    }

    public static void writeToFileCharacterStream(){
        try(Writer writer = new FileWriter("test2.txt", true)) {
            String s = "hello world";
            writer.write(s);
            LOGGER.info("Write in file - " + s + " - using Character Stream");
        } catch (Exception e){
            LOGGER.error(e);
        }
    }

    public static void readFromFileCharacterStream(){
        File file = new File("test2.txt");
        try (FileReader input = new FileReader(file)){
            char[] chars = new char[(int) file.length()];
            input.read(chars);
            String s = new String(chars);
            LOGGER.info("From file we get: " + s + " - using Character Stream");
        }catch (Exception e){
            LOGGER.error(e);
        }
    }
}
