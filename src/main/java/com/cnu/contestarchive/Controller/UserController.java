package com.cnu.contestarchive.Controller;

import com.cnu.contestarchive.Domain.User;
import com.cnu.contestarchive.Domain.UserValue;
import com.cnu.contestarchive.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            User user = new User();
            user.setId(id);
            user.setPassword(pw);
            userService.save(user);
            return new UserValue(true);
        } else if (userService.getUser(id).get().getPassword() != pw) {
            return new UserValue(false);
        }
        return new UserValue(false);
    }
}
