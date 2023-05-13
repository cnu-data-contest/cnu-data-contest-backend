package com.cnu.contestarchive.Controller;

import com.cnu.contestarchive.Domain.ValueOut;
import com.cnu.contestarchive.Service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ApiController {

    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/search")
    public ValueOut search(@RequestParam("university") String university, @RequestParam("major") String major) throws IOException {

        return apiService.apiReturn(university, 305);
    }
}
