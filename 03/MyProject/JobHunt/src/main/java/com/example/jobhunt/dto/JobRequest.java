package com.example.jobhunt.dto;

import com.example.jobhunt.model.Location;

public record JobRequest(String title,
        String companyName,
        String description,
        Location location,
        int minSalary,
        int maxSalary,
        String emailTo){}
