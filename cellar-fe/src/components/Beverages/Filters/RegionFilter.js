import React, { useState } from "react";
import "./Filter.css";
import Card from "../../UI/Card";

const RegionFilter = (props) => {
  const [selectedRegion, setSelectedRegion] = useState('');

  // const handleClick = (region) => {
  //   console.log("CLICKED ON " + region);
  //   if (!selected.includes(region)) {
  //     setSelected([...selected, region]);
  //     props.onChangeFilter([...selected, region]);
  //   } else {
  //     setSelected(selected.filter((s) => s !== region));
  //     props.onChangeFilter(selected.filter((s) => s !== region));
  //   }
  // };

  const handleRegionChange = (event) => {
    setSelectedRegion(event.target.value);
  };

  const handleClickNewRegion = (itemId) => {
    console.log("region");
  };

  return (
    <div className="container">
      <div className="title">
        <h2>Region</h2>
      </div>
      <select className="drop" value={selectedRegion} onChange={handleRegionChange}>
      <option value=""> </option>
        {props.regions.length > 0 &&
          props.regions.map((region) => (
            <option key={region} value={region}>
              {region}
            </option>
          ))}
      </select>
      <Card className="add-new">
        <div
          className="add-custom"
          onClick={() => handleClickNewRegion(props.id)}
        >
          <h2>
            <img src="/plus.png" alt="plus" /> Add Custom Type
          </h2>
        </div>
      </Card>
    </div>
  );
};
export default RegionFilter;

//{/* {isOpen && (
//   <ul className="fill-list">
//     {props.regions.map((region) => (
//       <Card
//         key={region}
//         className={`fill ${
//           selected.includes(region) ? "selected" : "unselected"
//         }`}
//       >
//         <div className="region-name" onClick={() => handleClick(region)}>
//           <h2>{region}</h2>
//         </div>
//       </Card>
//     ))}
//   </ul>
// )} */}
