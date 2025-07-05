package com.app.entity;

public class Product {
    private int id;
    private String name;
    private double price;
    private int stockQuantity;
    private ShipmentInfo shipmentInfo;
    private ProductDates productDates;

    public Product(int id, String name, double price, int stockQuantity, ShipmentInfo shipmentInfo, ProductDates productDates) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.shipmentInfo = shipmentInfo;
        this.productDates = productDates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public ShipmentInfo getShipmentInfo() {
        return shipmentInfo;
    }

    public void setShipmentInfo(ShipmentInfo shipmentInfo) {
        this.shipmentInfo = shipmentInfo;
    }

    public ProductDates getProductDates() {
        return productDates;
    }

    public void setProductDates(ProductDates productDates) {
        this.productDates = productDates;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product product)) return false;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
