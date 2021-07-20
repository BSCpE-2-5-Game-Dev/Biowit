package com.example.biowit;

public class UserHelper {

    String fullname, cpnum,  email, password;

    public UserHelper() {
    }

    public UserHelper(String fullname, String cpnum, String email, String password) {
        this.fullname = fullname;
        this.cpnum = cpnum;
        this.email = email;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCpnum() {
        return cpnum;
    }

    public void setCpnum(String cpnum) {
        this.cpnum = cpnum;
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
}
