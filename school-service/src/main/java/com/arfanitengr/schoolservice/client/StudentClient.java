package com.arfanitengr.schoolservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arfanitengr.schoolservice.Student;

@FeignClient(name = "student-service", url = "http://localhost:8764")
public interface StudentClient {

    @GetMapping("/students/schools/{schoolId}")
    List<Student> readStudentsBySchool(@PathVariable("schoolId") Integer schoolId);
}
