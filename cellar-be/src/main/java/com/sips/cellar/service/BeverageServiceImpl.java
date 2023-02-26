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
