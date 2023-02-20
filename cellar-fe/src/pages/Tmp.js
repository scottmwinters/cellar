// import React, { useState, useEffect } from 'react';

// // import ExpensesFilter from "./components/Expenses/ExpensesFilter";
// import Beverages from "../components/Beverages/Beverages"
// import NewBeverage from "../components/Beverages/NewBeverage/NewBeverage";

// // const STARTING_BEVERAGES = {
// //   method: 'GET',
// //   headers: { 'Content-Type': 'application/json'},
// // };
// // fetch('http://localhost:8080/cellar', requestOptions)
// //     .then(response => response.json());

// const Wine = () => {

//   const [error, setError] = useState(null);
//   const [isLoaded, setIsLoaded] = useState(false);
//   const [beverages, setBeverages] = useState([]);
//   console.log(beverages);
//   useEffect(() => {
//     fetch("http://192.168.86.71:8080/cellar/beverages?type=Wine")
//       .then(res => res.json())
//       .then(
//         (result) => {
//           setIsLoaded(true);
//           setBeverages(result);
//         },
//         // Note: it's important to handle errors here
//         // instead of a catch() block so that we don't swallow
//         // exceptions from actual bugs in components.
//         (error) => {
//           setIsLoaded(true);
//           setError(error);
//         }
//       )
//   }, [])

  
//   const bevType="Wine";
//   const addBeverageHandler = (beverage) => {
//     setBeverages((prevBeverages) => {
//       return [beverage, ...prevBeverages];
//     });
//   };

//   // const filterExpensesHandler = (expenses) => {
//   //   return { expenses };
//   // };

//   return (
//     <div>
//       {/* <ExpensesFilter onFilterExpenses={filterExpensesHandler} /> */}
//       <NewBeverage
//         onAddBeverage={addBeverageHandler}
//         bevType={bevType} 
//       />
//       <Beverages items={beverages} />
//     </div>
//   );
// };

// export default Wine;
