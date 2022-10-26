package com.cydeo.controller;


import com.cydeo.model.Student;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {


    @RequestMapping("/welcome")
    public String getHomePage(Model model){
        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");


        String subject = "Welcome to Cydeo";
        model.addAttribute("subject", subject);

        int studentId = new Random().nextInt();
        model.addAttribute("id", studentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(4);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        model.addAttribute("numbers", numbers);

        LocalDate dt = LocalDate.now();
        model.addAttribute("date", dt);

        Student student = new Student(1, "MIKE", "Smith");
        model.addAttribute("student", student);
        return "student/welcome";
    }


}
