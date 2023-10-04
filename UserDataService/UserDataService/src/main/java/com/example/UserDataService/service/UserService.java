package com.example.UserDataService.service;

import com.example.UserDataService.dto.UserRequest;
import com.example.UserDataService.entity.UserData;
import com.example.UserDataService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.rmi.server.LogStream.log;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public String saveUserData(UserRequest userRequest)
    {
        UserData userData=new UserData();
        userData.setName(userRequest.getName());
        userData.setPassword(userRequest.getPassword());
        userData.setEmail(userRequest.getEmail());
        userRepo.save(userData);
        return "User data successfully saved";
    }

    public List<UserData> getAllUserData()
    {
        return userRepo.findAll();
    }

    public Optional<UserData> getUserById(String userId)
    {
        return userRepo.findById(userId);
    }

    public Optional<UserData> updateDetails(UserRequest userRequest, String userId) {
        Optional<UserData> userData= userRepo.findById(userId);
        userData.stream().map(b -> {
            if(b.getUserId().equals(userId))
            {
                log("Check");
                b.setEmail(userRequest.getEmail());
                b.setPassword(userRequest.getPassword());
                b.setName(userRequest.getName());
            }
            userRepo.save(b);
            return b;
        }).collect(Collectors.toList());
        return userRepo.findById(userId);
    }
}
