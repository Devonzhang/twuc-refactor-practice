package com.twu.refactoring;

public class GoodItem {
    private String description;
    private double price;
    private int quantity;

    public GoodItem(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double totalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return description + "\t" + price + "\t" + quantity + "\t" + totalPrice() + "\n";
    }
}