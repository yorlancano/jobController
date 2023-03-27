package com.employee_Management.employment.Model;

import jakarta.persistence.*;

@Entity
@Table(name = ("employee"))
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length = 60, nullable = false)
    private String name;
    @Column(name = "last_name", length = 60, nullable = false)
    private String last_name;
    @Column(name = "email", length = 60, nullable = false, unique = true)
    private String email;

    public Employee (){

    }

    public Employee(long id, String name, String last_name, String email) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
