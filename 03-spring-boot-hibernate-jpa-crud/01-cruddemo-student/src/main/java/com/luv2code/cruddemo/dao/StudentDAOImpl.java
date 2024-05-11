package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
//define field for entity manager
    private EntityManager entityManager;
//inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

// implement to save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);//save
    }

    @Override
    public Student findByID(Integer id) {
       return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student>Query=entityManager.createQuery(" from Student ",Student.class);
        return Query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery=entityManager.createQuery("From Student where lastName=:theData",Student.class);



        //set query parameters
        theQuery.setParameter("theData",theLastName);


        //return query results
        return theQuery.getResultList();


    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent=entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted=entityManager.createQuery("Delete from Student").executeUpdate();

        return numRowsDeleted;
    }
}
