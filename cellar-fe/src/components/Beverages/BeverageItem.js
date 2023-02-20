import React, { useState } from "react";

import "./BeverageItem.css";
import Card from "../UI/Card";

const BeverageItem = (props) => {
  // const [drank, setDrank] = useState("");
  let name = props.name;
  const isBeer = props.type === "Beer";
  const isWine = props.type === "Wine";
  props.variant ? (name = name + " " + props.variant) : (name = name);
  const abv = props.abv;

  const handleClick = (beverage) => {
    props.onDrinkBeverage(beverage.id);
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(beverage.id),
    };
    fetch("http://192.168.86.71:8080/cellar/drink", requestOptions)
  };

  return (
    <li>
      <Card className="beverage-item">
        <div className="beverage-item__maker">
          <h2>{props.maker}</h2>
          <div className="beverage-item__name">{name}</div>
          {isBeer && (
            <p className="beverage-item__info">
              {abv || "N/A"}% ABV &nbsp;&nbsp;&nbsp;&nbsp; Quantity:{" "}
              {props.quantity || "N/A"}
            </p>
          )}
          {isWine && (
            <p className="beverage-item__info">
              {abv || "N/A"}% ABV &nbsp;&nbsp;&nbsp;&nbsp; Quantity:{" "}
              {props.quantity || "N/A"} &nbsp;&nbsp;&nbsp;&nbsp; Location:{" "}
              {props.storageLocation || "N/A"}
            </p>
          )}
        </div>
        <Card className="dwrap">
          <div className="drink-one" onClick={() => handleClick(props)}>
            <h2>Drink One</h2>
          </div>
        </Card>
      </Card>
    </li>
  );
};

export default BeverageItem;
