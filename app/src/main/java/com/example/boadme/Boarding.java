package com.example.boadme;

public class Boarding {

    private int id;
    private String ownerName,phone,price,location,details2,address,email;

    public Boarding(){

    }

    public Boarding(int id, String ownerName, String phone, String price, String location, String details2, String address, String email) {
        this.id = id;
        this.ownerName = ownerName;
        this.phone = phone;
        this.price = price;
        this.location = location;
        this.details2 = details2;
        this.address = address;
        this.email = email;
    }

    public Boarding(String ownerName, String phone, String price, String location, String details2, String address, String email) {
        this.ownerName = ownerName;
        this.phone = phone;
        this.price = price;
        this.location = location;
        this.details2 = details2;
        this.address = address;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails2() {
        return details2;
    }

    public void setDetails2(String details2) {
        this.details2 = details2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
