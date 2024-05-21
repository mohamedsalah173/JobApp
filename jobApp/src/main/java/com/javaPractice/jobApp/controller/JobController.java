package com.javaPractice.jobApp.controller;

import com.javaPractice.jobApp.model.JobPost;
import com.javaPractice.jobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobPost jobPost;

    @Autowired
    private JobService service;


    @GetMapping({"/","/home"})
    public String home(){

//        System.out.println("Trying to resolve view: " + this.getClass().getClassLoader().getResource("/views/home.jsp").getPath());
        System.out.println("in home controller");
        return "home";
    }

    @RequestMapping("/addjob")
    public String addjob(){
        return "addjob";
    }

    @RequestMapping("/viewalljobs")
    public String viewAllJobs(Model model){
        List<JobPost> jobs = service.findAllJobs();
        model.addAttribute("jobPosts",jobs);
        return "viewalljobs";
    }

    @PostMapping("/handleForm")
    public String handleAddJobForm(JobPost jobPost,Model model) {
        model.addAttribute("jobPost", jobPost);
        service.addJob(jobPost);
        //System.out.println(jobPost);
        return "success";

    }

}
