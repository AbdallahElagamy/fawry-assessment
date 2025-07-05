package com.app.entity;

import java.util.Date;

public class ProductDates {
    private Date manufactureDate;
    private Date expiryDate;

    public ProductDates(Date manufactureDate, Date expiryDate) {
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
