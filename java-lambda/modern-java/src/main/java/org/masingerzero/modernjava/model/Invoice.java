package org.masingerzero.modernjava.model;

public class Invoice {
    private Integer itemNumber;
    private String ItemName;
    private Integer quantity;
    private Double price;
    private Double totalCost;

    public Invoice(Integer itemNumber, String name, Integer quantity, Double price, Double totalCost) {
        this.itemNumber = itemNumber;
        this.ItemName = name;
        this.quantity = quantity;
        this.price = price;
        this.totalCost = totalCost;
    }

    public boolean getBoolean() {
        return true;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "itemNumber=" + itemNumber +
                ", name='" + ItemName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", totalCost=" + totalCost +
                "}" + "\r\n";
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        this.ItemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
