package com.training.controller;
import com.training.entity.ApiResponse;
import com.training.entity.Student;
import com.training.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.List;

@RestController
@CrossOrigin

@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @CrossOrigin
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    //create request
    @PostMapping
    @CrossOrigin
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        try {
            studentService.addStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse("success", "Student added successfully", student));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("error", "An error occurred while adding student", null));
        }
    }

    //get request find by id
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable int id) {
        try {
            Student student = studentService.getStudentById(id);
            if (student == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse("error", "Student not found with id " + id, null));
            }
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("success", "Student retrieved successfully", student));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("error", "An error occurred while retrieving student", null));
        }
    }
//delete student by id
@CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudentById(@PathVariable int id) {
        try {
             Student deleted = studentService.deleteStudentById(id);
            if (deleted != null) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new ApiResponse("success", "Student deleted successfully with id " + id, deleted));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ApiResponse("failed", "No student found with id " , null));
            }

        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("error", "An error occurred while deleting student", null));
        }
    }

    //update student
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudentById(@PathVariable int id, @RequestBody Student updatedStudent) {
        try {
            Student student = studentService.getStudentById(id);
            if (student == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse("error", "Student not found with id " + id, null));
            }

            // Update student fields
            if (updatedStudent.getName() != null) {
                student.setName(updatedStudent.getName());
            }
            if (updatedStudent.getGender() != null) {
                student.setGender(updatedStudent.getGender());
            }
            if (updatedStudent.getCourse() != null) {
                student.setCourse(updatedStudent.getCourse());
            }
            if (updatedStudent.getHobbies() != null) {
                student.setHobbies(updatedStudent.getHobbies());
            }

            studentService.updateStudent(student);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("success", "Student updated successfully", student));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("error", "An error occurred while updating student", null));
        }
    }

}
