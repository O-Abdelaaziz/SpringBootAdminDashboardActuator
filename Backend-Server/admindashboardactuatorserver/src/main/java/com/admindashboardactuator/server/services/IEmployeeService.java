package com.admindashboardactuator.server.services;

import com.admindashboardactuator.server.models.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEmployeeService {
    public Page<Employee> findAllEmployees(int page, int size);
    public Employee findEmployeeById(Long id);
    public void generateEmployees(Integer size);
    public Employee AddEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(Long id);
    public void deleteAllEmployees();
}
