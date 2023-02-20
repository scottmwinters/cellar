package com.sips.cellar.repo;

import com.sips.cellar.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
    // define any custom queries or methods here
}
