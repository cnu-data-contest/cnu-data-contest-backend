package com.cnu.contestarchive.Controller;

import com.cnu.contestarchive.Domain.User;
import com.cnu.contestarchive.Domain.UserMajorValue;
import com.cnu.contestarchive.Domain.UserValue;
import com.cnu.contestarchive.Dto.UserRequestDto;
import com.cnu.contestarchive.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public UserValue login(@RequestBody UserRequestDto requestDto) {
        return userService.save(requestDto);
    }

    @PostMapping("/major")
    public UserMajorValue majorAdd(@RequestBody UserRequestDto requestDto) {
        return userService.saveMajor(requestDto);
    }

    @GetMapping("/major")
    public UserMajorValue getMajor(@RequestParam("userId") String id) {
        return userService.getMajor(id);
    }


    @GetMapping("/favoriteMajor")
    public UserMajorValue getFavoriteMajor(@RequestParam("userId") String id) {
        return userService.getFavoriteMajor(id);
    }

}
