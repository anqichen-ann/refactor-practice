package com.twu.refactoring;

import java.util.List;

public class Order {
    String username;
    String address;
    List<LineItem> lineItems;

    public Order(String name, String address, List<LineItem> lineItems) {
        this.username = name;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return username;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double totalSalesTax(double tax) {
        double totalSalesTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            double salesTax = lineItem.totalAmount() * tax;
            totalSalesTax += salesTax;
        }
        return totalSalesTax;
    }

    public double totalSales(double tax) {
        double totalSales = 0d;
        for (LineItem lineItem : getLineItems()) {
            totalSales += lineItem.totalAmount();
        }
        totalSales += totalSalesTax(tax);
        return totalSales;
    }
}
