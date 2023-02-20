import React, { useState } from "react";
import "./BeverageForm.css";

const BeverageForm = (props) => {
  console.log("FORM HAS VALUE")
  console.log(props)
  const [enteredName, setEnteredName] = useState("");
  const [abv, setAbv] = useState("");
  const[maker, setMaker] = useState("");
  const makerDisplayValue = (props.bevType === "Beer") ? "Brewery" : "Wine Maker";
  const[quantity, setQuantity] = useState("");
  const[region, setRegion] = useState("");
  const[style, setStyle] = useState("");
  const[subStyle, setSubStyle] = useState("");
  const[color, setColor] = useState("");
  const[storageLocation, setStorageLocation] = useState("");
  const isBeer = props.bevType==="Beer";
  const isWine = props.bevType==="Wine";
  
  const[size, setSize] = useState(isWine ? "750" : isBeer ? "12" : "");
  const[sizeUnits, setSizeUnits] = useState(isWine ? "ml" : isBeer ? "oz" : "")

  const NameChangeHandler = (event) => {
    setEnteredName(event.target.value);
  };
  
  const AbvHandler = (event) => {
    setAbv(event.target.value);
  };
  const MakerHandler = (event) => {
    setMaker(event.target.value);
  };
  const QuantityHandler = (event) => {
    setQuantity(event.target.value);
  };
  const RegionHandler = (event) => {
    setRegion(event.target.value);
  };
  const StyleHandler = (event) => {
    setStyle(event.target.value);
  };
  const SubStyleHandler = (event) => {
    setSubStyle(event.target.value);
  };
  const ColorHandler = (event) => {
    setColor(event.target.value);
  };
  const StorageLocationHandler = (event) => {
    setStorageLocation(event.target.value);
  };
  const SizeHandler = (event) => {
    setSize(event.target.value);
  };
  const SizeUnitsHandler = (event) => {
    setSizeUnits(event.target.value);
  };

  // const TypeChangeHandler = (event) => {
  //   setEnteredType(event.target.value);
  // };

  const submitHandler = (event) => {
    event.preventDefault();

    const beverageData = {
      name: enteredName,
      type: props.bevType,
      abv: abv,
      maker: maker,
      quantity: quantity,
      region: region,
      style: style,
      subStyle: subStyle,
      color: color,
      storageLocation: storageLocation,
      size: size,
      sizeUnits: sizeUnits,
      // date: new Date(enteredDate),
    };

    props.onSaveBeverageData(beverageData);
    setEnteredName("");
    setAbv("");
    setMaker("");
    setQuantity("");
    setRegion("");
    setStyle("");
    setSubStyle("");
    setColor("");
    setStorageLocation("");
    setSize(isWine ? "750" : isBeer ? "12" : "");
    setSizeUnits(isWine ? "ml" : isBeer ? "oz" : "")

    console.log(beverageData)
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json'},
      body: JSON.stringify( beverageData )
    };
    fetch('http://192.168.86.71:8080/cellar', requestOptions)
        .then(response => response.json());
  };

  return (
    <form onSubmit={submitHandler}>
      <div className="new-beverage__control">
        <div className="new-beverage__control">
          <label>Name</label>
          <input
            type="text"
            value={enteredName}
            onChange={NameChangeHandler}
          />
        </div>
        <div className="new-beverage__control">
          <label>ABV</label>
          <input
            type="text"
            value={abv}
            onChange={AbvHandler}
          />
        </div>
        <div className="new-beverage__control">
          <label>{makerDisplayValue}</label>
          <input
            type="text"
            value={maker}
            onChange={MakerHandler}
          />
        </div>
        <div className="new-beverage__control">
          <label>Quantity</label>
          <input
            type="number"
            value={quantity}
            onChange={QuantityHandler}
          />
        </div>
        <div className="new-beverage__control">
          <label>Region</label>
          <input
            type="region"
            value={region}
            onChange={RegionHandler}
          />
        </div>
        <div className="new-beverage__control">
          <label>Style</label>
          <input
            type="style"
            value={style}
            onChange={StyleHandler}
          />
        </div>
        <div className="new-beverage__control">
          <label>Size</label>
          <input
            type="number"
            value={size}
            onChange={SizeHandler}
          />
        </div>
        <div className="new-beverage__control">
          <label>Size Units</label>
          <input
            type="text"
            value={sizeUnits}
            onChange={SizeUnitsHandler}
          />
        </div>
        {isBeer && (
        <div className="new-beverage__control">
          <label>Sub-Style</label>
          <input
            type="text"
            value={subStyle}
            onChange={StyleHandler}
            />
        </div>
        )}
        {isWine && (
        <div className="new-beverage__control">
          <label>Color</label>
          <input
            type="text"
            value={color}
            onChange={ColorHandler}
            />
        </div>
        ) && (
        <div className="new-beverage__control">
          <label>Storage Location</label>
          <input
            type="text"
            value={storageLocation}
            onChange={StorageLocationHandler}
            />
        </div>
        )}
        
      </div>
      <div className="new-beverage__actions">
        <button type="submit">Add {props.bevType}</button>
        <button type="button" onClick={props.onCancel}>Cancel</button>
      </div>
    </form>
  );
};

export default BeverageForm;
