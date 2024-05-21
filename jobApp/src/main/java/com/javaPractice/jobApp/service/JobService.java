package com.javaPractice.jobApp.service;

import com.javaPractice.jobApp.model.JobPost;
import com.javaPractice.jobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){
        repo.add(jobPost);
    }

    public List<JobPost> findAllJobs(){
        return repo.findAll();
    }


}
