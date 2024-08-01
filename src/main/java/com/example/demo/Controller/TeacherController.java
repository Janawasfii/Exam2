package com.example.demo.Controller;

import com.example.demo.APIResponse.API;
import com.example.demo.Model.Teacher;
import com.example.demo.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
       teacherService.addTeachers(teacher);
        return ResponseEntity.status(200).body(new API("Successfully Added"));
    }
@PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id, @RequestBody Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = teacherService.updateTeachers(id, teacher);
        if(isUpdated){
            teacherService.updateTeachers(id, teacher);
            return ResponseEntity.status(200).body(new API("Successfully Updated"));

        }
        return ResponseEntity.status(404).body(new API("Not Found"));}

@DeleteMapping("/delete/{id}")
public ResponseEntity deleteTeacher(@PathVariable int id){
        boolean isDeleted = teacherService.deleteTeachers(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new API("Successfully Deleted"));
        }
        return ResponseEntity.status(404).body(new API("Not Found"));
}

@GetMapping("/gets/{id}")
    public ResponseEntity getTeacher(@PathVariable int id){
        return ResponseEntity.status(200).body(teacherService.getsTeacherByID(id));
}
@GetMapping("/find/{salary}")
    public ResponseEntity findTeacher(@PathVariable int salary){

        return ResponseEntity.status(200).body(teacherService.getTeacherBySalary(salary));
}












}


