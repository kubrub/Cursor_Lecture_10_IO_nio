package com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class task3 {
    public static final Logger LOGGER = LogManager.getLogger(task3.class);
    private static String inputDataString;

    public static void main(String[] args) {
        //Write a program that reads a Java source-code file (you provide the file
        //name on the command line) and displays to console all the comments in file.
        readFile(args[0]);

        //displays to console all the comments in
        //file.
        stringInput(inputDataString);
    }
    public static void readFile(String fileName){
        File file = new File(fileName);
        try (FileReader input = new FileReader(file)){
            char[] chars = new char[(int) file.length()];
            input.read(chars);
            inputDataString = new String(chars);
            LOGGER.info("From file we get: " + inputDataString);
        }catch (Exception e){
            LOGGER.error(e);
        }
    }

    public static void stringInput(String text){
        String[] strings = text.split("\n");
        for (String string:strings) {
            if (string.startsWith("//")){
                LOGGER.info(string);
            }
        }
    }
}
