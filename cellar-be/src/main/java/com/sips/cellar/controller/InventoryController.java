package com.sips.cellar.controller;

import com.sips.cellar.model.InventoryItem;
import com.sips.cellar.service.InventoryService;
import com.sips.cellar.service.LightsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;
    private final LightsService lightsService;

    public InventoryController(InventoryService inventoryService, LightsService lightsService) {
        this.inventoryService = inventoryService;
        this.lightsService = lightsService;
    }

    @PostMapping
    @CrossOrigin(origins = {"http://192.168.86.71:3000", "http://localhost:3000"})
    public InventoryItem create(@RequestBody InventoryItem inventoryItem) {
        System.out.println("adding new inventory item: " + inventoryItem);
//        return beverageService.create(beverageOld);
        return null;
    }

    @PostMapping("/lights")
    @CrossOrigin(origins = {"http://192.168.86.71:3000", "http://localhost:3000"})
    public List<Long> lightsOn(@RequestBody List<Long> inventoryItemIds) {
        System.out.println("turning lights on for" + inventoryItemIds);
        return lightsService.lightsOnForInventoryIds(inventoryItemIds);
    }
}
