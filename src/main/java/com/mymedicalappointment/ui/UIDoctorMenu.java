package com.mymedicalappointment.model.ui;

import com.mymedicalappointment.model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();
    public static void showDoctorMenu() {
        int response;

        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.doctorlogged.getName());
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Scheduled appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;

                case 2:
                    showScheduledAvailable();
                    break;

                case 0:
                    UIMenu.showMenu();
                    break;
            }
        } while (response != 0);
    }
    private static void showAddAvailableAppointmentsMenu(){
        int response;

        do {
            System.out.println("\n\n");
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select a Month");

            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }

            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4){
                int monthSelected = response;

                System.out.println(monthSelected + ". " + UIMenu.MONTHS[monthSelected - 1]);
                System.out.println("Insert the date available: [dd/mm/yyyy/]");

                String date = sc.nextLine();

                System.out.println("Your date is " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue;

                int responseTime = 0;
                String time;
                do {
                    System.out.println("Insert the time for date " + date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is " + time + "\n1. Correct \n2. Change Date");
                    responseTime = Integer.parseInt(sc.nextLine());
                }while (responseTime == 2);

                UIMenu.doctorlogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointments(UIMenu.doctorlogged);
            }else if (response == 0){
                showDoctorMenu();
            }else if (response > 3){
                System.out.println("Please select a date valid");
            }
        } while (response != 0);
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if (doctor.getAvailableAppointment().size() > 0 && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }

    private static void showScheduledAvailable(){
        System.out.println("::My Scheduled appointments \nScheduled Available ");
        if (UIMenu.doctorlogged.getAvailableAppointment().size() > 0) {
            for (Doctor.AvailableAppointment ap : UIMenu.doctorlogged.getAvailableAppointment()) {
                System.out.println("Date: " + ap.getDate() + " Time: " + ap.getTime());
            }
        }else {
            System.out.println("Don't have schedule appointments available");
        }
    }
}
