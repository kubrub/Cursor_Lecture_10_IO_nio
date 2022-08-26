package com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Task5 {
    public static final Logger LOGGER = LogManager.getLogger(Task5.class);

    public static void main(String[] args) {
        User user = new User("alex", 10, new Credentials("alex", "sda"));
        String file = "task5.txt";
        LOGGER.info("Our user is - " + user);
        LOGGER.info("serialize");
        serialize(user, file);
        User userFromFile = deserialize(file);
        LOGGER.info("User taken from file - " + userFromFile);
    }

    public static void serialize(User user, String fileToWrite) {
        try (OutputStream outputStream = new FileOutputStream(fileToWrite);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(user);
            LOGGER.info("Write user to file");
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    public static User deserialize(String fileToRead) {
        try (InputStream inputStream = new FileInputStream(fileToRead);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);) {
            User user = (User) objectInputStream.readObject();
            LOGGER.info(user.toString());
            LOGGER.info(user.getCredentials());
            return user;

        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(e);
        }
        return null;
    }
}
