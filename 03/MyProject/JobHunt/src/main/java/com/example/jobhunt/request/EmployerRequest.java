package com.example.jobhunt.request;

import com.example.jobhunt.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class EmployerRequest {
    private String companyName;
    private Location location;
    private String email;
    public EmployerRequest(){
        location=Location.Hanoi;
    }

}
