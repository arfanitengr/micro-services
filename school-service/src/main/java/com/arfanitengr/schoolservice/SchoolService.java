package com.arfanitengr.schoolservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arfanitengr.schoolservice.client.StudentClient;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentClient studentClient;

    // public SchoolService(SchoolRepository schoolRepository, StudentClient
    // studentClient) {
    // this.schoolRepository = schoolRepository;
    // this.studentClient = studentClient;
    // }

    public School createSchool(School school) {
        return this.schoolRepository.save(school);
    }

    public List<School> readSchools() {
        return this.schoolRepository.findAll();
    }

    public SchoolWithStudents readSchoolById(Integer schoolId) {
        School school = schoolRepository.findById(schoolId).get();
        List<Student> students = studentClient.readStudentsBySchool(schoolId);

        SchoolWithStudents sws = new SchoolWithStudents();
        sws.setName(school.getName());
        sws.setEmail(school.getEmail());
        sws.setStudents(students);
        return sws;
    }
}
