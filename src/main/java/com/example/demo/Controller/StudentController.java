package com.example.demo.Controller;

import com.example.demo.APIResponse.API;
import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/get")
public ResponseEntity getStudents() {
    return ResponseEntity.status(200).body(studentService.getStudents());

}
@PostMapping("/add")
public ResponseEntity addStudents(@Valid @RequestBody Student student, Errors errors) {
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new API("Successfully added"));
}
@PutMapping("/update/{id}")
public ResponseEntity updateStudents(@PathVariable int id,@Valid @RequestBody Student student, Errors errors) {
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = studentService.updateStudent(id, student);
        if(isUpdated){
            return ResponseEntity.status(200).body(new API("Successfully updated"));
        }
        return ResponseEntity.status(404).body(new API("Not found"));
}
@DeleteMapping("/delete/{id}")
public ResponseEntity deleteStudents(@PathVariable int id) {
        boolean isDeleted = studentService.deleteStudent(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new API("Successfully deleted"));
        }
        return ResponseEntity.status(404).body(new API("Not found"));
}
@GetMapping("/search/{name}")
  public ResponseEntity searchStudents(@PathVariable String name) {
        //if(name.equals(null)){
        return ResponseEntity.status(200).body(studentService.getStudentByName(name));
    //}
       // return ResponseEntity.status(400).body(new API("Name Not found"));
}

@GetMapping("/find/{major}")
    public ResponseEntity findStudents(@PathVariable String major) {
      //  if(major.equals(null)){
        return ResponseEntity.status(200).body(studentService.getStudentsByMajor(major));
//}
       // return ResponseEntity.status(400).body(new API("Major not found"));

}}















