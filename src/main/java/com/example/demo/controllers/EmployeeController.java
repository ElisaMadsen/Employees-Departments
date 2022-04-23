package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.utility.DatabaseConnectionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class EmployeeController {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    @GetMapping("/employees")
    public String getEmployees(Model dataToView){
        DatabaseConnectionManager.getConnection();
        dataToView.addAttribute("allEmployees", employeeRepository.getAllEntities());
        return "employees";
    }


    @PostMapping("/employeeregistered")
    public String employeeRegistered(WebRequest dataFromForm){
        DatabaseConnectionManager.getConnection();
        int employeeID = Integer.parseInt(dataFromForm.getParameter("employee-id"));
        String employeeName = dataFromForm.getParameter("employee-name");
        String employeeJob = dataFromForm.getParameter("employee-job");
        int employeeManager = Integer.parseInt(dataFromForm.getParameter("employee-manager"));
        String employeeHireDate = dataFromForm.getParameter("employee-hiredate");
        int employeeSalary = Integer.parseInt(dataFromForm.getParameter("employee-salary"));
        int employeeCommission = Integer.parseInt(dataFromForm.getParameter("employee-commission"));
        int employeeDepartment = Integer.parseInt(dataFromForm.getParameter("employee-department"));

        Employee employee = new Employee (employeeID, employeeName, employeeJob, employeeManager, employeeHireDate, employeeSalary, employeeCommission, employeeDepartment);
        employeeRepository.create(employee);

    return "employeeregistered";

    }

    @GetMapping("/singleemployee")
    public String showSingleEmployee(@RequestParam Model dataToView){
        DatabaseConnectionManager.getConnection();
        dataToView.addAttribute("singleEmployee", employeeRepository.getSingleEntityById());

        return "singleemployee";
    }

}
