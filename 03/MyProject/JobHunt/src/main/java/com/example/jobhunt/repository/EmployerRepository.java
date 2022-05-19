package com.example.jobhunt.repository;

import com.example.jobhunt.model.Employer;
import com.example.jobhunt.model.Location;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
@Repository
public class EmployerRepository {
    private ConcurrentHashMap<String, Employer> employers;

    public EmployerRepository() {
        employers=new ConcurrentHashMap<>();
        String id1=UUID.randomUUID().toString();
        employers.put(id1,new Employer(id1,"Persol Process & Technology Việt Nam", Location.Hochiminh,"persol@gmail.com"));
        String id2=UUID.randomUUID().toString();
        employers.put(id2,new Employer(id2,"M_Service (MoMo)",Location.Danang,"momo@gmail.com"));
        String id3=UUID.randomUUID().toString();
        employers.put(id3,new Employer(id3,"BlueBottle Digital Việt Nam",Location.Hanoi,"blue@gmail.com"));

    }
    public ConcurrentHashMap<String, Employer> getEmployers(){
        return employers;
    }
}
