package com.siddh.JDBCSpringDataJPAHibernateDemo.repository.hibernate;

import com.siddh.JDBCSpringDataJPAHibernateDemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class HibernateEmployeeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Employee findByNameAndDepartment(String name,String department){
        //opening a session
        try(Session session=sessionFactory.openSession()){

            //here we have followed java naming convention, not sql because hibernate deals directly with entities not sql
            //here Employee-> class not table
            //name and department are fields not column name
            String hql="from Employee where name= :name and department= :department";

            //send response based on Employee class
            return session.createQuery(hql,Employee.class)
                    .setParameter("name",name)
                    .setParameter("department",department)
                    .uniqueResult();  //when we expect that there is only unique result
        }
    }
}
