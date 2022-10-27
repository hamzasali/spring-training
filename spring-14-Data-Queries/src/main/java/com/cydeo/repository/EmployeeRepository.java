package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Display all employee with email address
    List<Employee> findByEmail(String email);

    //Display all employees with firstname "" and lastname ""
    //also show all employees with an email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees that firstname is not ""
    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees where lastname starts with ""
    List<Employee> findByLastNameStartingWith(String lastName);

    //Display all employee with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employee with salaries less than ""
    List<Employee> findBySalaryLessThan(Integer salary);
}
