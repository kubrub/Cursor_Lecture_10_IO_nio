package com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import java.io.File;
public class task4 {
    public static final Logger LOGGER = LogManager.getLogger(task4.class);
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input folder path: ");
        String folderName = in.nextLine();
        File folder = new File(folderName);
        File[] folders = folder.listFiles();
        if (folder.exists()){
            assert folders != null;
            for (File file : folders) {
                if (file.isDirectory()) {
                    LOGGER.info("Folder name is - " + file.getName());
                }else
                    LOGGER.info("Filename is - " + file.getName() + " and size in megabytes is: " + (file.length()/1024)/1024 + ")");
            }
        }
        else {
            LOGGER.error("File not found");
        }
    }
}
