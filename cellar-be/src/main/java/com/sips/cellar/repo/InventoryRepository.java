package com.sips.cellar.repo;

import com.sips.cellar.model.Beverage;
import com.sips.cellar.model.InventoryItem;
import com.sips.cellar.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    List<InventoryItem> findByLocation(Location location);
    List<InventoryItem> findByBeverage(Beverage beverage);

    @Query("SELECT i FROM InventoryItem i JOIN FETCH i.beverage b WHERE b.style.type = :type")
    List<InventoryItem> findByBeverageType(@Param("type") String typeName);

    // define any custom queries or methods here
}