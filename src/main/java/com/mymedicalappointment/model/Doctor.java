package com.mymedicalappointment.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public Doctor(String name, String email){
        super(name, email);
    }
    public void showName(){
        System.out.println(super.getName());
    }

    public void addAvailableAppointment(String date, String time){
        availableAppointments.add(new AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointment(){
        return availableAppointments;
    }
    
    @Override
    public String getData() {
        String availableAppointment = null;
        for (AvailableAppointment aA: getAvailableAppointment()) {
            availableAppointment += "\nTime: " + aA.getTime() + " Date: " + aA.getDate();
        }
        return super.getData() + "\n Speciality: " + speciality + "\nAvailable Appointment: " + availableAppointment;
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado Hospital: Cruz Verde");
        System.out.println("Departamento: Pediatría");
    }

    public static class AvailableAppointment{
        int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate() {
            return format.format(date);
        }
        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
