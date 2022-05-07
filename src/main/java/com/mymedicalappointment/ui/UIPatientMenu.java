package com.mymedicalappointment.ui;

import com.mymedicalappointment.model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    public static void showPatientMenu(){
        int response;

        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome " + UIMenu.patientlogged.getName());
            System.out.println("1. Book an Appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while (response != 0);
    }

    private static void showBookAppointmentMenu(){
        System.out.println(":: Book an Appointment");
        System.out.println(":: Select date");

        Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
        int index = 0;
        for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
            ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointment();
            Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
            for (int j = 0; j < availableAppointments.size(); j++) {
                index++;
                System.out.println(index + ". " + availableAppointments.get(j).getDate());
                doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                doctors.put(Integer.valueOf(index), doctorAppointments);
            }
        }

        Scanner sc = new Scanner(System.in);
        int responseDateSelected = Integer.valueOf(sc.nextLine());

        Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
        Integer indexDate = 0;
        Doctor doctorSelected = new Doctor("", "");

        for (Map.Entry<Integer, Doctor> doctor: doctorAvailableSelected.entrySet()) {
            indexDate = doctor.getKey();
            doctorSelected = doctor.getValue();
        }

        System.out.println(doctorSelected.getName() + " Date: " + doctorSelected.getAvailableAppointment().get(indexDate).getDate() + " Time: " + doctorSelected.getAvailableAppointment().get(indexDate).getTime());
        System.out.println("Confirm your appointment: \n1. Yes\n2. Change Date");
        int response = Integer.valueOf(sc.nextLine());

        if (response == 1){
            UIMenu.patientlogged.addAppointmentDoctors(doctorSelected, doctorSelected.getAvailableAppointment().get(indexDate).getDate(null),
                    doctorSelected.getAvailableAppointment().get(indexDate).getTime());
            showPatientMenu();
        }
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println(":: My Appointments");
            if (UIMenu.patientlogged.getAppointmentDoctors().size() == 0){
                System.out.println("Don't have appointments");
                break;
            }

            for (int i = 0; i < UIMenu.patientlogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(i + ". Doctor: " + UIMenu.patientlogged.getAppointmentDoctors().get(i).getDoctor().getName()
                        + "\nDate: " + UIMenu.patientlogged.getAppointmentDoctors().get(i).getDate()
                        + " Time: " + UIMenu.patientlogged.getAppointmentDoctors().get(i).getTime());
            }

            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
        } while (response != 0);
    }
}
