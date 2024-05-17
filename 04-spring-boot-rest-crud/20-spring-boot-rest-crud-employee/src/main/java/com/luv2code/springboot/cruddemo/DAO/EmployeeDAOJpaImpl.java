package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    //define field for entity manager
    private EntityManager entityManager;

    //setup up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee=entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteEmployeeById(int theId) {
        Employee theEmployee= entityManager.find(Employee.class,theId);
        entityManager.remove(theEmployee);

    }

    @Override
    public List<Employee> findAll() {
        // create  a query
        TypedQuery<Employee> Query = entityManager.createQuery("FROM Employee", Employee.class);
        return Query.getResultList();
    }

    @Override
    public Employee findByID(int theId) {
        // get employee
        Employee theEmployee=entityManager.find(Employee.class,theId);
        //return employee
        return theEmployee;
    }
}
