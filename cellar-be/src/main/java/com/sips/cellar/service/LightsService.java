package com.sips.cellar.service;

import java.util.List;

public interface LightsService {

    String turnOn();
    String turnOff();
    void turnt();

    void lightsOnForInventoryIds(List<Long> inventoryIds);
}
