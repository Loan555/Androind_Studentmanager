package com.loan555.qlsinhvien1;

import java.util.Scanner;

public class Student {
    private String name;
    private int birthYear;
    private String phoneNumber;
    private String specialized;
    private Boolean university;

    public Student() {
        this.name = "";
        this.birthYear = 2000;
        this.phoneNumber = "";
        this.specialized = "";
        this.university = true;
    }

    public Student(String name, int birth, String phone, String spe, Boolean uni) {
        this.name = name;
        this.birthYear = birth;
        this.phoneNumber = phone;
        this.specialized = spe;
        this.university = uni;
    }

    //-------------------------get set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth() {
        return birthYear;
    }

    public void setBirth(int birth) {
        this.birthYear = birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    public Boolean getUniversity() {
        return university;
    }

    public void setUniversity(Boolean university) {
        this.university = university;
    }

    //    ------------------------------------method
    @Override
    public String toString() {
        String result = "";
        result = this.getName() + "/" + this.getBirth() + "/" + this.getPhoneNumber() + "/" + this.getSpecialized();
        if (this.getUniversity()) {
            result = result + "/University.";
        } else result = result + "/College.";
        return result;
    }
}
