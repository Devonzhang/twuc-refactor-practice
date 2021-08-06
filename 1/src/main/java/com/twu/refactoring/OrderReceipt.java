package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();
        double taxRate = .10d;
        double totalPrice = order.getGoodItemList().stream().mapToDouble(GoodItem::totalPrice).sum();
        double totalSalesTax = totalPrice * taxRate;
        double totalAmount = totalPrice + totalSalesTax;
        receipt.append("======Printing Orders======\n" + order.getName() + order.getAddress());
        order.getGoodItemList().forEach(goodItem -> receipt.append(goodItem.toString()));
        receipt.append("Sales Tax").append('\t').append(totalSalesTax);
        receipt.append("Total Amount").append('\t').append(totalAmount);
        return receipt.toString();
    }
}