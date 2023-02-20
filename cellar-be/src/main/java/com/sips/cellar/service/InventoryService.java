package com.sips.cellar.service;

import com.sips.cellar.model.InventoryItem;

import java.util.List;

public interface InventoryService {

    List<InventoryItem> getInventoryByType(String type);

    void importAllTheBeers();
}
