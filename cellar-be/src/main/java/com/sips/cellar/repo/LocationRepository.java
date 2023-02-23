package com.sips.cellar.repo;

import com.sips.cellar.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("SELECT DISTINCT i.location FROM InventoryItem i WHERE i.id IN (:inventoryItemIds)")
    List<Location> findLocationsByInventoryItemIds(@Param("inventoryItemIds") List<Long> inventoryItemIds);

}