package com.java.kvashchuk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class HashMapIn1 extends Thread{
    private Map<String, Integer> words;
    private String path;

    public HashMapIn1(Map<String, Integer> words, String path) {
        this.words = words;
        this.path = path;
    }

    @Override
    public void run() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" ");
                for (String tempWord : arr) {
                    tempWord=tempWord.replace(",", " ").replace(".", " ").replace(";", " ").trim();
                    //tempWord=tempWord.replace(".", " ").trim();
                    //System.out.println("Test: "+tempWord);
                    if (words.containsKey(tempWord)) {
                        int inc = words.get(tempWord);
                        inc++;
                        words.put(tempWord, inc);
                    } else {
                        words.put(tempWord, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
