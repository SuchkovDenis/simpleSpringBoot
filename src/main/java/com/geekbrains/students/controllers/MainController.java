package com.geekbrains.students.controllers;

import com.geekbrains.students.entities.Student;
import com.geekbrains.students.servises.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("student", new Student());
        return "index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        studentService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "id") Long id) {
        Student student = studentService.get(id);
        model.addAttribute("student", student);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Model model, @ModelAttribute("student") Student student) {
        studentService.update(student);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("student") Student student) {
        studentService.add(student);
        return "redirect:/";
    }
}
