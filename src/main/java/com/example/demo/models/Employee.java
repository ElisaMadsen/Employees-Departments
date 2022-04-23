package com.example.demo.models;

public class Employee {
    private int id;
    private String employeeName;
    private String job;
    private int manager;
    private String hireDate;
    private int salary;
    private int commission;
    private int departmentNumber;


    public Employee(int id, String employeeName, String job, int manager, String hireDate, int salary, int commission, int departmentNumber) {
        this.id = id;
        this.employeeName = employeeName;
        this.job = job;
        this.manager = manager;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commission = commission;
        this.departmentNumber = departmentNumber;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getJob() {
        return job;
    }

    public int getManager() {
        return manager;
    }

    public String getHireDate() {
        return hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public int getCommission() {
        return commission;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", job='" + job + '\'' +
                ", manager=" + manager +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", commission=" + commission +
                ", departmentNumber=" + departmentNumber +
                '}';
    }
}



