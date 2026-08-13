package com.siddh.JDBCSpringDataJPAHibernateDemo.repository.jpa;

import com.siddh.JDBCSpringDataJPAHibernateDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class JpaEmployeeRepository {

    @PersistenceContext
    private EntityManager em;

    public Employee findByNameAndDepartment(String name,String department){
        String jpql="from Employee where name= :name and department= :department";

        return em.createQuery(jpql, Employee.class)
                .setParameter("name",name)
                .setParameter("department",department)
                .getSingleResult();
    }
}
