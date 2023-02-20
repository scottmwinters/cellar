package com.sips.cellar.service;

import com.sips.cellar.model.Beverage;
import com.sips.cellar.repo.BeverageRepository;
import org.springframework.stereotype.Service;


@Service
public class BeverageServiceImpl implements BeverageService {

    private BeverageRepository beverageRepository;

    public BeverageServiceImpl(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    @Override
    public void addBeverage(Beverage beverage) {
        beverageRepository.save(beverage);
    }
}
//    private final BeveragesRepository_old beveragesRepositoryOld;
//
//    public BeverageServiceImpl(BeveragesRepository_old beveragesRepositoryOld) {
//        this.beveragesRepositoryOld = beveragesRepositoryOld;
//    }
//
//    @Override
//    public Beverage_old create(Beverage_old beverageOld) {
//        return beveragesRepositoryOld.save(beverageOld);
//    }
//
//    @Override
//    public List<Beverage_old> getBeverages() {
//        return beveragesRepositoryOld.findAllOrderByMakerAsc();
//    }
//
//    @Override
//    public List<Beverage_old> getBeveragesByType(String type) {
//        return beveragesRepositoryOld.findAllByTypeOrderByMakerAsc(type);
//    }
//
//    @Override
//    public void drinkOneById(Integer id) {
//        beveragesRepositoryOld.drinkOne(id);
//    }
//}
