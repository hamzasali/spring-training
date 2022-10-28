package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("select e From Employee e Where e.salary <> ?1")
        //Not equal
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    @Query("Select e From Employee e Where e.firstName Like ?1")
        //Like / contains / startsWith / endsWith
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    @Query("select e From Employee e where e.salary < ?1")
        //Less than
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    @Query("select e.firstName From Employee e where e.salary > ?1")
        //Greater than
    List<String> retrieveEmployeeSalaryGreaterThan(int salary);

    @Query("Select e From Employee e where e.salary BETWEEN ?1 AND ?2")
        //between
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    @Query("select e From Employee e Where e.hireDate < ?1")
        //Before
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    @Query("select e From Employee e Where e.email IS null ")
        //NULL
    List<Employee> retrieveEmployeeEmailIsNull();

    @Query("select e From Employee e Where e.email IS Not null ")
        //Not NULL
    List<Employee> retrieveEmployeeEmailIsNotNull();

    @Query("select e From Employee e order by e.salary")
        //Sorting in ASC Order
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    @Query("select e From Employee e order by e.salary DESC")
        //Sorting in Desc Order
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    @Query(value = "Select * From employees Where salary = ?1", nativeQuery = true)
        //Native Query
    List<Employee> retrieveEmployeeDetailBySalary(int salary);


    //Named Parameter
    @Query("Select e From Employee e where e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);


}
