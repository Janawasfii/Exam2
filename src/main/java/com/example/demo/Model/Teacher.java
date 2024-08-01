package com.example.demo.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message="ID must not be null")
    private  int id;
    @NotNull(message="Name must not be empty")
    private String name;
    @NotNull(message="Salary must not be null")
    private int salary;

}
