package com.cnu.contestarchive.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
    @Value("${key.API_KEY}")
    private String apiKey;
}
