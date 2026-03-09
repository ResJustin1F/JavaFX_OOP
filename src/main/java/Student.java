package org.example.javafx_oop;

import javafx.beans.property.SimpleStringProperty;

public class Student {
    private final SimpleStringProperty id;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty department;
    private final SimpleStringProperty major;
    private final SimpleStringProperty email;
    private final SimpleStringProperty imageURL;


public Student(String id, String firstName, String lastName, String department,
               String major, String email, String imageURL){
    this.id = new SimpleStringProperty(id);
    this.firstName = new SimpleStringProperty(firstName);
    this.lastName = new SimpleStringProperty(lastName);
    this.department = new SimpleStringProperty(department);
    this.major = new SimpleStringProperty(major);
    this.email = new SimpleStringProperty(email);
    this.imageURL = new SimpleStringProperty(imageURL);

}

public String getId() {return id.get();}
public String getFirstName() {return firstName.get();}
public String getLastName() {return lastName.get();}
public String getDepartment() {return department.get();}
public String getMajor() {return major.get();}
public String getEmail() {return email.get();}
public String getImageURL() {return imageURL.get();}


public void setId(String v)    {id.set(v);}
public void setFirstName(String v) {firstName.set(v); }
public void setLastName(String v) {lastName.set(v);}
public void setDepartment(String v) {department.set(v);}
public void setMajor(String v) {major.set(v);}
public void setEmail(String v) {email.set(v);}
public void setImageURL(String v){imageURL.set(v);}



public SimpleStringProperty idProperty() {return id; }
public SimpleStringProperty firstNameProperty() {return firstName; }
public SimpleStringProperty lastNameProperty() {return lastName;}
public SimpleStringProperty departmentProperty() {return department;}
public SimpleStringProperty majorProperty() {return major;}
public SimpleStringProperty emailProperty() {return email;}
public SimpleStringProperty imageURLProperty() {return imageURL;}

}