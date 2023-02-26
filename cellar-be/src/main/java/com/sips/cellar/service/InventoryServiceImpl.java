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
        Map<String, Region> regions = regionRepository.findAll().stream().collect(Collectors.toMap(r -> r.getName() + r.getSubRegion(), Function.identity()));
        Map<String, Name> names = nameRepository.findAll().stream().collect(Collectors.toMap(Name::getName, Function.identity()));
        Map<String, Maker> makers = makerRepository.findAll().stream().collect(Collectors.toMap(Maker::getName, Function.identity()));
        Map<String, Style> styles = styleRepository.findAll().stream().collect(Collectors.toMap(s -> s.getName() + s.getSubStyle(), Function.identity()));
        Map<String, Location> locations = locationRepository.findAll().stream().collect(Collectors.toMap(Location::getName, Function.identity()));
        Map<Double, Size> sizes = sizeRepository.findAll().stream().collect(Collectors.toMap(Size::getAmount, Function.identity()));
        Map<String, Variant> variants = variantRepository.findAll().stream().collect(Collectors.toMap(Variant::getName, Function.identity()));
//        Map<Long, Name> namesById = beverageRepository.findAll().stream().collect(Collectors.toMap(Name::getId, Function.identity()));
        Map<String, Beverage> beverages = beverageRepository.findAll().stream().collect(Collectors.toMap(s -> (s.getName() != null && s.getName().getName() != null ? s.getName().getName() : "null" + s.getMaker().getName()) + s.getSize().getAmount() + (s.getVariant() != null? s.getVariant().getName() : "null") + s.getVintage(), Function.identity()));
//        List<Beverage> beverages = new ArrayList<>();
//        System.out.println(names.entrySet());
//        beverages.add(new Beverage(names.get(null),makers.get("Weingut Frank"),styles.get("Grüner Veltlinernull"),12.5,null,sizes.get(750.0),2021, regions.get("Austrianull")));
//        beverages.add(new Beverage(names.get(null),makers.get("Matiné Grasso Fratelli "),styles.get("Barbera D'albanull"),16.5,null,sizes.get(750.0),2017, regions.get("ItalyPiedmont")));
//        beverages.add(new Beverage(names.get("Predicador"),makers.get("Vendages Manuelles"),styles.get("François Cazinnull"),14.5,null,sizes.get(750.0),2020, regions.get("FranceLoire Valley")));
//        beverages.add(new Beverage(names.get("Mas des Huppes"),makers.get("Bodega Contador"),styles.get("Tempranillonull"),14.5,null,sizes.get(750.0),2014, regions.get("SpainRioja")));
//        beverages.add(new Beverage(names.get(null),makers.get("Saint Chinian"),styles.get("Red Blendnull"),14.5,null,sizes.get(750.0),2019, regions.get("FranceD'origine Protégée")));
//        beverages.add(new Beverage(names.get("Dal Peduncolo"),makers.get("Fontaleoni"),styles.get("Vernaccianull"),12.5,null,sizes.get(750.0),2021, regions.get("ItalianSan Gimignano, Tuscany")));
//        beverages.add(new Beverage(names.get(null),makers.get("Le Vigne Di Zamó"),styles.get("Rossonull"),14.0,null,sizes.get(750.0),2017, regions.get("ItalyFriuli")));
//        beverages.add(new Beverage(names.get(null),makers.get("Jules Taylor"),styles.get("Pinot Noirnull"),13.5,null,sizes.get(750.0),2919, regions.get("New ZealandMarlborough")));
//        beverages.add(new Beverage(names.get(null),makers.get("Artezin"),styles.get("Zinfandelnull"),14.8,null,sizes.get(750.0),2019, regions.get("USCA - Mendocino")));
//        beverages.add(new Beverage(names.get(null),makers.get("Vidal-Fleury"),styles.get("Red Blendnull"),14.5,null,sizes.get(750.0),2019, regions.get("FranceCôtes du Rhône, Rhône Valley")));
//        beverages.add(new Beverage(names.get(null),makers.get("Villa Appalaccia"),styles.get("Dolcettonull"),14.1,null,sizes.get(750.0),2022, regions.get("USVirginia")));
//        beverages.add(new Beverage(names.get(null),makers.get("Chandon"),styles.get("Brutnull"),12.0,null,sizes.get(750.0),2022, regions.get("USCalifornia")));
//        beverages.add(new Beverage(names.get("Impérial"),makers.get("Moët & Chandon"),styles.get("Champagnenull"),12.0,null,sizes.get(750.0),2022, regions.get("FranceEpernay")));
//        List<Beverage> beverages = new ArrayList<>();
        //public Beverage(Name name, Maker maker, Style style, Double abv, Variant variant, Size size, Integer vintage, Region region) {
