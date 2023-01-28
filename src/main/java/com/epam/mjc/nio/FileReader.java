package com.epam.mjc.nio;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;


public class FileReader {

    public Profile getDataFromFile(File file) {

        Map<String, String> map = null;
        try {
            String data = Files.readString(Paths.get(file.getPath()));
            map = data.lines().map(s -> s.split(":"))
                    .collect(Collectors.toMap(a -> a[0].trim(), a -> a[1].trim()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert map != null;
        return new Profile(map.get("Name"), Integer.parseInt(map.get("Age")), map.get("Email"),
                Long.parseLong(map.get("Phone")));
    }


}
