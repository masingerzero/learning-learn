package com.masinger.springdatajpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Image {
    @Column(nullable = true)
    private String title;
    @Column(nullable = false)
    private String filename;
    private int width;
    private int eight;


    protected Image() {
    }

    public Image(String title, String filename, int width, int eight) {
        this.title = title;
        this.filename = filename;
        this.width = width;
        this.eight = eight;
    }

    public String getTitle() {
        return title;
    }

    public String getFilename() {
        return filename;
    }

    public int getWidth() {
        return width;
    }

    public int getEight() {
        return eight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return width == image.width && eight == image.eight && Objects.equals(title, image.title) && filename.equals(image.filename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, filename, width, eight);
    }

    @Override
    public String toString() {
        return "Image{" +
                "title='" + title + '\'' +
                ", filename='" + filename + '\'' +
                ", width=" + width +
                ", eight=" + eight +
                '}';
    }


}
