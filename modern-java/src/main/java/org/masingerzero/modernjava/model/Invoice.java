package org.masingerzero.modernjava.model;

public class Invoice {
    private Integer itemNumber;
    private String name;
    private Integer quantity;
    private Double price;
    private Double totalCost;

    public Invoice(Integer itemNumber, String name, Integer quantity, Double price, Double totalCost) {
        this.itemNumber = itemNumber;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.totalCost = totalCost;
    }



    @Override
    public String toString() {
        return "Invoice{" +
                "itemNumber=" + itemNumber +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", totalCost=" + totalCost +
                '}';
    }


}
