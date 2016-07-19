package com.java.kvashchuk;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HashMapThreadsMain {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<String, Integer>();

        HashMapIn1 hashMapIn1 = new HashMapIn1(words, "e:\\t1.txt");
        HashMapIn2 hashMapIn2 = new HashMapIn2(words, "e:\\t2.txt");
        HashMapIn3 hashMapIn3 = new HashMapIn3(words, "e:\\t3.txt");
        hashMapIn1.start();
        hashMapIn2.start();
        hashMapIn3.start();

        HashMapToOut hashMapToOut = new HashMapToOut(words, "e:\\out12.txt");
        try {
            hashMapToOut.toFileFromHashMap();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String key : words.keySet()) {
            Integer value = words.get(key);
            System.out.println(key + " - " + value);
        }
    }
}