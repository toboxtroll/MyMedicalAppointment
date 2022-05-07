package com.mymedicalappointment.data;

import com.mymedicalappointment.model.Login;
import com.mymedicalappointment.model.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Locale;

public class UserDAO {
    JdbcTemplate jdbcTemplate = ConecctionPostgres.getJdbcTemplate();

    public Integer addUser(Patient patient) {
        KeyHolder key = new GeneratedKeyHolder();
        jdbcTemplate.update(
        connection -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO public.user (username, useraddress, userphonenumber, userdate) VALUES (?, ?, ?, CURRENT_DATE)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getAddress());
            ps.setInt(3, patient.getPhoneNumber());
            return ps;
        }, key);

        System.out.println("keyholder " + key.getKeys().get("userid"));
        return Integer.parseInt(String.valueOf(key.getKeys().get("userid")));
    }

    public Integer addLogin(Login login){
        Integer c = jdbcTemplate.update("INSERT INTO public.login (userid, logiemail, logipassword) VALUES (?, ?, ?)", login.getId(), login.getEmail().toLowerCase(), login.getPassword());
        System.out.println("total rows " + c);
        return c;
    }

    public int countEmailsLogin(String email){
        return jdbcTemplate.queryForObject("SELECT count (userid) FROM public.login WHERE logiemail = ?", Integer.class, new Object [] {email});
    }
}
