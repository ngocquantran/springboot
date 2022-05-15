package com.example.jobhunt.service;

import com.example.jobhunt.dto.JobRequest;
import com.example.jobhunt.model.Job;
import com.example.jobhunt.model.Location;
import lombok.Builder;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobService {
    public ConcurrentHashMap<String, Job> getAllJobs() {
        ConcurrentHashMap<String, Job> jobs = new ConcurrentHashMap<>();
        String id1 = UUID.randomUUID().toString();
        jobs.put(id1, new Job(id1, "Sr Backend Dev (Java/Spring/SQL)~$1600", "BlueBottle Digital Việt Nam", "Perform development on Java open source platform", Location.Hanoi, 1000, 1600, ("bluebottle@gmail.com")));
        String id2 = UUID.randomUUID().toString();
        jobs.put(id2, new Job(id2, "02 Web Developer (Java, Javascript, SQL)", "Shinhan DS Vietnam", "Collaborate closely with clients and IT professionals in analysis, development, and testing", Location.Hochiminh, 500, 2500, ("shinhan@gmail.com")));
        String id3 = UUID.randomUUID().toString();
        jobs.put(id3, new Job(id3, "Lead Backend Engineer (Java/C#)", "Gear Inc.", "Implement new game functions on the server-side.", Location.Danang, 2000, 3000, ("gear@gmail.com")));
        String id4 = UUID.randomUUID().toString();
        jobs.put(id4, new Job(id4, "10x JAVA Developer English Pricing", "RnD4U", "Communicating, gathering and formalizing customer requirements", Location.Hochiminh, 700, 2300, ("rnd4u@gmail.com")));
        String id5 = UUID.randomUUID().toString();
        jobs.put(id5, new Job(id5, "Remote Software Engineer (.Net or Java)", "Blue Lion", "You will be involved in the entire product development life cycle, and in the continuous\n" +
                "improvement activities as we evolve our DevOps culture. ", Location.Haiphong, 1500, 2500, ("bluelion@gmail.com")));
        String id6 = UUID.randomUUID().toString();
        jobs.put(id6, new Job(id6, "[Urgent] - 03 Java Developer (J2EE, MVC)", "Dai-ichi Life Việt Nam", "Analyze the business specs then prepare technical specs and develop the new systems or enhance existing system for supporting business needs.", Location.Hochiminh, 1500, 1800, ("daichi@gmail.com")));


        return jobs;
    }

    public Job addNewJob(ConcurrentHashMap<String, Job> jobs, JobRequest jobRequest) {
        String id = UUID.randomUUID().toString();
        Job newJob = Job.builder()
                .id(id)
                .companyName(jobRequest.companyName())
                .title(jobRequest.title())
                .description(jobRequest.description())
                .location(jobRequest.location())
                .minSalary(jobRequest.minSalary())
                .maxSalary(jobRequest.maxSalary())
                .emailTo(jobRequest.emailTo()).build();
        jobs.put(id, newJob);
        return newJob;
    }

    public Job editJob(ConcurrentHashMap<String, Job> jobs, String id, JobRequest jobRequest) {
        Job editJob = Job.builder()
                .id(id)
                .companyName(jobRequest.companyName())
                .title(jobRequest.title())
                .description(jobRequest.description())
                .location(jobRequest.location())
                .minSalary(jobRequest.minSalary())
                .maxSalary(jobRequest.maxSalary())
                .emailTo(jobRequest.emailTo()).build();
        jobs.put(id, editJob);
        return editJob;
    }

    public Job deleteJob(ConcurrentHashMap<String, Job> jobs, String id) {
        Job removedJob = jobs.get(id);
        jobs.remove(id);
        return removedJob;
    }

    public List<Job> sortJobByLocation(ConcurrentHashMap<String, Job> jobs) {
        List<Map.Entry<String, Job>> list = new ArrayList<>(jobs.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Job>>() {
            @Override
            public int compare(Map.Entry<String, Job> o1, Map.Entry<String, Job> o2) {
                return o1.getValue().getLocation().toString().compareTo(o2.getValue().getLocation().toString());
            }
        });
        List<Job> sortJobs = new ArrayList<>();
        for (Map.Entry<String, Job> n : list) {
            sortJobs.add(n.getValue());
        }
        return sortJobs;
    }

    public List<Job> filterBySalary(ConcurrentHashMap<String, Job> jobs, int salary) {
        List<Job> filteredList = jobs.values().stream()
                .filter(job -> job.getMinSalary() <= salary)
                .filter(job -> job.getMaxSalary() >= salary)
                .collect(Collectors.toList());
        return filteredList;
    }

    public List<Job> filterByKeyWord(ConcurrentHashMap<String, Job> jobs, String keyword) {
        List<Job> filteredList = jobs.values().stream()
                .filter(job -> job.getTitle().toLowerCase().contains(keyword.toLowerCase()) || job.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        return filteredList;
    }

    public List<Job> filterByLocationAndKeyWord(ConcurrentHashMap<String, Job> jobs, String keyword, String location) {
        List<Job> filteredList = jobs.values().stream()
                .filter(job -> job.getTitle().toLowerCase().contains(keyword.toLowerCase()) || job.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .filter(job -> job.getLocation().toString().toLowerCase().equals(location.toLowerCase().replaceAll("_", " ")))
                .collect(Collectors.toList());
        return filteredList;
    }


}
