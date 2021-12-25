package com.example.instructornewmodule;

public class Instructor {
    private String InstName , InstDept, InstMail , InstPhone , Address ;
    Instructor(String InstName, String InstDept,String InstMail,String InstPhone, String Address){
        this.InstName = InstName ;
        this.InstDept = InstDept ;
        this.InstMail = InstMail ;
        this.InstPhone = InstPhone ;
        this.Address = Address ;
    }
    public void setInstName(String instName) {
        InstName = instName;
    }

    public String getInstName() {
        return InstName;
    }

    public void setInstDept(String instDept) {
        InstDept = instDept;
    }

    public String getInstDept() {
        return InstDept;
    }

    public void setInstMail(String instMail) {
        InstMail = instMail;
    }

    public String getInstMail() {
        return InstMail;
    }

    public void setInstPhone(String instPhone) {
        InstPhone = instPhone;
    }

    public String getInstPhone() {
        return InstPhone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
