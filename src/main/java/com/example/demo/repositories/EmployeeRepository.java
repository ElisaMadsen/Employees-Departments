package com.example.demo.repositories;

import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements CRUDInterface<Employee> {

    @Override
    public boolean create(Employee entity) {

        try{

            Connection conn = DatabaseConnectionManager.getConnection();

            String sqlString = "INSERT INTO employees (`id`, `employee_name`, `job`, `manager`, `hiredate`, `salary`, `commission`, `department_number`)" +
                                " VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sqlString);

            pstmt.setInt(1, entity.getId());
            pstmt.setString(2, entity.getEmployeeName());
            pstmt.setString(3, entity.getJob());
            pstmt.setInt(4, entity.getManager());
            pstmt.setString(5, entity.getHireDate());
            pstmt.setInt(6, entity.getSalary());
            pstmt.setInt(7, entity.getCommission());
            pstmt.setInt(8, entity.getDepartmentNumber());

            pstmt.executeUpdate();
            pstmt.close();
            System.out.println(sqlString);

        } catch (SQLException e){
            System.out.println("fail");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Employee getSingleEntityById() {

        try {

        Connection conn = DatabaseConnectionManager.getConnection();
        String sql = "SELECT * FROM employees WHERE id";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            rs.getInt(1);
            rs.getString(2);
            rs.getString(3);
            rs.getInt(4);
            rs.getString(5);
            rs.getInt(6);
            rs.getInt(7);
            rs.getInt(8);
        }
        conn.close();

        } catch (SQLException e){
                System.out.println("Whoops");
                e.printStackTrace();

              }
        return new Employee();
    }

    @Override
    public List<Employee> getAllEntities() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                //Indsætte i en liste

                int id = rs.getInt("id");
                String employeeName = rs.getString("employee_name");
                String job = rs.getString("job");
                int manager = rs.getInt("manager");
                String hireDate = rs.getString("hiredate");
                int salary = rs.getInt("salary");
                int commission = rs.getInt("commission");
                int departmentNumber = rs.getInt("department_number");

                Employee employee = new Employee(id, employeeName, job, manager, hireDate, salary, commission, departmentNumber);

                employees.add(employee);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Something wrong with database");
        }
        return employees;

    }

    @Override
    public boolean update(Employee entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
