package com.mymedicalappointment.service;

import com.mymedicalappointment.model.Patient;

import java.util.Scanner;

public class RegisterUser {
    static String response;
    static Patient user;
    private static Scanner sc = new Scanner(System.in);


    public static boolean RegisterUser(int typeRegister) {
        String typeUser = (typeRegister == 1) ? "Doctor" : "Patient";
        System.out.println("Register " + typeUser);

        user = new Patient(null, null);
        user.setName(getResponseScanner("Name"));
        user.setEmail(getResponseScanner("Email"));
        user.setAddress(getResponseScanner("Address"));
        user.setPhoneNumber(getResponseScanner("Phone Number"));
        user.setDate(getResponseScanner("Date"));
        return false;
    }

    public static String getResponseScanner(String nameOption){
        System.out.println("Enter "+ nameOption +"::");
        return response = sc.nextLine();
    }
}
