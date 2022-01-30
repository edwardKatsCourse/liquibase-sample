package com.example.studentsdemo.service;

import com.example.studentsdemo.domain.StudentDTO;

import java.util.List;

public interface StudentService {

    void create(StudentDTO studentDTO);
    StudentDTO findById(Long id);
//    List<StudentDTO> findAllByCourseId(Long courseId);
}
