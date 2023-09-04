package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "Ramesh", "Fadatare");
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return List.of(
                new Student(1, "Ramesh", "Fadatare"),
                new Student(2, "Tony", "Stark")
        );
    }
}
