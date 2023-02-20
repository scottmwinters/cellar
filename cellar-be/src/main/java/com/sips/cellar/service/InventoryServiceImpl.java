package com.sips.cellar.service;

import com.sips.cellar.model.*;
import com.sips.cellar.repo.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final BeverageRepository beverageRepository;
    private final MakerRepository makerRepository;
    private final NameRepository nameRepository;
    private final LocationRepository locationRepository;
    private final SizeRepository sizeRepository;
    private final StyleRepository styleRepository;
    private final VariantRepository variantRepository;
    private final RegionRepository regionRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository, BeverageRepository beverageRepository, MakerRepository makerRepository, NameRepository nameRepository, LocationRepository locationRepository, SizeRepository sizeRepository, StyleRepository styleRepository, VariantRepository variantRepository, RegionRepository regionRepository) {
        this.inventoryRepository = inventoryRepository;
        this.beverageRepository = beverageRepository;
        this.makerRepository = makerRepository;
        this.nameRepository = nameRepository;
        this.locationRepository = locationRepository;
        this.sizeRepository = sizeRepository;
        this.styleRepository = styleRepository;
        this.variantRepository = variantRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    public List<InventoryItem> getInventoryByType(String type) {
        System.out.println(inventoryRepository.findByBeverageType(type));
        return inventoryRepository.findByBeverageType(type);
    }

    @Override
    public void importAllTheBeers() {
        Map<String, Region> regions = regionRepository.findAll().stream().collect(Collectors.toMap(Region::getName, Function.identity()));
        Map<String, Name> names = nameRepository.findAll().stream().collect(Collectors.toMap(Name::getName, Function.identity()));
        Map<String, Maker> makers = makerRepository.findAll().stream().collect(Collectors.toMap(Maker::getName, Function.identity()));
        Map<String, Style> styles = styleRepository.findAll().stream().collect(Collectors.toMap(Style::getSubStyle, Function.identity()));
        Map<String, Location> locations = locationRepository.findAll().stream().collect(Collectors.toMap(Location::getName, Function.identity()));
        Map<Double, Size> sizes = sizeRepository.findAll().stream().collect(Collectors.toMap(Size::getAmount, Function.identity()));
        Map<String, Variant> variants = variantRepository.findAll().stream().collect(Collectors.toMap(Variant::getName, Function.identity()));
//        Map<Long, Name> namesById = beverageRepository.findAll().stream().collect(Collectors.toMap(Name::getId, Function.identity()));
        Map<String, Beverage> beverages = beverageRepository.findAll().stream().collect(Collectors.toMap(s -> s.getName().getName() + s.getSize().getAmount() + s.getVariant() + s.getVintage(), Function.identity()));

        System.out.println(names.entrySet());
//        List<Beverage> beverages = new ArrayList<>();
        //public Beverage(Name name, Maker maker, Style style, Double abv, Variant variant, Size size, Integer vintage, Region region) {
//        beverages.add(new Beverage(names.get("Bon Bon Cerise"),makers.get("Avery"),styles.get("BBA Imperial Stout"),14.6, null,sizes.get(12.0),2019, regions.get("CO")));
        List<InventoryItem> inventoryItems = new ArrayList<>();
        Date date = new Date(System.currentTimeMillis());
        inventoryItems.add(new InventoryItem(beverages.get("One Ping Only12.0null2022"), locations.get("S1"),3, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Vanilla Bean16.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("A Brillaintly Deformed Corpse Neverless25.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Because You Can See What I Cannot25.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("End of Plagues16.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Griddle Donut12.0null2021"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Skillet Donut16.0null2021"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("What if theres Another World16.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Fresh16.0null2022"), locations.get("S1"),3, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Collaboration Without Representation16.0null2021"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Eclipse25.0George Dickle Barrel2021"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Happium12.0null2021"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Breakfast Stout12.0null2020"), locations.get("S1"),4, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("CBS25.4.0null2019"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("CBS12.0null2019"), locations.get("S1"),11, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0Espresso2021"), locations.get("S1"),5, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0Espresso2020"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0Hazelnut2022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0Maple Mackinaw Fudge2022"), locations.get("S1"),4, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0Maple Mackinaw Fudge2020"), locations.get("S1"),3, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0null2019"), locations.get("S1"),4, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0null2020"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0null2018"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0Chocolate Cherry2022"), locations.get("S1"),3, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Bourbon County25.0Cassia Bark2021"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Bourbon County25.0Coffee Maple Syrup2020"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("10W-4016.0Chai2021"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("10W-4016.0Chocolate Creme Brulee2021"), locations.get("S1"),3, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("10W-4016.0Vietnamese Iced Coffee2021"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("10W-4016.0BBA2021"), locations.get("S1"),5, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("10W-4016.0Coconut Chocolate Bar2022"), locations.get("S1"),5, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("10W-4016.0Gingerbread Hot Chocolate2022"), locations.get("S1"),6, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("20W-5025.0null2021"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("20W-5025.0Cafe De Ole2021"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("20W-5025.0Coffee & Marshmallow2021"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("20W-5016.0Mint Chocolate Cookie2022"), locations.get("S1"),10, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("20W-5025.0Sugar Cookie2021"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Cold Mountain25.0BBA2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Cold Mountain16.0Chocolate Hazelnut2022"), locations.get("S1"),6, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Cold Mountain16.0Imperial2022"), locations.get("S1"),4, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Cold Mountain12.0null2022"), locations.get("S1"),36, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Thunderstruck Coffee12.0null2022"), locations.get("S1"),6, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Double Chocolate Brownie16.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Champion Ground12.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("IPA12.0null2019"), locations.get("S1"),5, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Galactic Cowboy16.0null2020"), locations.get("S1"),3, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Asymetrical Simulation16.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("BA Venloac12.0null2022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Christmas Land12.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Escape From Planet Doom12.0null2023"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Island of Lost Souls12.0null2023"), locations.get("S1"),3, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("More Than Metal12.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.02019 Oatmeal Cookie2019"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.02020 Reserve 2 - Scotch Marshmallow2020"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.02021 Reserve 2 - Vanilla2021"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.02022 Reserve 2 - Stroopwaffle2022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.0Chocolate Cherry2018"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.02022 Reserve 3 - Marshmallow2022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.0null2021"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Netflix And Dill16.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Curate16.0null2022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Dreams of a Distant Past375.0null2021"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("On Becoming Remants375.0Speyside Scotch2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Stouts all the Way Down375.0Costa Rica Vanilla Chronicle2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Supply and the Damned375.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Twelth Labor375.04 Year2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Twelth Labor375.0Darkest Day2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Twelth Labor375.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Ten Fiddy12.0null2019"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Brownie Batter375.0Blend 3 - Loaded French Toast2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Brownie Batter375.0Blend 3 - Vanilla Overload2021"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Brownie Batter375.0Medionoche2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Brownie Batter - Blend 4375.0Blend 42022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Fluffiest Otter12.0null2022"), locations.get("S1"),3, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Blind Pig510.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Narwhall12.0null2020"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Glory Haze16.0null2022"), locations.get("S1"),3, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Carribean16.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Freckles25.4.0null2020"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Marzepandemonium25.4null2017"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("S'Moreo25.4null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Satisfies25.4null2021"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("So Happens Its Tuesday16.0null2022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Bringing The Juice16.0Formation 52022"), locations.get("S1"),6, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Bringing The Juice16.0Formation 62022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Double Pyscho25.4null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Helms Deep25.4German Chocolate2022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Helms Deep12.0Triple Mash2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Barrel Aged PCR500.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Brian Box32.0null2022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Brian Box16.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Cashmere16.0Double Cashmere2022"), locations.get("S1"),4, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Cashmere16.0Johnny Cashmere2022"), locations.get("S1"),4, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Coconut Castle500.0null2022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Duggernaut500.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Good Smorning500.0null2022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Let The Devil Out500.0null2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Stepping on Legos16.0null2022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("11th Anniversary - Cocoa Nibs & Caramel25.0null2021"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Mexican Cake25.0null2022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Milk & Cookies12.0null2022"), locations.get("S1"),5, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Alpha Abstraction16.0Volume 212022"), locations.get("S1"),5, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Alpha Abstraction16.0Volume 222022"), locations.get("S1"),6, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Dark Allyance12.0null2022"), locations.get("S1"),2, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Lone Buffalo500.0BBA Aged2022"), locations.get("S1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverages.get("Partners in Crema12.0null2022"), locations.get("S1"),0, date, date));
        inventoryRepository.saveAll(inventoryItems);



//        beverageRepository.saveAll(beverages);
    }
}
