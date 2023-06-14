package com.cnu.contestarchive.Controller;

import com.cnu.contestarchive.Domain.MoreValue;
import com.cnu.contestarchive.Domain.ValueOut;
import com.cnu.contestarchive.Service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApiController {

    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/search")
    public ValueOut search(@RequestParam("major") String major) throws IOException {
        int[] boardNoArray = apiService.boardNoReturn(major);
        String baseUrl = apiService.baseUrlReturn(major);
        return apiService.apiReturn(boardNoArray, baseUrl);
    }
    @GetMapping("/more")
    public MoreValue[] more(@RequestParam("major") String major, @RequestParam("section") String section) throws IOException {
        int[] boardNoArray = apiService.boardNoReturn(major);
        String baseUrl = apiService.baseUrlReturn(major);
        int sectionValue = apiService.sectionValueReturn(section);
        return apiService.moreApiReturn(sectionValue, boardNoArray, baseUrl);
    }

    @GetMapping("/board")
    public MoreValue board(@RequestParam("section") String section, @RequestParam("major") String major, @RequestParam("title") String title) throws IOException {
        int[] boardNoArray = apiService.boardNoReturn(major);
        String baseUrl = apiService.baseUrlReturn(major);
        int sectionValue = apiService.sectionValueReturn(section);
        return apiService.boardApiReturn(sectionValue, boardNoArray, title, baseUrl);
    }
}
