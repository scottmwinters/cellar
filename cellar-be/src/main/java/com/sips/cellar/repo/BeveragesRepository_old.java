package com.sips.cellar.repo;

import com.sips.cellar.model.Beverage_old;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BeveragesRepository_old extends JpaRepository<Beverage_old, Integer> {
    @Query("select b from Beverage_old b where b.type = ?1 order by b.maker")
    List<Beverage_old> findAllByTypeOrderByMakerAsc(String type);

    @Query("select b from Beverage_old b")
    List<Beverage_old> findAllOrderByMakerAsc();

    @Transactional
    @Modifying
    @Query("update Beverage_old b set b.quantity = b.quantity - 1 where b.id = ?1")
    void drinkOne(Integer id);
}
