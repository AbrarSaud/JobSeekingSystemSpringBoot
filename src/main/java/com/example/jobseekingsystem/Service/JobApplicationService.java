package com.example.jobseekingsystem.Service;


import com.example.jobseekingsystem.Model.JobApplication;
import com.example.jobseekingsystem.Model.JobPost;
import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Repository.JobApplicationRepository;
import com.example.jobseekingsystem.Repository.JobPostRepository;
import com.example.jobseekingsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;


    // Get all JobApplication
    public List<JobApplication> allJobApplication() {
        return jobApplicationRepository.findAll();
    }

    // Add a new JobApplication
    public void addJobApplication(JobApplication jobApplication) {
        User user = userRepository.getById(jobApplication.getUserId());
        JobPost jobPost = jobPostRepository.getById(jobApplication.getJobPostId());
        if (user != null && jobPost != null) {
            jobApplicationRepository.save(jobApplication);
        }
    }

    // Delete a JobApplication
    public Boolean deleteJobApplication(Integer id) {
        JobApplication jobApplication = jobApplicationRepository.getById(id);
        User user = userRepository.getById(jobApplication.getUserId());
        JobPost jobPost = jobPostRepository.getById(jobApplication.getJobPostId());
        if (jobApplication == null && user == null && jobPost == null) {
            return false;
        }
        jobApplicationRepository.delete(jobApplication);
        return true;
    }

}
