package com.admindashboardactuator.server.repositories;

import com.admindashboardactuator.server.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findEmployeeByFirstNameContaining(String name);
    List<Employee> findEmployeeByLastNameContaining(String name);
}
