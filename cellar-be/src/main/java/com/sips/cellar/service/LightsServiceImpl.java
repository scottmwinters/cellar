package com.sips.cellar.service;

import com.sips.cellar.model.Location;
import com.sips.cellar.repo.LocationRepository;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Service
public class LightsServiceImpl implements LightsService {

    private final LocationRepository locationRepository;

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
        if (hex != null) {
            String uri = "http://192.168.86.199/?" + hex;
            System.out.println(uri);
            WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector()).build();
            Mono<String> responseMono = webClient.get().uri(uri).retrieve().bodyToMono(String.class);
            responseMono.subscribe(result -> {
                //TODO: update this once the microcontroller returns
                // Handle success response from controller
            }, ex -> {
                // Handle failure response from controller
            });
            return inventoryIds;
        }
        return null;
    }
}
