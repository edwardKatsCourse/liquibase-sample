package com.example.studentsdemo.controller;

import com.example.studentsdemo.domain.StudentDTO;
import com.example.studentsdemo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/students")
    public void createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.create(studentDTO);
    }

    @GetMapping("/students/{id}")
    public StudentDTO findByBy(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }


}
