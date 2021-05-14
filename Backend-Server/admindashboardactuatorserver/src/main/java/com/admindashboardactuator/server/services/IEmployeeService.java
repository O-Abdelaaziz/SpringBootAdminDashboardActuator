package com.admindashboardactuator.server.services;

import com.admindashboardactuator.server.models.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> findAllEmployees();
    public Employee findEmployeeById(Long id);
    public Employee AddEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(Long id);
}
