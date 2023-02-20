import React, { useState, useEffect } from "react";

import Beverages from "../components/Beverages/Beverages";
import NewBeverage from "../components/Beverages/NewBeverage/NewBeverage";
import StyleFilter from "../components/Beverages/Filters/StyleFilter";
import RegionFilter from "../components/Beverages/Filters/RegionFilter";
import "./styles.css";
const BeverageType = (props) => {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [filteredStyle, setFilteredStyle] = useState([]);
  const [filteredRegion, setFilteredRegion] = useState([]);
  const [inventoryItems, setInventoryItems] = useState([]);

  console.log(inventoryItems);
  useEffect(() => {
    fetch("http://192.168.86.71:8080/cellar/beverages?type=" + props.name)
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setInventoryItems(result);
        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          setIsLoaded(true);
          setError(error);
        }
      );
  }, []);

  const addInventoryItemHandler = (inventoryItem) => {
    setInventoryItems((prevInventoryItems) => {
      return [inventoryItem, ...prevInventoryItems];
    });
  };

  const onDrinkHandler = (updatedInventoryItem) => {
    setInventoryItems(
      inventoryItems.map((inventoryItem) => {
        if (inventoryItem.id === updatedInventoryItem) {
          inventoryItem.quantity--;
        }
        return inventoryItem;
      })
    );
  };

  const styleFilterChangeHandler = (filteredStyle) => {
    setFilteredStyle(filteredStyle);
  };
  const regionFilterChangeHandler = (filteredRegion) => {
    setFilteredRegion(filteredRegion);
  };

  const filteredInventoryItems =
    inventoryItems.length > 0 &&
    inventoryItems.filter((inventoryItem) => {
      let allowed = true;
      if (inventoryItem.quantity <= 0) {
        return false;
      }
      if (filteredStyle.length === 0 && filteredRegion.length === 0) {
        return true;
      } else if (filteredStyle.length > 0 && filteredRegion.length > 0) {
        allowed =
          filteredStyle.includes(inventoryItem.beverage.style.name) &&
          filteredRegion.includes(inventoryItem.beverage.region.name);
      } else if (filteredRegion.length > 0) {
        allowed = filteredRegion.includes(inventoryItem.beverage.region.name);
      } else if (filteredStyle.length > 0) {
        allowed = filteredStyle.includes(inventoryItem.beverage.style.name);
      }
      return allowed;
    });

  const bevType = props.name;
  console.log("INVENTORY ITEMS: " + inventoryItems);
  inventoryItems.forEach((element) => console.log(element.beverage.style.name));
  // array1.forEach(element => console.log(element));
  const uniqueMakers =
    inventoryItems.length > 0 &&
    Array.from(
      new Set(
        inventoryItems
          .filter(
            (inventoryItems) =>
              inventoryItems.beverage.maker !== null &&
              inventoryItems.beverage.maker.length > 0
          )
          .map((inventoryItems) => inventoryItems.beverage.maker.name)
      )
    ).sort();

  const uniqueStyles =
    inventoryItems.length > 0 &&
    Array.from(
      new Set(
        inventoryItems
          .filter(
            (inventoryItem) =>
              inventoryItem.beverage.style.name !== null &&
              inventoryItem.beverage.style.name.length > 0 &&
              inventoryItem.quantity > 0
          )
          .map((inventoryItem) => inventoryItem.beverage.style.name)
      )
    ).sort();
  console.log("STYLES" + uniqueStyles);
  const uniqueRegions =
    inventoryItems.length > 0 &&
    Array.from(
      new Set(
        inventoryItems
          .filter(
            (inventoryItems) =>
              inventoryItems.beverage.region.name !== null &&
              inventoryItems.beverage.region.name.length > 0 &&
              inventoryItems.quantity > 0
          )
          .map((inventoryItems) => inventoryItems.beverage.region.name)
      )
    ).sort();
  console.log("REGIIINNNN: " + uniqueRegions);

  return (
    <div className="container">
      <div className="new-and-search">
        <div className="new-beverage">
          <NewBeverage
            onAddBeverage={addInventoryItemHandler}
            bevType={bevType}
          />
        </div>
        <div className="search-bar">
          <input
            type="text"
            id="search-input"
            placeholder="Search Collection..."
          />
        </div>
      </div>
      <StyleFilter
        className="style-filter"
        styles={uniqueStyles}
        onChangeFilter={styleFilterChangeHandler}
      />
      <RegionFilter
        regions={uniqueRegions}
        onChangeFilter={regionFilterChangeHandler}
      />
      <Beverages
        items={filteredInventoryItems}
        onDrinkBeverage={onDrinkHandler}
      />
    </div>
  );
};

export default BeverageType;