//        beverages.add(new Beverage(names.get("Bon Bon Cerise"),makers.get("Avery"),styles.get("BBA Imperial Stout"),14.6, null,sizes.get(12.0),2019, regions.get("CO")));


//        beverages.add(new Beverage(names.get("Bon Bon Cerise"), makers.get("Avery"), styles.get("BBA Imperial Stout"), 14.6, null, sizes.get(12.0), 2019, regions.get("CO")));
//        beverages.add(new Beverage(names.get("One Ping Only"), makers.get("Avery"), styles.get("BBA Russian Imperial"), 13.6, null, sizes.get(12.0), 2022, regions.get("CO")));
//        beverages.add(new Beverage(names.get("Vanilla Bean"), makers.get("Avery"), styles.get("BBA Stout"), 10.5, null, sizes.get(16.0), 2022, regions.get("CO")));
//        beverages.add(new Beverage(names.get("A Brillaintly Deformed Corpse Neverless"), makers.get("Burial"), styles.get("Imperial Stout"), 14.0, null, sizes.get(25.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Because You Can See What I Cannot"), makers.get("Burial"), styles.get("Imperial Stout"), 14.5, null, sizes.get(25.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("End of Plagues"), makers.get("Burial"), styles.get("IPA"), 7.2, null, sizes.get(16.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Griddle Donut"), makers.get("Burial"), styles.get("Imperial Stout"), 10.0, null, sizes.get(12.0), 2021, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Skillet Donut"), makers.get("Burial"), styles.get("Imperial Stout"), 8.0, null, sizes.get(16.0), 2021, regions.get("NC")));
//        beverages.add(new Beverage(names.get("What if theres Another World"), makers.get("Burial"), styles.get("IPA"), 7.2, null, sizes.get(16.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Fresh"), makers.get("Civil Society"), styles.get("IPA"), 6.2, null, sizes.get(16.0), 2022, regions.get("FL")));
//        beverages.add(new Beverage(names.get("Collaboration Without Representation"), makers.get("Deep River"), styles.get("Imperial Milk Stout"), 12.8, null, sizes.get(16.0), 2021, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Eclipse"), makers.get("Fifty-Fifty"), styles.get("BA Imperial Stout"), 12.1, variants.get("George Dickle Barrel"), sizes.get(25.0), 2021, regions.get("CA")));
//        beverages.add(new Beverage(names.get("Happium"), makers.get("Foothills"), styles.get("Imperial IPA"), 8.0, null, sizes.get(12.0), 2021, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Breakfast Stout"), makers.get("Founders"), styles.get("Imperial Stout"), 8.3, null, sizes.get(12.0), 2020, regions.get("MI")));
//        beverages.add(new Beverage(names.get("CBS"), makers.get("Founders"), styles.get("BBA Imperial Stout"), 11.3, null, sizes.get(25.4), 2019, regions.get("MI")));
//        beverages.add(new Beverage(names.get("CBS"), makers.get("Founders"), styles.get("BBA Imperial Stout"), 11.0, null, sizes.get(12.0), 2019, regions.get("MI")));
//        beverages.add(new Beverage(names.get("KBS"), makers.get("Founders"), styles.get("BBA Imperial Stout"), 12.0, variants.get("Espresso"), sizes.get(12.0), 2021, regions.get("MI")));
//        beverages.add(new Beverage(names.get("KBS"), makers.get("Founders"), styles.get("BBA Imperial Stout"), 12.0, variants.get("Espresso"), sizes.get(12.0), 2020, regions.get("MI")));
//        beverages.add(new Beverage(names.get("KBS"), makers.get("Founders"), styles.get("BBA Imperial Stout"), 12.0, variants.get("Hazelnut"), sizes.get(12.0), 2022, regions.get("MI")));
//        beverages.add(new Beverage(names.get("KBS"), makers.get("Founders"), styles.get("BBA Imperial Stout"), 11.0, variants.get("Maple Mackinaw Fudge"), sizes.get(12.0), 2022, regions.get("MI")));
//        beverages.add(new Beverage(names.get("KBS"), makers.get("Founders"), styles.get("BBA Imperial Stout"), 11.0, variants.get("Maple Mackinaw Fudge"), sizes.get(12.0), 2020, regions.get("MI")));
//        beverages.add(new Beverage(names.get("KBS"), makers.get("Founders"), styles.get("BBA Imperial Stout"), 12.2, null, sizes.get(12.0), 2019, regions.get("MI")));
//        beverages.add(new Beverage(names.get("KBS"), makers.get("Founders"), styles.get("BBA Imperial Stout"), 12.0, null, sizes.get(12.0), 2020, regions.get("MI")));
//        beverages.add(new Beverage(names.get("KBS"), makers.get("Founders"), styles.get("BBA Imperial Stout"), 12.0, null, sizes.get(12.0), 2018, regions.get("MI")));
//        beverages.add(new Beverage(names.get("KBS"), makers.get("Founders"), styles.get("BA Imperial Stout"), 12.0, null, sizes.get(12.0), 2022, regions.get("MI")));
//        beverages.add(new Beverage(names.get("KBS"), makers.get("Founders"), styles.get("BBA Imperial Stout"), 11.6, variants.get("Chocolate Cherry"), sizes.get(12.0), 2022, regions.get("MI")));
//        beverages.add(new Beverage(names.get("Bourbon County"), makers.get("Goose Island"), styles.get("BBA Imperial Stout"), 13.2, variants.get("Cassia Bark"), sizes.get(25.0), 2021, regions.get("IL")));
//        beverages.add(new Beverage(names.get("Bourbon County"), makers.get("Goose Island"), styles.get("BBA Imperial Stout"), 13.3, variants.get("Coffee Maple Syrup"), sizes.get(25.0), 2020, regions.get("IL")));
//        beverages.add(new Beverage(names.get("10W-40"), makers.get("Hi-Wire"), styles.get("Imperial Stout"), 8.0, variants.get("Chai"), sizes.get(16.0), 2021, regions.get("NC")));
//        beverages.add(new Beverage(names.get("10W-40"), makers.get("Hi-Wire"), styles.get("Imperial Stout"), 8.0, variants.get("Chocolate Creme Brulee"), sizes.get(16.0), 2021, regions.get("NC")));
//        beverages.add(new Beverage(names.get("10W-40"), makers.get("Hi-Wire"), styles.get("Imperial Stout"), 8.0, variants.get("Vietnamese Iced Coffee"), sizes.get(16.0), 2021, regions.get("NC")));
//        beverages.add(new Beverage(names.get("10W-40"), makers.get("Hi-Wire"), styles.get("BBA Imperial Stout"), 9.5, variants.get("BBA"), sizes.get(16.0), 2021, regions.get("NC")));
//        beverages.add(new Beverage(names.get("10W-40"), makers.get("Hi-Wire"), styles.get("Imperial Stout"), 8.0, variants.get("Coconut Chocolate Bar"), sizes.get(16.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("10W-40"), makers.get("Hi-Wire"), styles.get("Imperial Stout"), 8.0, variants.get("Gingerbread Hot Chocolate"), sizes.get(16.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("20W-50"), makers.get("Hi-Wire"), styles.get("Imperial Stout"), 13.8, null, sizes.get(25.0), 2021, regions.get("NC")));
//        beverages.add(new Beverage(names.get("20W-50"), makers.get("Hi-Wire"), styles.get("Imperial Stout"), 12.8, variants.get("Cafe De Ole"), sizes.get(25.0), 2021, regions.get("NC")));
//        beverages.add(new Beverage(names.get("20W-50"), makers.get("Hi-Wire"), styles.get("Imperial Stout"), 12.1, variants.get("Coffee & Marshmallow"), sizes.get(25.0), 2021, regions.get("NC")));
//        beverages.add(new Beverage(names.get("20W-50"), makers.get("Hi-Wire"), styles.get("Imperial Stout"), 13.2, variants.get("Mint Chocolate Cookie"), sizes.get(16.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("20W-50"), makers.get("Hi-Wire"), styles.get("Imperial Stout"), 12.1, variants.get("Sugar Cookie"), sizes.get(25.0), 2021, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Cold Mountain"), makers.get("Highland"), styles.get("BBA Winter Ale"), 11.0, variants.get("BBA"), sizes.get(25.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Cold Mountain"), makers.get("Highland"), styles.get("Winter Ale"), 5.9, variants.get("Chocolate Hazelnut"), sizes.get(16.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Cold Mountain"), makers.get("Highland"), styles.get("Winter Ale"), 8.0, variants.get("Imperial"), sizes.get(16.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Cold Mountain"), makers.get("Highland"), styles.get("Winter Ale"), 5.9, null, sizes.get(12.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Thunderstruck Coffee"), makers.get("Highland"), styles.get("Porter"), 5.8, null, sizes.get(12.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Double Chocolate Brownie"), makers.get("Hubbards Cave"), styles.get("Imperial Stout"), 12.0, null, sizes.get(16.0), 2022, regions.get("IL")));
//        beverages.add(new Beverage(names.get("Champion Ground"), makers.get("Jackie Os"), styles.get("BBA Stout"), 11.8, null, sizes.get(12.0), 2022, regions.get("OH")));
//        beverages.add(new Beverage(names.get("IPA"), makers.get("Lagunitas"), styles.get("IPA"), 6.2, null, sizes.get(12.0), 2019, regions.get("CA")));
//        beverages.add(new Beverage(names.get("Galactic Cowboy"), makers.get("Left Hand"), styles.get("Nitro Imperial Stout"), 9.0, null, sizes.get(16.0), 2020, regions.get("CO")));
//        beverages.add(new Beverage(names.get("Asymetrical Simulation"), makers.get("Little Cottage"), styles.get("IPA"), 7.5, null, sizes.get(16.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("BA Venloac"), makers.get("Little Cottage"), styles.get("BBA Imperial Stout"), 12.5, null, sizes.get(12.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Christmas Land"), makers.get("Little Cottage"), styles.get("BBA Imperial Stout"), 13.0, null, sizes.get(12.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Escape From Planet Doom"), makers.get("Little Cottage"), styles.get("BBA Imperial Stout"), 12.0, null, sizes.get(12.0), 2023, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Island of Lost Souls"), makers.get("Little Cottage"), styles.get("BBA Imperial Stout"), 12.0, null, sizes.get(12.0), 2023, regions.get("GA")));
//        beverages.add(new Beverage(names.get("More Than Metal"), makers.get("Little Cottage"), styles.get("BBA Imperial Stout"), 13.0, null, sizes.get(12.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Dragons Milk"), makers.get("New Holland"), styles.get("BBA Imperial Stout"), 11.0, variants.get("2019 Oatmeal Cookie"), sizes.get(12.0), 2019, regions.get("MI")));
//        beverages.add(new Beverage(names.get("Dragons Milk"), makers.get("New Holland"), styles.get("BBA Imperial Stout"), 11.0, variants.get("2020 Reserve 2 - Scotch Marshmallow"), sizes.get(12.0), 2020, regions.get("MI")));
//        beverages.add(new Beverage(names.get("Dragons Milk"), makers.get("New Holland"), styles.get("BBA Imperial Stout"), 12.3, variants.get("2021 Reserve 2 - Vanilla"), sizes.get(12.0), 2021, regions.get("MI")));
//        beverages.add(new Beverage(names.get("Dragons Milk"), makers.get("New Holland"), styles.get("BBA Imperial Stout"), 11.0, variants.get("2022 Reserve 2 - Stroopwaffle"), sizes.get(12.0), 2022, regions.get("MI")));
//        beverages.add(new Beverage(names.get("Dragons Milk"), makers.get("New Holland"), styles.get("BBA Imperial Stout"), 11.0, variants.get("Chocolate Cherry"), sizes.get(12.0), 2018, regions.get("MI")));
//        beverages.add(new Beverage(names.get("Dragons Milk"), makers.get("New Holland"), styles.get("BBA Imperial Stout"), 11.0, variants.get("2022 Reserve 3 - Marshmallow"), sizes.get(12.0), 2022, regions.get("MI")));
//        beverages.add(new Beverage(names.get("Dragons Milk"), makers.get("New Holland"), styles.get("BBA Imperial Stout"), 11.0, null, sizes.get(12.0), 2021, regions.get("MI")));
//        beverages.add(new Beverage(names.get("Netflix And Dill"), makers.get("New Sarum"), styles.get("Imperial Gose"), 7.0, null, sizes.get(16.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Curate"), makers.get("Orpheus"), styles.get("Imperial Pastry Stout"), 13.7, null, sizes.get(16.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Dreams of a Distant Past"), makers.get("Orpheus"), styles.get("BBA Stout Blend"), 13.6, null, sizes.get(375.0), 2021, regions.get("GA")));
//        beverages.add(new Beverage(names.get("On Becoming Remants"), makers.get("Orpheus"), styles.get("BBA Barleywine"), 12.8, variants.get("Speyside Scotch"), sizes.get(375.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Stouts all the Way Down"), makers.get("Orpheus"), styles.get("BA Imperial Stout"), 12.0, variants.get("Costa Rica Vanilla Chronicle"), sizes.get(375.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Supply and the Damned"), makers.get("Orpheus"), styles.get("BBA Imperial Stout"), 13.3, null, sizes.get(375.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Twelth Labor"), makers.get("Orpheus"), styles.get("BBA Imperial Stout"), 14.0, variants.get("4 Year"), sizes.get(375.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Twelth Labor"), makers.get("Orpheus"), styles.get("BBA Imperial Stout"), 13.2, variants.get("Darkest Day"), sizes.get(375.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Twelth Labor"), makers.get("Orpheus"), styles.get("BBA Imperial Stout"), 13.1, null, sizes.get(375.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Ten Fiddy"), makers.get("Oscar Blues"), styles.get("BBA Imperial Stout"), 12.5, null, sizes.get(12.0), 2019, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Brownie Batter"), makers.get("Pontoon"), styles.get("BBA Imperial Sweet Stout"), 13.9, variants.get("Blend 3 - Loaded French Toast"), sizes.get(375.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Brownie Batter"), makers.get("Pontoon"), styles.get("BBA Imperial Sweet Stout"), 13.9, variants.get("Blend 3 - Vanilla Overload"), sizes.get(375.0), 2021, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Brownie Batter"), makers.get("Pontoon"), styles.get("BBA Imperial Sweet Stout"), 13.9, variants.get("Medionoche"), sizes.get(375.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Brownie Batter"), makers.get("Pontoon"), styles.get("BBA Imperial Sweet Stout"), 13.9, variants.get("Blend 4"), sizes.get(375.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Fluffiest Otter"), makers.get("Pontoon"), styles.get("Imperial Sweet Stout"), 9.0, null, sizes.get(12.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Blind Pig"), makers.get("Russian River"), styles.get("West Coast IPA"), 6.3, null, sizes.get(510.0), 2022, regions.get("CA")));
//        beverages.add(new Beverage(names.get("Narwhall"), makers.get("Sierra Nevada"), styles.get("Imperial Stout"), 10.2, null, sizes.get(12.0), 2020, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Glory Haze"), makers.get("Stillfire"), styles.get("Hazy IPA"), 6.9, null, sizes.get(16.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Carribean"), makers.get("Sycamore"), styles.get("Stout"), 7.0, null, sizes.get(16.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Freckles"), makers.get("The Bruery"), styles.get("BBA Imperial Stout"), 11.1, null, sizes.get(25.4), 2020, regions.get("CA")));
//        beverages.add(new Beverage(names.get("Marzepandemonium"), makers.get("The Bruery"), styles.get("BBA Imperial Stout"), 16.7, null, sizes.get(25.4), 2017, regions.get("CA")));
//        beverages.add(new Beverage(names.get("S'Moreo"), makers.get("The Bruery"), styles.get("BBA Imperial Stout"), 15.6, null, sizes.get(25.4), 2022, regions.get("CA")));
//        beverages.add(new Beverage(names.get("Satisfies"), makers.get("The Bruery"), styles.get("BBA Imperial Stout"), 14.1, null, sizes.get(25.4), 2021, regions.get("CA")));
//        beverages.add(new Beverage(names.get("So Happens Its Tuesday"), makers.get("The Bruery"), styles.get("BBA Imperial Stout"), 15.3, null, sizes.get(16.0), 2022, regions.get("CA")));
//        beverages.add(new Beverage(names.get("Bringing The Juice"), makers.get("Three Taverns"), styles.get("Double IPA"), 8.0, variants.get("Formation 5"), sizes.get(16.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Bringing The Juice"), makers.get("Three Taverns"), styles.get("Double New England IPA"), 8.0, variants.get("Formation 6"), sizes.get(16.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Double Pyscho"), makers.get("Three Taverns"), styles.get("BBA Imperial Pastry"), 12.5, null, sizes.get(25.4), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Helms Deep"), makers.get("Three Taverns"), styles.get("BBA Imperial Stout"), 13.0, variants.get("German Chocolate"), sizes.get(25.4), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Helms Deep"), makers.get("Three Taverns"), styles.get("BBA Imperial Stout"), 13.0, variants.get("Triple Mash"), sizes.get(12.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Barrel Aged PCR"), makers.get("Variant"), styles.get("BBA Imperial Stout"), 12.5, null, sizes.get(500.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Brian Box"), makers.get("Variant"), styles.get("Hazy IPA"), 8.5, null, sizes.get(32.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Brian Box"), makers.get("Variant"), styles.get("Hazy IPA"), 8.5, null, sizes.get(16.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Cashmere"), makers.get("Variant"), styles.get("NE Double IPA"), 12.5, variants.get("Double Cashmere"), sizes.get(16.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Cashmere"), makers.get("Variant"), styles.get("NE IPA"), 8.0, variants.get("Johnny Cashmere"), sizes.get(16.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Coconut Castle"), makers.get("Variant"), styles.get("Imperial Pastry Stout"), 13.7, null, sizes.get(500.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Duggernaut"), makers.get("Variant"), styles.get("Imperial Stout"), 13.9, null, sizes.get(500.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Good Smorning"), makers.get("Variant"), styles.get("BBA Imperial Pastry Stout"), 13.0, null, sizes.get(500.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Let The Devil Out"), makers.get("Variant"), styles.get("Imperial Stout"), 13.9, null, sizes.get(500.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Stepping on Legos"), makers.get("Variant"), styles.get("NE IPA"), 9.0, null, sizes.get(16.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("11th Anniversary - Cocoa Nibs & Caramel"), makers.get("Westbrook"), styles.get("Imperial Stout"), 11.0, null, sizes.get(25.0), 2021, regions.get("SC")));
//        beverages.add(new Beverage(names.get("Mexican Cake"), makers.get("Westbrook"), styles.get("Imperial Stout"), 10.5, null, sizes.get(25.0), 2022, regions.get("SC")));
//        beverages.add(new Beverage(names.get("Milk & Cookies"), makers.get("Wicked Weed"), styles.get("Imperial Stout"), 8.7, null, sizes.get(12.0), 2022, regions.get("NC")));
//        beverages.add(new Beverage(names.get("Alpha Abstraction"), makers.get("Wild Leap"), styles.get("DIPA"), 8.0, variants.get("Volume 21"), sizes.get(16.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Alpha Abstraction"), makers.get("Wild Leap"), styles.get("DIPA"), 8.0, variants.get("Volume 22"), sizes.get(16.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Dark Allyance"), makers.get("Wild Leap"), styles.get("Stout"), 12.3, null, sizes.get(12.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Lone Buffalo"), makers.get("Wild Leap"), styles.get("BA Stout"), 13.9, variants.get("BBA Aged"), sizes.get(500.0), 2022, regions.get("GA")));
//        beverages.add(new Beverage(names.get("Partners in Crema"), makers.get("Wild Leap"), styles.get("Stout"), 10.0, null, sizes.get(12.0), 2022, regions.get("GA")));
//


        List<InventoryItem> inventoryItems = new ArrayList<>();
        Date date = new Date(System.currentTimeMillis());
