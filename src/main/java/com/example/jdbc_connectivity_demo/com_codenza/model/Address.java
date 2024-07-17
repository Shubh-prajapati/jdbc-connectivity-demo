package com.example.jdbc_connectivity_demo.com_codenza.model;

public class Address {
    private   int  addressId;

    private String city;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressID) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address() {
    }

    public Address(int addressID, String city) {
        this.addressId = addressID;
        this.city = city;
    }
}
