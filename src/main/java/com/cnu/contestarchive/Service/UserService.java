package com.cnu.contestarchive.Service;

import com.cnu.contestarchive.Domain.User;
import com.cnu.contestarchive.Domain.UserMajorValue;
import com.cnu.contestarchive.Domain.UserValue;
import com.cnu.contestarchive.Dto.UserRequestDto;
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

    public UserValue save(UserRequestDto userRequestDto) {
        Optional<User> user = userJpaRepository.findById(userRequestDto.getUserId());
        if (!user.isPresent()){
            userJpaRepository.save(User.builder()
                    .id(userRequestDto.getUserId())
                    .password(userRequestDto.getUserPw())
                    .build());
            return new UserValue("none");
        } else if (!userJpaRepository.findById(userRequestDto.getUserId()).get().getPassword().equals(userRequestDto.getUserPw())) {
            return new UserValue("false");
        }
        return new UserValue("true");
    }

    public UserMajorValue saveMajor(UserRequestDto userRequestDto) {
        Optional<User> user = userJpaRepository.findById(userRequestDto.getUserId());
        UserMajorValue userMajorValue = null;
        if (user.isPresent()) {
            userJpaRepository.save(User.builder()
                    .id(user.get().getId())
                    .password(user.get().getPassword())
                    .major(userRequestDto.getMajor())
                    .build());
            userMajorValue = new UserMajorValue(userRequestDto.getMajor());
        }
        return userMajorValue;
    }
}
