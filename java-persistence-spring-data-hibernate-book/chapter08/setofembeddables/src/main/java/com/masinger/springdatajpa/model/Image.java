package com.masinger.springdatajpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Objects;

@Embeddable
public class Image {
    @Column(nullable = false)
    private String filename;
    private int width;
    private int height;

    @org.hibernate.annotations.Parent
    private Item item;

    protected Image() {
    }

    public Image(String filename, int width, int height) {
        this.filename = filename;
        this.width = width;
        this.height = height;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    protected Item getItem() {
        return item;
    }

    protected void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return width == image.width && height == image.height && Objects.equals(filename, image.filename) && Objects.equals(item, image.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, width, height, item);
    }

    @Override
    public String toString() {
        return "Image{" +
                "filename='" + filename + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", item=" + item +
                '}';
    }
}
