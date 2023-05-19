package com.techelevator;

public class Employee {
    //Instance Variables
    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private double annualSalary;

    //Constructor
    public Employee(int employeeId, String firstName, String lastName, double annualSalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;

    }

    //Getters
    public String getFullName() {
        return this.lastName + ", " + this.firstName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    //Setters

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void raiseSalary (double percent) {
        double raiseAmount = this.annualSalary * (percent/100);
        annualSalary = annualSalary + raiseAmount;
    }
}
