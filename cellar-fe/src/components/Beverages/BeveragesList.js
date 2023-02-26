import React from "react";

import BeverageItem from "./BeverageItem";
import "./BeveragesList.css";

const BeveragesList = (props) => {
  if (props.items.length === 0) {
    return <h2 className="beverages-list__fallback">No Drinks Found</h2>;
  }

  const onDrinkBeverageHandler = (beverageId) => {
    props.onDrinkBeverage(beverageId);
  };
  return (
    <ul className="beverages-list">
      {props.items.length > 0 &&
        props.items.map((inventoryItem) => (
          <BeverageItem
            key={inventoryItem.id}
            name={inventoryItem.beverage.name?.name}
            style={inventoryItem.beverage.style.name}
            substyle={inventoryItem.beverage.style.substyle}
            barrel={inventoryItem.beverage.barrel}
            region={inventoryItem.beverage.region.name}
            variant={inventoryItem.beverage.variant?.name}
            maker={inventoryItem.beverage.maker.name}
            type={inventoryItem.beverage.style.type}
            date={inventoryItem.beverage.date}
            abv={inventoryItem.beverage.abv}
            quantity={inventoryItem.quantity}
            vintage={inventoryItem.beverage.vintage}
            size={inventoryItem.beverage.size.amount}
            sizeUnits={inventoryItem.beverage.size.unit}
            storageLocation={inventoryItem.location.name}
            id={inventoryItem.id}
            onDrinkBeverage={onDrinkBeverageHandler}
          />
        ))}
    </ul>
  );
};
export default BeveragesList;
