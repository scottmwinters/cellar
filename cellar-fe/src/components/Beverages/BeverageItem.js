import React, { useState } from "react";

import "./BeverageItem.css";
import Card from "../UI/Card";

const BeverageItem = (props) => {
  // const [drank, setDrank] = useState("");
  const [showFindIcon, setShowFindIcon] = useState(false);
  const [showDrinkIcon, setShowDrinkIcon] = useState(false);

  let name = props.name;
  let style = props.style;

  if (!props.name) {
    name = props.style;
    style = null;
  }

  props.variant ? (name = name + " " + props.variant) : (name = name);

  const abv = props.abv;

  const handleClick = (itemId) => {
    console.log("DRINK");
    props.onDrinkBeverage(itemId);
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify([itemId.toString()]),
    };
    fetch("http://192.168.86.71:8080/cellar/drink", requestOptions);

    setShowDrinkIcon(true);
    setTimeout(() => {
      setShowDrinkIcon(false);
    }, 3000);
  };

  const handleClickFind = (itemId) => {
    console.log("FIND!");
    console.log(itemId);
    //TODO: pass this up and show on the card which beer is lit in the cabinet
    // props.onDrinkBeverage(itemId);
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify([itemId.toString()]),
    };
    fetch("http://192.168.86.71:8080/inventory/lights", requestOptions);

    setShowFindIcon(true);
    setTimeout(() => {
      setShowFindIcon(false);
    }, 3000);
  };

  return (
    <li className="list_item">
      <div className="beverage-item__maker">
        <div className="beverage-item__maker_name">
          {props.maker}
          <span className="beverage_item__quantity">QT: {props.quantity}</span>
        </div>
        <div className="beverage-item__name">
          {name && (name.length <= 15 ? name : `${name.substring(0, 15)}.`)}
          <h2>&nbsp;&nbsp; {style} </h2>
        </div>
        <p className="beverage-item__info">
          Size: {props.size ? props.size + " " + props.sizeUnits : ""}
          &nbsp;&nbsp;&nbsp;&nbsp; {abv ? "ABV: " + props.abv + "%" : "?"}{" "}
          &nbsp;&nbsp;&nbsp;&nbsp;
          {props.vintage ? "Year: " + props.vintage : ""}
          <span className="beverage_item__quantity">
            Bin: {props.storageLocation}
          </span>
        </p>
      </div>
      <div className="dwrap">
        <Card className="dwrap">
          <div className="drink-one" onClick={() => handleClickFind(props.id)}>
            <h2>
              Find Only
              {showFindIcon && <img id="check-icon" src="/check_fill.png" alt="Icon" />}
            </h2>
          </div>
        </Card>
        <Card className="dwrap">
          <div className="drink-one" onClick={() => handleClick(props)}>
            <h2>
              Find + Drink
              {showDrinkIcon && <img id="check-icon" src="/check_fill.png" alt="Icon" />}
            </h2>
          </div>
        </Card>
      </div>
    </li>
  );
};
export default BeverageItem;
