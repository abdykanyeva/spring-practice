package com.cydeo.controller;


import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){

        //method Model interface
        model.addAttribute("name", "Cydeo");
        String subject = "Spring Boot";
        model.addAttribute("subject", subject);

        Student student = new Student(1, "Mike", "Smith");
        model.addAttribute("student", student);

        return "student/welcome";
    }

    @RequestMapping("/mentor")
    public String addMentor(Model model){

        model.addAttribute("mentor", DataGenerator.mentorList);
        return "/mentor/mentor-table";
    }
}
