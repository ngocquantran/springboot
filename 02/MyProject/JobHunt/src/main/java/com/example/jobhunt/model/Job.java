package com.example.jobhunt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {
    private String id;
    private String title;
    private String companyName;
    private String description;
    private Location location;
    private int minSalary;
    private int maxSalary;
    private String emailTo;

}
