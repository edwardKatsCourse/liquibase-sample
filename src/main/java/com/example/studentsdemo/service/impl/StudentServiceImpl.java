package com.example.studentsdemo.service.impl;

import com.example.studentsdemo.domain.StudentDTO;
import com.example.studentsdemo.entity.Course;
import com.example.studentsdemo.entity.Student;
import com.example.studentsdemo.repository.StudentRepository;
import com.example.studentsdemo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void create(StudentDTO studentDTO) {
        Student student = Student.builder()
                .name(studentDTO.getName())
                .build();

        studentRepository.save(student);
    }

    @Override
    public StudentDTO findById(Long id) {
        Student student = studentRepository.getById(id);

        Course course = student.getCourse();

        Long courseId = course == null ? null : course.getId();

        // Custom DTO
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .courseId(courseId)
                .build();
    }
}
