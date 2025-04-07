package com.example.jobseekingsystem.Service;

import com.example.jobseekingsystem.Model.User;
import com.example.jobseekingsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // Get all Users
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    // Add a new User
    public void addUser(User user) {
        userRepository.save(user);
    }

    // Update a User
    public Boolean UpdateUser(Integer id, User user) {
        User oldUser = userRepository.getById(id);

        if (oldUser == null) {
            return false;
        }
        oldUser.setName(user.getName());
        if(oldUser.getEmail() != null){
            oldUser.setEmail(user.getEmail());
        }
        oldUser.setPassword(user.getPassword());
        oldUser.setRole(user.getRole());

        userRepository.save(oldUser);
        return true;
    }

    // Delete a User
    public Boolean deleteUser(Integer id) {
        User user = userRepository.getById(id);
        if (user == null) {
            return false;
        }
        userRepository.delete(user);
        return true;
    }

}
