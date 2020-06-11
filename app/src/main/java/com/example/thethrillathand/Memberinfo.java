package com.example.thethrillathand;

import android.widget.EditText;

public class Memberinfo {
    private String name;
    private String phoneNumber;
    private String birthDay;
    private String address;

    public Memberinfo(String name, String phoneNumber, String birthDay, String address){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.address = address;
    }

    public String getName(){
        return this.name;
    }
    public void getName(String name){
        this.name = name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void getPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDay(){
        return this.birthDay;
    }
    public void getBirthDay(String birthDay){
        this.birthDay = birthDay;
    }

    public String getAddress(){
        return this.address;
    }
    public void getAddress(String address){
        this.address = address;
    }

}
