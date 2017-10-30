package com.fictions.user.repository;

import com.fictions.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Integer> {

    UserModel findById(Integer id);
}
