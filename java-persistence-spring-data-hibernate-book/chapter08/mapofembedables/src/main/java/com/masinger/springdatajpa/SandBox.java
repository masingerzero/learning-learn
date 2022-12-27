package com.masinger.springdatajpa;

import com.masinger.springdatajpa.model.FileName;
import com.masinger.springdatajpa.model.Image;
import com.masinger.springdatajpa.model.Item;

import java.util.HashMap;
import java.util.Map;

public class SandBox {
    public static void main(String[] args) {
        Map<FileName, Image> map = new HashMap<>();
        map.put(new FileName("A"), new Image("image1", 10,10));
        map.put(new FileName("A"), new Image("image1", 10,10));

        System.out.println((map.size()));

    }

}
