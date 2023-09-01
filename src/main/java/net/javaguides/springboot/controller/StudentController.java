package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    public Student getStudent() {
        return new Student(1, "Ramesh", "Fadatare");
    }
}
