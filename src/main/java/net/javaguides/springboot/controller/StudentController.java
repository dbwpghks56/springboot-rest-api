package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
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

    // Spring Boot Rest API with Path Variable
    @GetMapping("/student/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(
            @PathVariable(name = "id") int studentId,
            @PathVariable(name = "first-name") String firstName,
            @PathVariable(name = "last-name") String lastName)
    {
        return new Student(studentId, firstName, lastName);
    }

    // Spring Boot Rest API with Request Parameter
    @GetMapping("/student/query")
    public Student studentRequestVariable(
            @RequestParam(name = "id") int studentId,
            @RequestParam(name = "first-name") String firstName,
            @RequestParam(name = "last-name") String lastName)
    {
        return new Student(studentId, firstName, lastName);
    }
}
