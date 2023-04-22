package com.example.pathfinder_fromscratch.domain.service;

import com.example.pathfinder_fromscratch.domain.entities.User;
import com.example.pathfinder_fromscratch.domain.entities.service.UserServiceModel;
import com.example.pathfinder_fromscratch.domain.enums.LevelEnum;
import com.example.pathfinder_fromscratch.domain.repositories.UserRepository;
import com.example.pathfinder_fromscratch.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        User user = modelMapper.map(userServiceModel, User.class);
        user.setLevel(LevelEnum.BEGINNER);
        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public User findCurrentLoginUserEntity() {
        return userRepository
                .findById(currentUser.getId())
                .orElse(null);
    }


}
