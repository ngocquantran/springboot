package com.example.jobhunt.controller;

import com.example.jobhunt.dto.JobRequest;
import com.example.jobhunt.model.Job;
import com.example.jobhunt.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/job")
public class JobController {
    JobService service = new JobService();
    ConcurrentHashMap<String, Job> jobs = service.getAllJobs();

    @GetMapping
    public List<Job> getJobs() {
        return jobs.values().stream().toList();
    }

    @PostMapping
    public Job addJob(@RequestBody JobRequest jobRequest) {
        Job newJob = service.addNewJob(jobs, jobRequest);
        return newJob;
    }

    @PutMapping(value = "/{id}")
    public Job editJob(@PathVariable String id, @RequestBody JobRequest jobRequest) {
        Job editJob = service.editJob(jobs, id, jobRequest);
        return editJob;
    }

    @DeleteMapping(value = "/{id}")
    public Job deleteJob(@PathVariable String id) {
        Job removedJob = service.deleteJob(jobs, id);
        return removedJob;
    }

    @GetMapping("/sortbylocation")
    public List<Job> sortJobByLocation() {
        List<Job> sortedJobs = service.sortJobByLocation(jobs);
        return sortedJobs;
    }

    @GetMapping(value = "/salary/{salary}")
    public List<Job> getJobBySalary(@PathVariable int salary) {
        List<Job> list = service.filterBySalary(jobs, salary);
        return list;
    }

    @GetMapping(value = "/keyword/{keyword}")
    public List<Job> getJobByKeyword(@PathVariable String keyword) {
        List<Job> list = service.filterByKeyWord(jobs, keyword);
        return list;
    }

    @GetMapping(value = "/query")
    public List<Job> getJobByLocationAndKey(@RequestParam("location") String location, @RequestParam("keyword") String keyword) {
        List<Job> list = service.filterByLocationAndKeyWord(jobs, keyword, location);
        return list;
    }


}
