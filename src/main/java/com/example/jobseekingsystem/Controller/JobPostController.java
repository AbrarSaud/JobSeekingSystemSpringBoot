package com.example.jobseekingsystem.Controller;

import com.example.jobseekingsystem.Api.ApiResponse;
import com.example.jobseekingsystem.Model.JobPost;
import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job-seeking/job-post")
@RequiredArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;


    // get All JobPost
    @GetMapping("/get")
    public ResponseEntity<?> getAllJobPost() {
        return ResponseEntity.ok(jobPostService.allJobPost());
    }

    // Add a new JobPost
    @PostMapping("/add")
    public ResponseEntity<?> addJobPost(@Valid @RequestBody JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("JobPost added !!"));
    }

    // Update a JobPost
    @PutMapping("/update/{id}")
    public ResponseEntity<?> getUpdateJobPost(@PathVariable Integer id, @RequestBody @Valid JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdate = jobPostService.updateJobPost(id,jobPost);
        if (isUpdate) {
            return ResponseEntity.ok(new ApiResponse("user updated !"));

        }
        return ResponseEntity.status(404).body(new ApiResponse("Not found!"));
    }
    // Delete a JobPost
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteJobPost(@PathVariable Integer id){
        Boolean isDelete = jobPostService.deleteJobPost(id);
        if(isDelete){
            return  ResponseEntity.status(200).body(new ApiResponse("JobPost delete"));
        }
        return  ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

}
