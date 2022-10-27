package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
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

    //Display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate date1, LocalDate date2);

    //Display all employee where salary is greater and equal to "" in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employee that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employee that do not have email
    List<Employee> findByEmailIsNull();

    @Query("SELECT e FROM Employee e where e.email='fmorffew4@a8.net'")
    Employee retrieveEmployeeDetail();

    @Query("Select e.salary FROM Employee e Where e.email='fmorffew4@a8.net'")
    Integer retrieveEmployeeSalary();

}
