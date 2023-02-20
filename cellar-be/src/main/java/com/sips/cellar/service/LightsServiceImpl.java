package com.sips.cellar.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LightsServiceImpl implements LightsService {

    @Override
    public String turnOn() {
        String uri = "http://192.168.86.194/H";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
    @Override
    public String turnOff() {
        String uri = "http://192.168.86.194/L";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
}
