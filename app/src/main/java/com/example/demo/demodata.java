package com.example.demo;

import org.json.JSONObject;

import java.io.Serializable;

public class demodata implements Serializable {


    public String User  ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name  ;
    public String Address;
    public String Email;
    public String mobile;
    JSONObject amodel;

    public JSONObject getAmodel() {
        return amodel;
    }

    public void setAmodel(JSONObject amodel) {
        this.amodel = amodel;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
