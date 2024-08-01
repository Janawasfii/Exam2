package com.example.demo.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Student {



  @NotNull(message="ID must not be null")
    private  int id;
  @NotNull(message="Name must not be empty")
    private String name;
  @NotNull(message="Age must not be null")
    private int age;
  @NotEmpty(message="Major should not be empty")
    private String major;
}
