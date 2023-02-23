package com.sips.cellar.service;

import com.sips.cellar.model.Location;
import com.sips.cellar.repo.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class LightsServiceImpl implements LightsService {

    private LocationRepository locationRepository;

    public LightsServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

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

    @Override
    public void turnt() {
        String uri = "http://192.168.86.199/?0002";
        System.out.println(uri);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(uri, String.class);
//        return result;
    }

    private String getHex(List<Location> locations) {
        int hex = locations.stream().mapToInt(loc -> (1 << loc.getBit_shift())).reduce(0x0000, (a, b) -> a | b);
        return String.format("%04X", hex);
    }

    @Override
    public void lightsOnForInventoryIds(List<Long> inventoryIds) {
        String hex = getHex(locationRepository.findLocationsByInventoryItemIds(inventoryIds));
        String uri = "http://192.168.86.199/?" + hex;
        System.out.println(uri);
        RestTemplate restTemplate = new RestTemplate();
        //TODO: handle the response from the controller. which also needs the controller to send a proper response.
        restTemplate.getForObject(uri, String.class);
    }
}
