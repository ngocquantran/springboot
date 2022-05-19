package com.example.jobhunt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employer {
    private String id;
    private String companyName;
    private Location location;
    private String email;
}
