package com.siddh.Student.service;

import com.siddh.Student.dto.DepartmentDTO;
import com.siddh.Student.dto.DepartmentRecord;
import com.siddh.Student.dto.StudentDTO;
import com.siddh.Student.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    public List<DepartmentDTO> getDepartmentStats() {

        List<DepartmentRecord>data=departmentRepository.getDepartmentStudentStats();

        return data.stream()
                .collect(Collectors.groupingBy(
                        DepartmentRecord::departmentName,
                        Collectors.mapping(dto->new StudentDTO(dto.studentName(),dto.courseCount()),Collectors.toList())))
                .entrySet().stream()
                .map(entry -> new DepartmentDTO(entry.getKey(),entry.getValue()))
                .collect(Collectors.toList());
    }
}
