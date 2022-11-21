package com.masinger.springdatajpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Image {
    @Column(nullable = false)
    private String filename;
    private int width;
    private int eight;

    @org.hibernate.annotations.Parent
    private Item item;

    protected Image() {
    }

    public Image(String filename, int width, int eight) {
        this.filename = filename;
        this.width = width;
        this.eight = eight;
    }



    protected Item getItem() {
        return item;
    }

    protected void setItem(Item item) {
        this.item = item;
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
        return width == image.width && eight == image.eight && Objects.equals(filename, image.filename) && Objects.equals(item, image.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, width, eight, item);
    }

    @Override
    public String toString() {
        return "Image{" +
                "filename='" + filename + '\'' +
                ", width=" + width +
                ", eight=" + eight +
                ", item=" + item +
                '}';
    }
}
