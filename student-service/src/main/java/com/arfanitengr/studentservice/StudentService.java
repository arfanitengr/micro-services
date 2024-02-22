package com.arfanitengr.studentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> readStudents() {
        return studentRepository.findAll();
    }

    public List<Student> readStudentsBySchoolId(Integer id) {
        return studentRepository.findAllBySchoolId(id);
    }
}
