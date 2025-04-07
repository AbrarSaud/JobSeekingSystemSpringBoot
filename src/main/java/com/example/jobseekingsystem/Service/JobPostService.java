package com.example.jobseekingsystem.Service;


import com.example.jobseekingsystem.Model.JobPost;
import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;

    // Get all JobPost
    public List<JobPost> allJobPost() {
        return jobPostRepository.findAll();
    }

    // Add a new JobPost
    public void addJobPost(JobPost jobPost) {
        jobPostRepository.save(jobPost);
    }

    // Update a JobPost
    public Boolean updateJobPost(Integer id, JobPost jobPost) {
        JobPost oldJobPost = jobPostRepository.getById(id);

        if (oldJobPost == null) {
            return false;
        }
        oldJobPost.setTitle(jobPost.getTitle());
        oldJobPost.setDescription(jobPost.getDescription());
        oldJobPost.setLocation(jobPost.getLocation());
        oldJobPost.setSalary(jobPost.getSalary());
        oldJobPost.setPostingDate(jobPost.getPostingDate());

        jobPostRepository.save(oldJobPost);
        return true;
    }

    // Delete a JobPost
    public Boolean deleteJobPost(Integer id) {
        JobPost jobPost = jobPostRepository.getById(id);
        if (jobPost == null) {
            return false;
        }
        jobPostRepository.delete(jobPost);
        return true;
    }


}
