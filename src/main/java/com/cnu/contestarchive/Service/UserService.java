package com.cnu.contestarchive.Service;

import com.cnu.contestarchive.Domain.User;
import com.cnu.contestarchive.Domain.UserMajorValue;
import com.cnu.contestarchive.Domain.UserValue;
import com.cnu.contestarchive.Repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public Optional<User> getUser(String id) {
        return userJpaRepository.findById(id);
    }

    public UserValue save(User user) {
        userJpaRepository.save(user);
        return new UserValue("none");
    }

    public UserMajorValue saveMajor(User user, String major) {
        userJpaRepository.save(User.builder()
                .id(user.getId())
                .password(user.getPassword())
                .major(major)
                .build());
        return new UserMajorValue(major);
    }

}
