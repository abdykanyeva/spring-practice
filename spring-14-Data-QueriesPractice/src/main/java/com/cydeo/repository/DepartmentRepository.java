package com.cydeo.repository;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    // Display all departments in the furniture department

    List<Department> findByDepartment(String department);


    // Display all departments in the Health Division

    List<Department> findByDivision(String division);

    // Display all employees that firstname is not ""



}
