package com.app.entity;

public class ShipmentInfo {
    private double weight;
    private String shippingMethod;

    public ShipmentInfo(double weight, String shippingMethod) {
        this.weight = weight;
        this.shippingMethod = shippingMethod;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
