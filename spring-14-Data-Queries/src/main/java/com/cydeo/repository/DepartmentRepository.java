package com.cydeo.repository;

import com.cydeo.entity.Department;
import net.bytebuddy.implementation.bytecode.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {

    //Display all departments
    List<Department> findByDepartment(String department);

    //Display all departments in Health Division
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //Display all departments with division name ends with 'ics'
    List<Department> findByDivisionEndingWith(String pattern);

    //Display top 3 departments with division name includes 'Hea' without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String pattern);
    @Query("select d From Department d Where d.division In ?1")
    List<Department> retrieveDepartmentDivision(List<String> divisions);

}
