package com.siddh.Student.dto;

public class StudentDTO {

    private String name;
    private long courseCount;

    public StudentDTO() {
    }

    public StudentDTO(String name, long courseCount) {
        this.name = name;
        this.courseCount = courseCount;
    }

    public String getName() {
        return name;
    }

    public long getCourseCount() {
        return courseCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseCount(long courseCount) {
        this.courseCount = courseCount;
    }
}
