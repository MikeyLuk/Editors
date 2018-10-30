package com.andymitchell.divedb.logic;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import java.util.Set;

public class User {
    private int id;
    @Email(message = "*Please provide a valid Email")
    private String email;
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    private String password;
    private String name;
    private String lastName;
    private int active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
