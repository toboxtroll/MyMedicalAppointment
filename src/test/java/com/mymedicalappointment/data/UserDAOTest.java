package com.mymedicalappointment.data;
import com.mymedicalappointment.data.UserDAO;
import com.mymedicalappointment.model.Login;
import com.mymedicalappointment.model.Patient;
import org.junit.Test;

import static com.mymedicalappointment.service.UserService.registerUser;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class UserDAOTest {

    @Test
    public void return_id_after_insert_user() {
        Patient user;
        UserDAO userDAO = new UserDAO();

        user = new Patient(null, null);
        user.setName("Tobias Sandoval");
        user.setAddress("Cll 4 # 12-89");
        user.setPhoneNumber("1234567890");
        Integer idUser = userDAO.addUser(user);

        assertThat(idUser, is(notNullValue()));

        Login login = new Login();
        login.setId(idUser);
        login.setEmail("tobiazz012@mail.com");
        login.setPassword("Password");

        assertThat(1, is(userDAO.addLogin(login)));
    }

    @Test
    public void name() {
        UserDAO userDAO = new UserDAO();
        assertThat(3, is(userDAO.countEmailsLogin("tobiazz012@mail.com")));
    }
}