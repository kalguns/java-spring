package com.cybertek;

import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DrivedqueriApplication {

    @Autowired
    RegionRepository regionRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DrivedqueriApplication.class, args);
    }

    @PostConstruct
    public void testRegions(){

        System.out.println("----------------Region start--------------");

        System.out.println("findByCountry:" + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry:" + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining:" + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByCountry:" + regionRepository.findByCountryContainingOrderByRegion("Asia"));
        System.out.println("findTopBy2ByCountry:" + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("----------------Region end--------------");
    }

    @PostConstruct
    public void testDepartments(){

        System.out.println("----------------Region start--------------");

        System.out.println("findByDepartment:" + departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDepartment:" + departmentRepository.findByDivision("Outdoors"));
        System.out.println("findByDepartment:" + departmentRepository.findByDivisionEndingWith("ics"));
        System.out.println("findByDepartment:" + departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));


        System.out.println("----------------Region end--------------");
    }

    @PostConstruct
    public void testEmployees(){

        System.out.println("----------------Region start--------------");

        System.out.println(employeeRepository.findByEmailIsNull() );

        System.out.println("----------------Region end--------------");
    }
}
