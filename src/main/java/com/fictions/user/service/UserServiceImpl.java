package com.fictions.user.service;

import com.fictions.user.model.UserModel;
import com.fictions.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserModel getUserByid(Integer userid) {
        return userRepo.findOne(userid);
    }
}
