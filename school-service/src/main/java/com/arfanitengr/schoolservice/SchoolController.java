package com.arfanitengr.schoolservice;

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

import com.arfanitengr.schoolservice.client.StudentClient;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody School school) {
        School s = schoolService.createSchool(school);

        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<School>> readSchools() {
        List<School> schools = schoolService.readSchools();
        return new ResponseEntity<>(schools, HttpStatus.OK);
    }

    @GetMapping("/{schoolId}")
    public ResponseEntity<SchoolWithStudents> readSchoolById(@PathVariable("schoolId") Integer schoolId) {
        SchoolWithStudents sws = schoolService.readSchoolById(schoolId);
        return new ResponseEntity<>(sws, HttpStatus.OK);
    }
}
