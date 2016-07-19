package com.java.kvashchuk;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class HashMapToOut {
    private Map<String, Integer> words;
    private String path;

    public HashMapToOut(Map<String, Integer> words, String path) {
        this.words = words;
        this.path = path;
    }

    public void toFileFromHashMap() throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        for (String key : words.keySet()) {
            Integer value = words.get(key);
            writer.write(key + " - " + value);
            writer.newLine();
            System.out.println(key + " - " + value);
        }
        writer.close();
    }
}
