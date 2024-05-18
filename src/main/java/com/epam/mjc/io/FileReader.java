package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    Profile profile = new Profile();

    public Profile getDataFromFile(File file) {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                parseString(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return profile;
    }

    public void parseString(String line) {
        String[] elements = line.split(" ");
        switch (elements[0]) {
            case "Name:":
                profile.setName(elements[1]);
                break;
            case "Age:":
                profile.setAge(Integer.valueOf(elements[1]));
                break;
            case "Email:":
                profile.setEmail(elements[1]);
                break;
            case "Phone:":
                profile.setPhone(Long.valueOf(elements[1]));
                break;
        }
    }
}
