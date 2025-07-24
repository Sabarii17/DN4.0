// src/App.js
import React from 'react';
import CohortDetails from './components/CohortDetails';
import { cohortList } from './data';

function App() {
  return (
    <div style={{ padding: '20px' }}>
      <h2>Cohorts Details</h2>
      {cohortList.map((cohort, idx) => (
        <CohortDetails key={idx} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
