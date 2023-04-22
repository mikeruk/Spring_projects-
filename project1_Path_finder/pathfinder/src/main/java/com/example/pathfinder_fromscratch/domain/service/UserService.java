package com.example.pathfinder_fromscratch.domain.service;

import com.example.pathfinder_fromscratch.domain.entities.User;
import com.example.pathfinder_fromscratch.domain.entities.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);


    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

    UserServiceModel findById(Long id);

    User findCurrentLoginUserEntity();


}
