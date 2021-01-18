package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    //single named parameter
    @Query("SELECT  e FROM Employee e WHERE e.salary=:salary")
    Employee getEmployeeBySalary(@Param("salary") int salary);

    //mulitiple name parameters
    @Query("SELECT e FROM Employee e WHERE e.firstName=:name OR e.salary=:salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("name") String name, @Param("salary") int salary);

    //Not Equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1 ")
    List<Employee> getEmployeeBySalaryNotEqual(int salary);

    //Like / Contains / Starts With /Ends With
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1 ")
    List<Employee> getEmployeeByFirstNameLike(String pattern);

    //Less Than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(int salary);

    //Grater Than
    @Query("SELECT e FROM Employee  e WHERE e.salary > ?1 ")
    List<Employee> getEmployeeBySalaryGreaterThan(int salary);


}
