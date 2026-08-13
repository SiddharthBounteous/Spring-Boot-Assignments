package com.siddh.JDBCSpringDataJPAHibernateDemo.repository.jdbc;

import com.siddh.JDBCSpringDataJPAHibernateDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcEmployeeRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Employee findByNameAndDepartment(String name, String department) {
        String sql="select * from employee where name=? and department=?";
        return jdbcTemplate.queryForObject(sql,new EmployeeRowMapper(),name,department);
    }
}

class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee emp=new Employee();

        emp.setId(rs.getLong("id"));
        emp.setName(rs.getString("name"));
        emp.setDepartment(rs.getString("department"));
        return emp;
    }
}