//        inventoryItems.add(new InventoryItem(beverages.get("Bon Bon Cerise12.0null2019"), locations.get("S1"), 1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("One Ping Only12.0null2022"), locations.get("S1"),3, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Vanilla Bean16.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("A Brillaintly Deformed Corpse Neverless25.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Because You Can See What I Cannot25.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("End of Plagues16.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Griddle Donut12.0null2021"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Skillet Donut16.0null2021"), locations.get("S1"),2, date, date));

//        inventoryItems.add(new InventoryItem(beverages.get("What if theres Another World16.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Fresh16.0null2022"), locations.get("S1"),3, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Collaboration Without Representation16.0null2021"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Eclipse25.0George Dickle Barrel2021"), locations.get("S1"),1, date, date));
//                inventoryItems.add(new InventoryItem(beverages.get("Happium12.0null2021"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Breakfast Stout12.0null2020"), locations.get("S1"),4, date, date));


//        inventoryItems.add(new InventoryItem(beverages.get("CBS25.4null2019"), locations.get("S1"),2, date, date));

//        inventoryItems.add(new InventoryItem(beverages.get("CBS12.0null2019"), locations.get("S1"),11, date, date));

//        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0Espresso2021"), locations.get("S1"),5, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0Espresso2020"), locations.get("S1"),2, date, date));


