package org.masingerzero.modernjava.model;

public class Fruit {
    public String name;
    public Integer price;

    public Fruit() {

    }

    public Fruit(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public boolean isPriceGreaterThanTenAndBanana() {
        if (this.getPrice() > 10 && this.getName().equals("banana"))
            return true;
        else return false;

    }
}
