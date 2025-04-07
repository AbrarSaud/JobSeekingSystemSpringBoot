package com.example.jobseekingsystem.Controller;


import com.example.jobseekingsystem.Api.ApiResponse;
import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job-seeking/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    // get All Users
    @GetMapping("/get")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.allUsers());
    }

    // Add a new User
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added !!"));
    }

    // Update a User
    @PutMapping("/update/{id}")
    public ResponseEntity<?> getUpdateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdate = userService.UpdateUser(id, user);
        if (isUpdate) {
            return ResponseEntity.ok(new ApiResponse("user updated !"));

        }
        return ResponseEntity.status(404).body(new ApiResponse("Not found!"));
    }

    // Delete a User
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteUser(@PathVariable Integer id){
        Boolean isDelete = userService.deleteUser(id);
        if(isDelete){
            return  ResponseEntity.status(200).body(new ApiResponse("user delete"));
        }
        return  ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

}
