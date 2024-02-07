package com.example.mockitohw.demo.employee;


public class Employee {

    private int id;
    private String employees;
    private double salary;

    public Employee(int id, String employees, int salary) {
        this.id = id;
        this.employees = employees;
        this.salary = salary;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
