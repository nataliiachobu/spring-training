

package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
//Derive query//
    //Display all employees with email address ""
    List<Employee> findByEmail(String email);


    //Display all employees with firstname "" and last name "",
    //also show all employees with an email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname, String lastname, String email);

    //Display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstname);

    //Display all employees where last name starts with ""
    List<Employee> findByLastNameStartsWith(String pattern);

    //Display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries less than ""
    List<Employee> findBySalaryLessThan(Integer salary);

    @Query("Select employee FROM Employee employee WHERE employee.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();
    @Query("SELECT e.salary FROM Employee e WHERE e.email='amcnee1@google.es'")
    Integer retrieveEmployeeSalary();
    //not equal JPQL

    @Query ("select e from Employee e where e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //Like / contains/startsWiths/EndsWith
    @Query ("select e from Employee e where e.firstName like ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //less than
    @Query("select e from Employee e where e.salary< ?1")
    List <Employee> retrieveEmployeeSalaryLessThan(int salary);

    @Query("select e.firstName from Employee e where e.salary< ?1")
    List <String> retrieveEmployeeSalaryLessThanNames(int salary);

    @Query("select e from Employee e where e.salary> ?1")
    List <Employee> retrieveEmployeeSalaryGreaterThan(int salary);

//between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List <Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);



    //before
    @Query ("select e from Employee e where e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(Local date);

    //Null
    @Query("select e from Employee e where e.email is null ")
    List<Employee>  retrieveEmployeeEmailNull();

    @Query("select e from Employee e where e.email is not null ")
    List<Employee>  retrieveEmployeeEmailNotNull();

    //sorting in asc order

    @Query("select e from Employee e order by e.salary")
    List<Employee>  retrieveEmployeeSalaryOrderAsc();

    @Query("select e from Employee e order by e.salary desc ")// in descending way JPQL
    List<Employee>  retrieveEmployeeSalaryOrderDesc();

    //Native query Rule if you write not derive query you need to put @Query annotation
    @Query(value ="select * from employees where salary =?1", nativeQuery = true)
    List <Employee> retrieveEmployeeDetailBySalary(int salary);




}