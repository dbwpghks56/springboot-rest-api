package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
//        return new ResponseEntity<>(
//                new Student(1, "Ramesh", "Fadatare"),
//                HttpStatus.OK
//        );
//        return ResponseEntity.ok(
//                new Student(1, "Ramesh", "Fadatare")
//        );
        return ResponseEntity.ok().header("Custom-Header", "foo").body(
                new Student(1, "Ramesh", "Fadatare")
        );
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

    // Spring Boot Rest API that handles HTTP Post Request - creating new resource
    // @PostMapping and @RequestBody
    @PostMapping("/student/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Student> studentPost(@RequestBody Student student) {
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring Boot Rest API that handles HTTP Put Request - updating existing resource
    @PutMapping("/student/{id}/update")
    public Student updateStudent(
            @RequestBody Student student,
            @PathVariable(name = "id") int studentId
    ) {
        student.setId(studentId);
        return student;
    }
}











