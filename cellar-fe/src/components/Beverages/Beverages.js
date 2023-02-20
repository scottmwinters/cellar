import React, { useState } from "react";

import Card from "../UI/Card";
// import BeveragesFilter from "./BeveragesFilter";
import BeveragesList from "./BeveragesList";
import "./Beverages.css";

const Beverages = (props) => {
  const bevs = props.items;
  const onDrinkHandler = (beverageId) => {
    props.onDrinkBeverage(beverageId);
  };

  return (
    <div>
      <Card className="beverages">
        <BeveragesList items={bevs} onDrinkBeverage={onDrinkHandler} />
      </Card>
    </div>
  );
};

export default Beverages;
