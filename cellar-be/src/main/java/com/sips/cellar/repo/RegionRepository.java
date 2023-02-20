package com.sips.cellar.repo;

import com.sips.cellar.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    // define any custom queries or methods here
}