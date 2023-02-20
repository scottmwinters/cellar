import React, { useState, useEffect } from 'react';

// import ExpensesFilter from "./components/Expenses/ExpensesFilter";
import BeverageType from "./BeverageType"

const Beer = (props) => {
  const bevType="Beer";
  

  return (
    <div>
      <BeverageType name={bevType} />
    </div>
  );
};

export default Beer;
