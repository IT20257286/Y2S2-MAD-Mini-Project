package com.example.carserviceapp;

public class Users {

    private String Company;
    private String Email;
    private String Phone;
    private String Password;
    private  String RePassword;

    public Users() {

    }

    public Users(String company, String email, String phone, String password, String rePassword) {
        Company = company;
        Email = email;
        Phone = phone;
        Password = password;
        RePassword = rePassword;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRePassword() {
        return RePassword;
    }

    public void setRePassword(String rePassword) {
        RePassword = rePassword;
    }
}