//          inventoryItems.add(new InventoryItem(beverages.get("KBS12.0Hazelnut2022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0Maple Mackinaw Fudge2022"), locations.get("S1"),4, date, date));

//        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0Maple Mackinaw Fudge2020"), locations.get("S1"),3, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0null2019"), locations.get("S1"),4, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0null2020"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0null2018"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("KBS12.0Chocolate Cherry2022"), locations.get("S1"),3, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Bourbon County25.0Cassia Bark2021"), locations.get("S1"),1, date, date));
//
//                inventoryItems.add(new InventoryItem(beverages.get("Bourbon County25.0Coffee Maple Syrup2020"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("10W-4016.0Chai2021"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("10W-4016.0Chocolate Creme Brulee2021"), locations.get("S1"),3, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("10W-4016.0Vietnamese Iced Coffee2021"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("10W-4016.0BBA2021"), locations.get("S1"),5, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("10W-4016.0Coconut Chocolate Bar2022"), locations.get("S1"),5, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("10W-4016.0Gingerbread Hot Chocolate2022"), locations.get("S1"),6, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("20W-5025.0null2021"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("20W-5025.0Cafe De Ole2021"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("20W-5025.0Coffee & Marshmallow2021"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("20W-5016.0Mint Chocolate Cookie2022"), locations.get("S1"),10, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("20W-5025.0Sugar Cookie2021"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Cold Mountain25.0BBA2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Cold Mountain16.0Chocolate Hazelnut2022"), locations.get("S1"),6, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Cold Mountain16.0Imperial2022"), locations.get("S1"),4, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Cold Mountain12.0null2022"), locations.get("S1"),36, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Thunderstruck Coffee12.0null2022"), locations.get("S1"),6, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Double Chocolate Brownie16.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Champion Ground12.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("IPA12.0null2019"), locations.get("S1"),5, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Galactic Cowboy16.0null2020"), locations.get("S1"),3, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Asymetrical Simulation16.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("BA Venloac12.0null2022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Christmas Land12.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Escape From Planet Doom12.0null2023"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Island of Lost Souls12.0null2023"), locations.get("S1"),3, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("More Than Metal12.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.02019 Oatmeal Cookie2019"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.02020 Reserve 2 - Scotch Marshmallow2020"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.02021 Reserve 2 - Vanilla2021"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.02022 Reserve 2 - Stroopwaffle2022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.0Chocolate Cherry2018"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.02022 Reserve 3 - Marshmallow2022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Dragons Milk12.0null2021"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Netflix And Dill16.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Curate16.0null2022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Dreams of a Distant Past375.0null2021"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("On Becoming Remants375.0Speyside Scotch2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Stouts all the Way Down375.0Costa Rica Vanilla Chronicle2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Supply and the Damned375.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Twelth Labor375.04 Year2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Twelth Labor375.0Darkest Day2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Twelth Labor375.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Ten Fiddy12.0null2019"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Brownie Batter375.0Blend 3 - Loaded French Toast2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Brownie Batter375.0Blend 3 - Vanilla Overload2021"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Brownie Batter375.0Medionoche2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Brownie Batter375.0Blend 42022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Fluffiest Otter12.0null2022"), locations.get("S1"),3, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Blind Pig510.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Narwhall12.0null2020"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Glory Haze16.0null2022"), locations.get("S1"),3, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Carribean16.0null2022"), locations.get("S1"),1, date, date));




