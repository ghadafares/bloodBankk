package com.example.bloodbank.register;

public class Donor {

    String name , phone , location , bloodType ;

    public Donor() {
    }

    public Donor(String name, String phone, String location, String bloodType) {
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.bloodType = bloodType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
