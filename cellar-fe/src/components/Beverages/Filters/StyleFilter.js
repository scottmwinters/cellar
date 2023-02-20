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
    </div>
  );
};
export default StyleFilter;

/*
return (
    <ul className="fill-list">
      <h2 >Type</h2>
      {props.styles.map((style) => (
        <Card
          key={style}
          className={`fill ${
            selected.includes(style) ? "selected" : "unselected"
          }`}
          onClick={() => handleClick(style)}
        >
          <div className="style-name" onClick={() => handleClick(style)}>
            <h2>{style}</h2>
          </div>
        </Card>
      ))}
    </ul>
  );

/*
return (
    <ul className="style-list">
      {props.styles.map((style) => (
        <div
          key={style}
          className={`style ${
            selected.includes(style) ? "selected" : "unselected"
          }`}
          onClick={() => handleClick(style)}
        >
          <h2>{style}</h2>
        </div>
      ))}
    </ul>
  );
};
*/
