package com.sips.cellar.repo;

import com.sips.cellar.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    // define any custom queries or methods here
}