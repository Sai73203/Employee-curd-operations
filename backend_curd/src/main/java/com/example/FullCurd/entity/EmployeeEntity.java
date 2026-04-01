package com.example.FullCurd.entity;

import jakarta.persistence.*;

@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String tech;
    private int salary;

    // Default Constructor
    public EmployeeEntity() {
    }

    // Parameterized Constructor
    public EmployeeEntity(int id, String name, String tech, int salary) {
        this.id = id;
        this.name = name;
        this.tech = tech;
        this.salary = salary;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // toString
    @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", name=" + name + ", tech=" + tech + ", salary=" + salary + "]";
    }
}