package com.siddh.Student.dto;

import java.util.List;

public class DepartmentDTO {

    private String name;
    private List<StudentDTO> students;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String name, List<StudentDTO> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }

}
