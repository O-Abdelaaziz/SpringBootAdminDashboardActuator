package com.admindashboardactuator.server.seeders;

import com.admindashboardactuator.server.models.Employee;
import com.admindashboardactuator.server.repositories.EmployeeRepository;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DatabaseSeeder {

    private EmployeeRepository employeeRepository;

    @Autowired
    public DatabaseSeeder(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedEmployeesTable();
    }

    private void seedEmployeesTable() {
        Long checkEmployeeCount = employeeRepository.count();
        System.out.println(checkEmployeeCount);
        if (checkEmployeeCount == 0) {
            List<Employee> employeeList = new ArrayList<>();
            Faker faker = new Faker();

            for (int i = 0; i < 100; i++) {
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
//            employeeRepository.saveAll(employeeList);
        }
    }
}
