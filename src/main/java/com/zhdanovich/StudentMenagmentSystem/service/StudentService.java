package com.zhdanovich.StudentMenagmentSystem.service;

import com.zhdanovich.StudentMenagmentSystem.entity.Student;
import com.zhdanovich.StudentMenagmentSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> show(){
        return studentRepository.findAll();
    }

    public void add(Student student) {
        studentRepository.save(student);
    }

    public void update(Long id, Student student){
        Student updatedStudent = studentRepository.findStudentById(id);

        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setSecondName(student.getSecondName());
        updatedStudent.setEmail(student.getEmail());

        studentRepository.save(updatedStudent);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findStudentById(id);
    }
}
