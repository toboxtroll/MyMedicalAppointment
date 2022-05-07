package com.mymedicalappointment.ui;

import com.mymedicalappointment.model.Doctor;
import com.mymedicalappointment.model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

import static com.mymedicalappointment.service.UserService.registerUser;

public class UIMenu {
    public static final String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorlogged;
    public static Patient patientlogged;

    public static void showLoginRegitryUser(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Select Option Desired::");

        int response;
        do {
            System.out.println("1. Login");
            System.out.println("2. Registry");
            System.out.println("0. Exit");

            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();

            switch (response) {
                case 1:
                    System.out.println("Login");
                    showMenu();
                    break;

                case 2:
                    System.out.println("Registry");
                    showMenu();
                    break;

                case 0:
                    System.out.println("Thank you for you visit");
                    break;

                default:
                    System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }

    public static void showMenu() {
        System.out.println("Select type of user::");

        int response;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Back");

            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();

            switch (response) {
                case 1:
                    response = 0;
//                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    long RegiterSuccessful = registerUser(2);
//                    authUser(2);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }

    private static void authUser(int userType){
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Nicolás Sandoval", "nicolas@mail.com"));
        doctors.add(new Doctor("Laura Vergel", "laura@mail.com"));
        doctors.add(new Doctor("Tobias Sandoval", "tobias@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Andres Becerra", "andres@mail.com"));
        patients.add(new Patient("Keila Jacome", "keila@mail.com"));
        patients.add(new Patient("Fernanda Ruedas", "fernanda@mail.com"));

        boolean emailCorrect = false;

        do {
            System.out.println("Insert your email [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();

            if (userType == 1) {
                for (Doctor d: doctors){
                    if (d.getEmail().equals(email)){
                        emailCorrect = true;
                        doctorlogged = d;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }

            if (userType == 2) {
                for (Patient p: patients) {
                    if (p.getEmail().equals(email)){
                        emailCorrect = true;
                        patientlogged = p;
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }
        }while (!emailCorrect);
    }
    static void showPatientMenu() {
        int response;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 3; i++) {
                        System.out.println(i + "." + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        } while (response != 0);
    }
}