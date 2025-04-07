package com.example.jobseekingsystem.Controller;


import com.example.jobseekingsystem.Api.ApiResponse;
import com.example.jobseekingsystem.Model.JobApplication;
import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job-seeking/job-application")
@RequiredArgsConstructor
public class JobApplicationController {
    public final JobApplicationService jobApplicationService;


    // get All JobApplication
    @GetMapping("/get")
    public ResponseEntity<?> getAllJobApplications() {
        return ResponseEntity.ok(jobApplicationService.allJobApplication());
    }

    // Add a new JobApplication
    @PostMapping("/add")
    public ResponseEntity<?> addJobApplication(@Valid @RequestBody JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        jobApplicationService.addJobApplication(jobApplication);
        return ResponseEntity.status(200).body(new ApiResponse("JobApplication added !!"));
    }

    // Delete a JobApplication
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteJobApplication(@PathVariable Integer id){
        Boolean isDelete = jobApplicationService.deleteJobApplication(id);
        if(isDelete){
            return  ResponseEntity.status(200).body(new ApiResponse("JobApplication delete"));
        }
        return  ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }
}
