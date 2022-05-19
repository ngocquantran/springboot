package com.example.jobhunt.controller;

import com.example.jobhunt.model.Employer;
import com.example.jobhunt.model.Location;
import com.example.jobhunt.repository.EmployerRepository;
import com.example.jobhunt.request.EmployerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class EmployeeController {
    @Autowired
    EmployerRepository employerRepo;

    @GetMapping(value = "/employers/add")
    public String showAddForm(Model model) {
        model.addAttribute("employerRequest", new EmployerRequest());
        model.addAttribute("locations", Location.values());
//        model.addAttribute("employerResult",null);
        return "addEmployer";
    }

    @PostMapping(value = "/employers/add")
    public String handleAddForm(@ModelAttribute EmployerRequest request, BindingResult bindingResult,Model model){
        if (!bindingResult.hasErrors()){
            System.out.println(request);
        }
        model.addAttribute("employerRequest", request);
        model.addAttribute("locations", Location.values());
        String id= UUID.randomUUID().toString();
        employerRepo.getEmployers().put(id,new Employer(id, request.getCompanyName(), request.getLocation(), request.getEmail()));

        return "addEmployer";
    }

}
