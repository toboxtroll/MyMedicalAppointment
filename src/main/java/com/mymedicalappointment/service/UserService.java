package com.mymedicalappointment.service;

import com.mymedicalappointment.data.UserDAO;
import com.mymedicalappointment.model.Login;
import com.mymedicalappointment.model.Patient;
import java.util.Scanner;

public class UserService {
    static String response;
    static Patient user;
    static UserDAO userDAO = new UserDAO();
    private static Scanner sc = new Scanner(System.in);
    private static int numberRecord = 0;


    public static long registerUser(int typeRegister) {
        String typeUser = (typeRegister == 1) ? "Doctor" : "Patient";
        System.out.println("Register " + typeUser);

//        user = new Patient(null, null);
        user.setName(getResponseScanner("Name"));
        user.setAddress(getResponseScanner("Address"));
        user.setPhoneNumber(getResponseScanner("Phone Number"));
        user.setBirthday(getResponseScanner("Date Birthday"));
        user.setBlood(getResponseScanner("Type Blood"));
        user.setHeight(Float.parseFloat(getResponseScanner("Height")));
        user.setWeight(Float.parseFloat(getResponseScanner("Weight")));
        
        if (userDAO.addUser(user) > 0) {

        }

        if (registerDataLogin(userDAO.addUser(user)) > 0){
            numberRecord = registerDataLogin(userDAO.addPatient(user));
        }
        return numberRecord;
    }

    private static String getResponseScanner(String nameOption){
        System.out.println("Enter "+ nameOption +"::");
        return response = sc.nextLine();
    }

    public static int registerDataLogin(int idUser){
        Login login = new Login();
        String email;
        int countEmails;

        do {
            email = getResponseScanner("Email");
            countEmails = userDAO.countEmailsLogin(email);

            if (countEmails == 0){
                login.setEmail(email);
            } else{
                System.out.println("Email duplicate, please enter other");
            }

        } while (countEmails > 0);

        login.setPassword(getResponseScanner("Password"));
        login.setId(idUser);

        return userDAO.addLogin(login);
    }
}
