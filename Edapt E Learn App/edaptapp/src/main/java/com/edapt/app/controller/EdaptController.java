package com.edapt.app.controller;

import com.edapt.app.dto.EdaptDto;
import com.edapt.app.service.EdaptService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
public class EdaptController {

    private EdaptService edaptService;

    // handler method to handle new student request
    @GetMapping("/students/new")
    public String newStudent(Model model) {
        // student model object to store student form data
        EdaptDto edaptDto = new EdaptDto();
        model.addAttribute("student", edaptDto);
        return "create_student";
    }

    // Handler method to handle view student request
    @GetMapping("/students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId,
                              Model model){
        EdaptDto student = edaptService.getStudentById(studentId);
        model.addAttribute("student", student);
        return "view_student";
    }
    // handler method to handle list students request
    @GetMapping({"/students"})
    public String listStudents(Model model) {
        List<EdaptDto> edaptDtos = edaptService.getAllStudents();
        model.addAttribute("students", edaptDtos);
        return "students";
    }

    // handler method to handle save student from submit request
    @PostMapping("/students")
    public String saveStudents(@Valid @ModelAttribute("student") EdaptDto student,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "create_student";
        }
        edaptService.createStudent(student);
        return "redirect:/students";
    }

    // handler method to handle edit student request
    @GetMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                @Valid @ModelAttribute("student") EdaptDto student,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "edit_student";
        }
        student.setId(studentId);
        edaptService.updateStudent(student);
        return "redirect:/students";
    }

    // Handler method to handle delete student request
    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId) {
        edaptService.deleteStudent(studentId);
        return "redirect:/students";
    }
}
