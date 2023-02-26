import React, { useState } from "react";
import "./Filter.css";
import Card from "../../UI/Card";

const StyleFilter = (props) => {
  const [selected, setSelected] = useState([]);

  const handleClick = (style) => {
    if (!selected.includes(style)) {
      setSelected([...selected, style]);
      props.onChangeFilter([...selected, style]);
    } else {
      setSelected(selected.filter((s) => s !== style));
      props.onChangeFilter(selected.filter((s) => s !== style));
    }
  };

  const handleClickNewStyle = (itemId) => {
    console.log("DRINK");
    props.onDrinkBeverage(itemId);
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify([itemId.toString()]),
    };
    fetch("http://192.168.86.71:8080/cellar/drink", requestOptions);
  };

  return (
    <div className="container">
      <div className="title">
        <h2>Type</h2>
      </div>
      <ul className="fill-list">
        {props.styles.length > 0 && props.styles.map((style) => (
          <div key={style}>
            <Card
              className={`fill ${
                selected.includes(style) ? "selected" : "unselected"
              }`}
              onClick={() => handleClick(style)}
            >
              <div className="style-name" onClick={() => handleClick(style)}>
                <h2>{style}</h2>
                {selected.includes(style) && <img src="/check_fill.png" alt="Icon" />}
              </div>
            </Card>
          </div>
        ))}
      </ul>
      <Card className="add-new">
          <div className="add-custom" onClick={() => handleClickNewStyle(props.id)}>
            <h2><img src="/plus.png" alt="plus" /> Add Custom Type</h2>
          </div>
        </Card>
    </div>
  );
};
export default StyleFilter;
