package com.example.bai_2.service;

public class DictionaryService {
    public String search(String word) {
        String dictionary[][] = {
                {"hello", "xin chào"},
                {"bye", "tạm biệt"},
                {"car", "xe hơi"},
                {"technology", "công nghê"},
                {"information", "thông tin"}
        };
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i][0].equals(word)) {
                return dictionary[i][1];
            }
        }
        return null;
    }
}