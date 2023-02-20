import React, { useState } from "react";

import "./Pill.css";

const Pill = (props) => {
    const styles = props.items;

    console.log("PROPSPSPSP" + styles);

    return (
        <div>
        {/* <Card className="beverages"> */}
            abc
        {/* </Card> */}
        </div>
      );
};

export default Pill;
/*
const Beverages = (props) => {
  // const [filteredType, setFilteredType] = useState("Stout");

  // const filterChangeHandler = (selectedType) => {
  //   setFilteredType(selectedType);
  // };

  // const filteredBeverages = props.items.filter(beverage => {
  //   return beverage.Type === filteredType;
  // });
  const bevs = props.items;

  return (
    <div>
      <Card className="beverages">
        <BeveragesList items={bevs} />
        {/* {beveragesContent} }
      </Card>
    </div>
  );
};

export default Beverages;

*/