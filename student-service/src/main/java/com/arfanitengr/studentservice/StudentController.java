package com.arfanitengr.studentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Student student) {
        Student s = studentService.createStudent(student);

        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> readStudents() {
        List<Student> students = studentService.readStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/schools/{schoolId}")
    public List<Student> readStudentsBySchoolId(@PathVariable("schoolId") Integer schoolId) {
        List<Student> students = studentService.readStudentsBySchoolId(schoolId);
        return students;
    }
}
