package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findByID(int theId);
    Employee save(Employee employee);
    void deleteEmployeeById(int theId);


}
