package com.cnu.contestarchive.Controller;

import com.cnu.contestarchive.Domain.User;
import com.cnu.contestarchive.Domain.UserMajorValue;
import com.cnu.contestarchive.Domain.UserValue;
import com.cnu.contestarchive.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public UserValue login(@RequestParam("userId") String id, @RequestParam("userPw") String pw) {
        if (!userService.getUser(id).isPresent()) {
            return userService.save(User.builder()
                    .id(id)
                    .password(pw)
                    .build());
        } else if (!userService.getUser(id).get().getPassword().equals(pw)) {
            return new UserValue("false");
        }
        return new UserValue("true");
    }

    @PostMapping("/major")
    public UserMajorValue majorAdd(@RequestParam("id") String id, @RequestParam("major") String major) {
        Optional<User> user = userService.getUser(id);
        UserMajorValue userMajorValue = null;
        if (user.isPresent()) {
            userMajorValue = userService.saveMajor(user.get(), major);
        }
        return userMajorValue;
    }

}
