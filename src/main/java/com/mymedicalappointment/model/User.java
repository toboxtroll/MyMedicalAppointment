package com.mymedicalappointment.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public abstract class User {
    static int id = 0;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String date;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getData(){
        return "Nombre: " + name + "\nEmail: " + email;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return Integer.valueOf(phoneNumber);
    }

    public Date getDate() {
        return Date.valueOf(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() > 10){
            System.out.println("El número telefónico debe ser máximo de 10 dígitos");
        }else if (phoneNumber.length() == 10) {
            this.phoneNumber = phoneNumber;
        }
    }

    public abstract void showDataUser();
}
