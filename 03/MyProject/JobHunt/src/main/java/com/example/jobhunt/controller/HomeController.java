package com.example.jobhunt.controller;

import com.example.jobhunt.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired EmployerRepository employerRepo;

    @GetMapping
    public String homePage(){
        return "index";
    }

    @GetMapping(value = "/employers")
    public String goToEmployers(Model model){
        model.addAttribute("employers",employerRepo.getEmployers());
        return "employers";
    }

}
