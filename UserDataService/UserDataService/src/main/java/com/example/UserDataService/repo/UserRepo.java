package com.example.UserDataService.repo;

import com.example.UserDataService.entity.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserData,String> {
}
