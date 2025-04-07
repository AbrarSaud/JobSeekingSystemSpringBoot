package com.example.jobseekingsystem.Service;


import com.example.jobseekingsystem.Model.JobApplication;
import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Repository.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    public final JobApplicationRepository jobApplicationRepository ;


    // Get all JobApplication
    public List<JobApplication> allJobApplication() {
        return jobApplicationRepository.findAll();
    }

    // Add a new JobApplication
    public void addJobApplication(JobApplication jobApplication) {
        jobApplicationRepository.save(jobApplication);
    }

    // Delete a JobApplication
    public Boolean deleteJobApplication(Integer id) {
        JobApplication jobApplication = jobApplicationRepository.getById(id);
        if (jobApplication == null) {
            return false;
        }
        jobApplicationRepository.delete(jobApplication);
        return true;
    }

}
