import React, { useState } from "react";
import "./Filter.css";

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
