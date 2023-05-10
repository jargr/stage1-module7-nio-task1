package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try (Stream<String> lines = Files.lines(file.toPath())) {
            lines.forEach(line -> {
                String[] keyValue = line.split(": ");

                switch (keyValue[0]) {
                    case "Name":
                        profile.setName(keyValue[1]);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(keyValue[1]));
                        break;
                    case "Email":
                        profile.setEmail(keyValue[1]);
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(keyValue[1]));
                        break;
                    default:
                        break;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;


    }
}
