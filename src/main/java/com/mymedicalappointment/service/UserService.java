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


    public static long registerUser(int typeRegister) {
        String typeUser = (typeRegister == 1) ? "Doctor" : "Patient";
        System.out.println("Register " + typeUser);

//        user = new Patient(null, null);
        user.setName(getResponseScanner("Name"));
        user.setAddress(getResponseScanner("Address"));
        user.setPhoneNumber(getResponseScanner("Phone Number"));

        registerDataLogin(userDAO.addUser(user));
        return 4;
    }

    private static String getResponseScanner(String nameOption){
        System.out.println("Enter "+ nameOption +"::");
        return response = sc.nextLine();
    }

    public static void registerDataLogin(int idUser){
        Login login = new Login();
        String email;
        int countEmails;

        do {
            email = getResponseScanner("Email");
            countEmails = userDAO.countEmailsLogin(email);

            if (countEmails == 0){
                login.setEmail(email);
            }

        } while (countEmails > 0);

        login.setPassword(getResponseScanner("Password"));
        login.setId(idUser);

        System.out.println("Cantidad de rows " + userDAO.addLogin(login));
    }
}
