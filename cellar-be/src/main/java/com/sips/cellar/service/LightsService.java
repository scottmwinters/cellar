package com.sips.cellar.service;

import java.util.List;

public interface LightsService {

    List<Long> lightsOnForInventoryIds(List<Long> inventoryIds);
}
