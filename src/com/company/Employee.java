package com.company;

import java.util.Date;

public class Employee {
    private String name;
    private Date dateOfJoining;
    private Integer age;

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Date getDateOfJoining () {
        return dateOfJoining;
    }

    public void setDateOfJoining ( Date dateOfJoining ) {
        this.dateOfJoining = dateOfJoining;
    }

    public Integer getAge () {
        return age;
    }

    public void setAge ( Integer age ) {
        this.age = age;
    }

    public Employee(String name,Integer age,Date dateOfJoining){
        this.name=name;
        this.age=age;
        this.dateOfJoining=dateOfJoining;
    }

    public Employee () {
    }

    @Override
    public String toString () {
        return "Employee{" + "name='" + name + '\'' + ", dateOfJoining=" + dateOfJoining + ", age=" + age + '}';
    }
}
