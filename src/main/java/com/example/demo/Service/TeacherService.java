package com.example.demo.Service;

import com.example.demo.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

public void addTeachers(Teacher teacher) {
        teachers.add(teacher);

}
public boolean updateTeachers(int id, Teacher teacher) {
        for(int i=0; i<teachers.size(); i++){
            if(teachers.get(i).getId() == id){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
}
public boolean deleteTeachers(int id) {
        for(int i=0; i<teachers.size(); i++){
            if(teachers.get(i).getId() == id){
                teachers.remove(i);
                return true;
            }
        }
        return false;
}
public Teacher getsTeacherByID(int id) {
        for(int i=0; i<teachers.size(); i++){
            if(teachers.get(i).getId() == id){
                return teachers.get(i);
            }
        }
        return null;
}
public ArrayList<Teacher> getTeacherBySalary(int salary) {
    ArrayList<Teacher> teacher1 = new ArrayList<>();
    for(int i=0; i<teachers.size(); i++){
        if(teachers.get(i).getSalary() >= salary){
                teacher1.add(teachers.get(i));
            }
        }
    return teacher1;

    }


}

