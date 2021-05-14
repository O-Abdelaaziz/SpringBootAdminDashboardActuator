package com.admindashboardactuator.server.resources;

import com.admindashboardactuator.server.models.Employee;
import com.admindashboardactuator.server.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(name = "/employees")
public class EmployeeResource {

    private IEmployeeService iEmployeeService;

    @Autowired
    public EmployeeResource(IEmployeeService iEmployeeService){
        this.iEmployeeService=iEmployeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = iEmployeeService.findAllEmployees();
        return new ResponseEntity<>(employeeList, OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = iEmployeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = iEmployeeService.AddEmployee(employee);
        return new ResponseEntity<>(newEmployee, CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = iEmployeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        iEmployeeService.deleteEmployee(id);
        return new ResponseEntity<>(OK);
    }
}
