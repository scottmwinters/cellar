package com.sips.cellar.repo;

import com.sips.cellar.model.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Long> {
    // define any custom queries or methods here
}
