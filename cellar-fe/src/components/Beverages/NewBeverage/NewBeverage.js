import React, { useState } from "react";

import BeverageForm from "./BeverageForm";
import "./NewBeverage.css";

const NewBeverage = (props) => {
  console.log("PROPS");
  console.log(props);
  console.log(props.bevType);
  const bevType = props.bevType;
  const [isEditing, setIsEditing] = useState(false);

  const saveBeverageDataHandler = (enteredBeverageData) => {
    const beverageData = {
      ...enteredBeverageData,
      id: Math.random().toString(),
    };
    props.onAddBeverage(beverageData);
    setIsEditing(false);
  };

  const startEditingHandler = () => {
    setIsEditing(true);
  };

  const stopEditingHandler = () => {
    setIsEditing(false);
  };

  return (
    <div className="new-beverage">
      {!isEditing && (
        <button onClick={startEditingHandler}>
          <img src="/plus.png" alt="plus" /> Add a {bevType}
        </button>
      )}
      {isEditing && (
        <BeverageForm
          onSaveBeverageData={saveBeverageDataHandler}
          onCancel={stopEditingHandler}
          bevType={bevType}
        />
      )}
    </div>
  );
};

export default NewBeverage;
