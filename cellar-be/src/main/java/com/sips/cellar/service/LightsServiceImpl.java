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

    private String getHex(List<Location> locations) {
        int hex = locations.stream().mapToInt(loc -> (loc.getBit_shift() != null ? 1 << loc.getBit_shift() : 65536)).reduce(0x0000, (a, b) -> a | b);
        return hex < 65536 ? String.format("%04X", hex) : null;
    }

    @Override
    public List<Long> lightsOnForInventoryIds(List<Long> inventoryIds) {
        String hex = getHex(locationRepository.findLocationsByInventoryItemIds(inventoryIds));
        System.out.println("hex: " + hex);
        if(hex != null) {
            String uri = "http://192.168.86.199/?" + hex;
            System.out.println(uri);
            RestTemplate restTemplate = new RestTemplate();
            //TODO: handle the response from the controller. which also needs the controller to send a proper response.
            restTemplate.getForObject(uri, String.class);
            return inventoryIds;
        }
        return null;
    }
}
