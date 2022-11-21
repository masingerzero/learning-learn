package com.masinger.springdatajpa;

import com.masinger.springdatajpa.model.Image;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SandBox {
    public static void main(String[] args) {
        List<Image> images = List.of(new Image("file", 10, 30),
                new Image("file", 10, 30),
                new Image("file", 10, 30),
                new Image("file", 10, 30));
        images.forEach(image -> System.out.println(image.hashCode()));
       Set<Image> imageSet = new HashSet<>(images);
        System.out.println(imageSet.size());

        System.out.println(images.size());




    }
}
