package com.arfanitengr.schoolservice;

import java.util.List;

public class SchoolWithStudents {
    private String name;
    private String email;
    private List<Student> students;

    public SchoolWithStudents() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
