package com.admindashboardactuator.server.resources;

import com.admindashboardactuator.server.models.Employee;
import com.admindashboardactuator.server.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {

    private IEmployeeService iEmployeeService;

    @Autowired
    public EmployeeResource(IEmployeeService iEmployeeService){
        this.iEmployeeService=iEmployeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Employee>> getAllEmployees(@RequestParam(name = "page", defaultValue = "0") int page,
                                                          @RequestParam(name = "size", defaultValue = "8") int size) {
        Page<Employee> employeeList = iEmployeeService.findAllEmployees(page, size);
        return new ResponseEntity<>(employeeList, OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = iEmployeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, OK);
    }

    @GetMapping("/generate")
    public ResponseEntity<?> generateEmployee(@RequestParam(name = "size", defaultValue = "100") Integer size) {
        iEmployeeService.generateEmployees(size);
        return new ResponseEntity<>(OK);
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

    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteALlEmployees() {
        iEmployeeService.deleteAllEmployees();
        return new ResponseEntity<>(OK);
    }
}
