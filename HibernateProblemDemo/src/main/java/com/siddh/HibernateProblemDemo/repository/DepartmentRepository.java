package com.siddh.HibernateProblemDemo.repository;

import com.siddh.HibernateProblemDemo.entity.Department;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {


    //JOIN FETCH tells Hibernate to fetch departments and employees together in one SQL query, so later accessing department.getEmployees() does not trigger separate queries.
    @Query("select p from Department p left join fetch p.employees")
    List<Department> findWithoutNPlusOne();

    //When calling findAll(), fetch Department along with its employees in the same query/optimized fetch plan.
    //Spring Data JPA tells Hibernate:
    //While fetching Department, also fetch employees.
    //@EntityGraph = fetch these relationships also for this query
    //For this repository method, Hibernate should not follow the default lazy/eager rules only. It should also fetch the attributes mentioned in @EntityGraph.
    @EntityGraph(attributePaths = {"employees"})
    List<Department>findAll();
}
