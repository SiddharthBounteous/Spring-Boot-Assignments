package com.siddh.Student.repository;

import com.siddh.Student.dto.DepartmentRecord;
import com.siddh.Student.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query("select new com.siddh.Student.dto.DepartmentRecord(d.name,s.name,COUNT(c.id)) " +
            "from Department d "+
            "left join d.Students s "+
            "left join s.courses c "+
            "group by d.id, d.name, s.id, s.name")
    List<DepartmentRecord>getDepartmentStudentStats();
}
