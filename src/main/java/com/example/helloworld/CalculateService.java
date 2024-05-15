package com.example.helloworld;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {
    public CalculateService(){

    }

    @PostConstruct
    public void init(){
        // initialize the service
    }
}