//        inventoryItems.add(new InventoryItem(beverages.get("Freckles25.4null2020"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Marzepandemonium25.4null2017"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("S'Moreo25.4null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Satisfies25.4null2021"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("So Happens Its Tuesday16.0null2022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Bringing The Juice16.0Formation 52022"), locations.get("S1"),6, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Bringing The Juice16.0Formation 62022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Double Pyscho25.4null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Helms Deep25.4German Chocolate2022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Helms Deep12.0Triple Mash2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Barrel Aged PCR500.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Brian Box32.0null2022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Brian Box16.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Cashmere16.0Double Cashmere2022"), locations.get("S1"),4, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Cashmere16.0Johnny Cashmere2022"), locations.get("S1"),4, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Coconut Castle500.0null2022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Duggernaut500.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Good Smorning500.0null2022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Let The Devil Out500.0null2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Stepping on Legos16.0null2022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("11th Anniversary - Cocoa Nibs & Caramel25.0null2021"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Mexican Cake25.0null2022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Milk & Cookies12.0null2022"), locations.get("S1"),5, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Alpha Abstraction16.0Volume 212022"), locations.get("S1"),5, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Alpha Abstraction16.0Volume 222022"), locations.get("S1"),6, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Dark Allyance12.0null2022"), locations.get("S1"),2, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Lone Buffalo500.0BBA Aged2022"), locations.get("S1"),1, date, date));
//        inventoryItems.add(new InventoryItem(beverages.get("Partners in Crema12.0null2022"), locations.get("S1"),0, date, date));

