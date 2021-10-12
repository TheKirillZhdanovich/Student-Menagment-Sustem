package com.zhdanovich.StudentMenagmentSystem.controllers;

import com.zhdanovich.StudentMenagmentSystem.entity.Student;
import com.zhdanovich.StudentMenagmentSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentsController {

    private final StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public String showStudents(Model model) {
        model.addAttribute("students", studentService.show());
        return "students";
    }

    @GetMapping("/new")
    public String createStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping()
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create_student";
        }

        studentService.add(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(Model model, @PathVariable("id") Long id) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable("id") Long id, @Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_student";
        }

        studentService.update(id, student);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
