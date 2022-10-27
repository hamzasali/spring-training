package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-------------------REGIONS-------------------");
        System.out.println("findByCountry:" + regionRepository.findByCountry("Canada"));
        System.out.println("findByCountryContaining:" + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByRegionDesc:" + regionRepository.findByCountryContainsOrderByRegionDesc("United"));
        System.out.println("findTopByCountry:" + regionRepository.findTopByCountry("United States"));
        System.out.println("findTop2ByCountry:" + regionRepository.findTop2ByCountry("United States"));
        System.out.println("findTopByCountryContainsOrderByRegion:" + regionRepository.findTopByCountryContainsOrderByRegion("United"));

        System.out.println("-------------------DEPARTMENTS-------------------");
        System.out.println("findByDepartment:" + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivision:" + departmentRepository.findByDivision("Health"));
        System.out.println("findByDivisionEndingWith:" + departmentRepository.findByDivisionEndingWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContaining:" + departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));

        System.out.println("-------------------EMPLOYEES-------------------");
        System.out.println("findByEmail:" + employeeRepository.findByEmail("fmorffew4@a8.net"));
        System.out.println("findByFirstNameAndLastNameOrEmail:" + employeeRepository.findByFirstNameAndLastNameOrEmail("Jodi","Hook",""));
        System.out.println("findByFirstNameIsNot:" + employeeRepository.findByFirstNameIsNot("Sydney"));
        System.out.println("findByLastNameStartingWith:" + employeeRepository.findByLastNameStartingWith("T"));
        System.out.println("findBySalaryGreaterThan:" + employeeRepository.findBySalaryGreaterThan(10000));
        System.out.println("findBySalaryLessThan:" + employeeRepository.findBySalaryLessThan(10000));
        System.out.println("findByHireDateBetween:" + employeeRepository.findByHireDateBetween(LocalDate.of(2002,2,12),LocalDate.of(2005,2,12)));
        System.out.println("findBySalaryGreaterThanEqualOrderBySalaryDesc:" + employeeRepository.findBySalaryGreaterThanEqualOrderBySalaryDesc(10000));
        System.out.println("findDistinctTop3BySalaryLessThan:" + employeeRepository.findDistinctTop3BySalaryLessThan(10000));
        System.out.println("findByEmailIsNull:" + employeeRepository.findByEmailIsNull());

        System.out.println(employeeRepository.retrieveEmployeeDetail());
        System.out.println(employeeRepository.retrieveEmployeeSalary());

    }
}