//        inventoryItems.add(new InventoryItem(beverages.get("Bon Bon Cerise12.0null2019"), locations.get("S1"), 1, date, date));
        inventoryItems.add(new InventoryItem(beverageRepository.findById(109L).orElse(new Beverage()),locations.get("A1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverageRepository.findById(110L).orElse(new Beverage()),locations.get("A5"),1, date, date));
        inventoryItems.add(new InventoryItem(beverageRepository.findById(111L).orElse(new Beverage()),locations.get("B2"),1, date, date));
        inventoryItems.add(new InventoryItem(beverageRepository.findById(112L).orElse(new Beverage()),locations.get("B3"),1, date, date));
        inventoryItems.add(new InventoryItem(beverageRepository.findById(113L).orElse(new Beverage()),locations.get("B4"),1, date, date));
        inventoryItems.add(new InventoryItem(beverageRepository.findById(114L).orElse(new Beverage()),locations.get("C1"),1, date, date));
        inventoryItems.add(new InventoryItem(beverageRepository.findById(115L).orElse(new Beverage()),locations.get("C4"),1, date, date));
        inventoryItems.add(new InventoryItem(beverageRepository.findById(116L).orElse(new Beverage()),locations.get("C5"),1, date, date));
        inventoryItems.add(new InventoryItem(beverageRepository.findById(117L).orElse(new Beverage()),locations.get("L"),1, date, date));
        inventoryItems.add(new InventoryItem(beverageRepository.findById(118L).orElse(new Beverage()),locations.get("L"),1, date, date));
        inventoryItems.add(new InventoryItem(beverageRepository.findById(119L).orElse(new Beverage()),locations.get("L"),1, date, date));
        inventoryItems.add(new InventoryItem(beverageRepository.findById(120L).orElse(new Beverage()),locations.get("C3"),1, date, date));
        inventoryItems.add(new InventoryItem(beverageRepository.findById(121L).orElse(new Beverage()),locations.get("R"),1, date, date));
        inventoryRepository.saveAll(inventoryItems);
//        beverageRepository.saveAll(beverages);



//        beverageRepository.saveAll(beverages);
    }
}
