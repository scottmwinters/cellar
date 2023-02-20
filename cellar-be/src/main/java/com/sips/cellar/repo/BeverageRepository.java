package com.sips.cellar.repo;

import com.sips.cellar.model.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeverageRepository extends JpaRepository<Beverage, Long> {
    // define any custom queries or methods here
}
