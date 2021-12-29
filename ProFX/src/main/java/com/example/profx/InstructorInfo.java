package com.example.profx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InstructorInfo {
    private StringProperty InstName =new SimpleStringProperty(this,"Name","") ;
    private StringProperty InstDept= new SimpleStringProperty(this,"depart","");
    private StringProperty InstMail=new SimpleStringProperty(this,"email","") ;
    private StringProperty InstPhone=new SimpleStringProperty(this,"phone","");
    private StringProperty Address = new SimpleStringProperty(this,"address","");
    private StringProperty gender =new SimpleStringProperty(this,"gender","") ;

    public String getInstName() {
        return InstName.get();
    }

    public StringProperty instNameProperty() {
        return InstName;
    }

    public void setInstName(String instName) {
        this.InstName.set(instName);
    }
    public String getInstDept() {
        return InstDept.get();
    }

    public StringProperty instDeptProperty() {
        return InstDept;
    }

    public void setInstDept(String instDept) {
        this.InstDept.set(instDept);
    }

    public String getInstMail() {
        return InstMail.get();
    }

    public StringProperty instMailProperty() {
        return InstMail;
    }

    public void setInstMail(String instMail) {
        this.InstMail.set(instMail);
    }

    public String getInstPhone() {
        return InstPhone.get();
    }

    public StringProperty instPhoneProperty() {
        return InstPhone;
    }

    public void setInstPhone(String instPhone) {
        this.InstPhone.set(instPhone);
    }

    public String getAddress() {
        return Address.get();
    }

    public StringProperty addressProperty() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address.set(address);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }
}
