package com.masinger.springdatajpa;

import com.masinger.springdatajpa.model.Image;

import java.util.HashMap;

public class SandBox {

    public static void main(String[] args) {
        HashMap<String, Image> stringImageHashMap = new HashMap<>();
        stringImageHashMap.put("one", new Image("title","filename", 10,10));
        stringImageHashMap.put("one", new Image("title1","filename2", 10,10));

        System.out.println(stringImageHashMap);

    }
}
