// src/App.js
import React from 'react';
import './App.css';
import officeImg from './office.jpg'; // Place your image in src folder

function App() {
  const officeList = [
    { Name: 'DBS', Rent: 50000, Address: 'Chennai' },
    { Name: 'Regus', Rent: 70000, Address: 'Mumbai' },
    { Name: 'SmartWorks', Rent: 45000, Address: 'Bangalore' },
    { Name: 'WeWork', Rent: 85000, Address: 'Delhi' }
  ];

  const getColorClass = (rent) => {
    return rent <= 60000 ? 'textRed' : 'textGreen';
  };

  return (
    <div className="App">
      <h1>Office Space, at Affordable Range</h1>
      <img src={officeImg} width="25%" height="25%" alt="Office Space" />

      {officeList.map((item, index) => (
        <div key={index}>
          <h2>Name: {item.Name}</h2>
          <h3 className={getColorClass(item.Rent)}>Rent: Rs. {item.Rent}</h3>
          <h3>Address: {item.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;
