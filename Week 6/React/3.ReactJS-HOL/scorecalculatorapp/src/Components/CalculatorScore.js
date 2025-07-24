import React from 'react';
import '../Stylesheets/mystyle.css';
 // since it's in the same folder

function CalculatorScore() {
  const name = "Steve";
  const school = "DNV Public School";
  const totalMarks = 284;
  const score = (totalMarks / 300) * 100;

  return (
    <div className="container">
      <h1 className="heading">Student Details:</h1>
      <p><span className="label blue">Name:</span> <span className="value blue-text">{name}</span></p>
      <p><span className="label red">School:</span> <span className="value">{school}</span></p>
      <p><span className="label maroon">Total:</span> {totalMarks} Marks</p>
      <p><span className="label green">Score:</span><span className="value green-text">{score.toFixed(2)}%</span></p>
    </div>
  );
}

export default CalculatorScore;
