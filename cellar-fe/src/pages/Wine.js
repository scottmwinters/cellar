import React from 'react';

// import ExpensesFilter from "./components/Expenses/ExpensesFilter";
import BeverageType from "./BeverageType"

const Wine = (props) => {
  const bevType="Wine";
  

  return (
    <div>
      <BeverageType name={bevType} />
    </div>
  );
};

export default Wine;
