package com.admindashboardactuator.server.services.impl;

import com.admindashboardactuator.server.models.Employee;
import com.admindashboardactuator.server.repositories.EmployeeRepository;
import com.admindashboardactuator.server.services.IEmployeeService;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public Page<Employee> findAllEmployees(int page, int size) {
        if (page > 0) page -= 1;
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        Page<Employee> employeePage  = employeeRepository.findAll(pageable);
        return employeePage;
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void generateEmployees(Integer size) {
        Long checkEmployeeCount = employeeRepository.count();
        System.out.println(checkEmployeeCount);
        if (checkEmployeeCount == 0) {
            List<Employee> employeeList = new ArrayList<>();
            Faker faker = new Faker();

            for (int i = 0; i < size; i++) {
                Employee employee = new Employee();
                String firstName=faker.name().firstName();
                String lastName=faker.name().lastName();
                String fullName=firstName+"+"+lastName;
                Date birthDay=faker.date().birthday();
                employee.setCode(faker.code().imei());
                employee.setIdNumber(faker.idNumber().valid());
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setBirthday(birthDay);
                employee.setCountry(faker.country().name());
                employee.setAddress(faker.address().fullAddress());
                employee.setEmail(faker.internet().emailAddress());
                employee.setCreditCardNumber(faker.business().creditCardNumber());
                employee.setCreditCardType(faker.business().creditCardType());
                employee.setCreditCardExpiry(faker.business().creditCardExpiry());
                employee.setPromotionCode(faker.commerce().promotionCode());
                employee.setProfession(faker.company().profession());
                employee.setSkills(faker.job().keySkills());
                employee.setJobTitle(faker.job().title());
                employee.setPhone(faker.phoneNumber().phoneNumber());
                employee.setJoinDate(DateUtils.addYears(birthDay,20).toString());
                employee.setDescription(faker.lorem().paragraph(2));
                employee.setImageUrl("https://ui-avatars.com/api/?name="+fullName);

                employeeList.add(employee);
            }
            employeeList.forEach(item -> System.out.println(item.getBirthday()+" "+ item.getJoinDate()));
            employeeRepository.saveAll(employeeList);
        }
    }

    @Override
    public Employee AddEmployee(Employee employee) {
        employee.setCode(UUID.randomUUID().toString());
        LOGGER.info("Created user with code: {}", employee.getCode());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
}
