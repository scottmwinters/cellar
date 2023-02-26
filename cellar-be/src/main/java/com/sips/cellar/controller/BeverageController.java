package com.sips.cellar.controller;

import com.sips.cellar.model.*;
import com.sips.cellar.repo.BeverageRepository;
import com.sips.cellar.repo.InventoryRepository;
import com.sips.cellar.repo.LocationRepository;
import com.sips.cellar.service.BeverageService;
import com.sips.cellar.service.InventoryService;
import com.sips.cellar.service.LightsService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/cellar")
public class BeverageController {

    private final BeverageService beverageService;
    private final InventoryService inventoryService;
    private final LightsService lightsService;

    public BeverageController(BeverageService beverageService, InventoryService inventoryService, LightsService lightsService) {
        this.beverageService = beverageService;
        this.inventoryService = inventoryService;
        this.lightsService = lightsService;
    }

    @GetMapping("/beverages")
    @CrossOrigin(origins = {"http://192.168.86.71:3000", "http://localhost:3000"})
    //TODO: use DTOs, probably
    public List<InventoryItem> getInventory(@RequestParam String type) {

        return inventoryService.getInventoryByType(type);
    }

    @PostMapping("/drink")
    @CrossOrigin(origins = {"http://192.168.86.71:3000", "http://localhost:3000"})
    public void drink(@RequestBody int beverageId) {

        System.out.println("removing 1 beverage: " + beverageId);
        //TODO: inventoryService.drinkOneById(beverageId);

    }

}
