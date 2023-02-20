package com.sips.cellar.repo;

import com.sips.cellar.model.Beverage;
import com.sips.cellar.model.Maker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends JpaRepository<Maker, Long> {
}
