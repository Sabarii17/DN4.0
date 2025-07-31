import React from 'react';

const CourseDetails = ({ courses }) => {
  // Conditional rendering using if-else inside component
  if (courses.length === 0) {
    return <p>No course data available</p>;
  }

  return (
    <div className="section">
      <h1>Course Details</h1>
      {courses.map((course) => (
        <div key={course.id}>
          <h3>{course.cname}</h3>
          <h4>{course.date}</h4>
        </div>
      ))}
    </div>
  );
};

export default CourseDetails;
