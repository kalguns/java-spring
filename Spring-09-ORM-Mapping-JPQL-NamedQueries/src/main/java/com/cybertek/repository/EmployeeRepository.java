package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT e FROM Employee  e WHERE e.email = 'btrow5@technorati.com'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'btrow5@technorati.com'")
    Integer getEmployeeSalary();

    //single bind parameter

    @Query("SELECT e FROM Employee e WHERE e.email = ?1 ")
    Optional<Employee> getEmployeeEmail(String email);

    //multiple bind parameter
    @Query("SELECT e  FROM Employee e WHERE  e.email=?1 AND e.salary=?2")
    Employee getEmployeeByEmailAndSalary(String email,int salary);
}
