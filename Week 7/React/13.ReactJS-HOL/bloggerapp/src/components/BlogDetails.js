import React from 'react';

const BlogDetails = ({ blogs }) => {
  // Conditional rendering using Ternary operator
  return (
    <div className="section">
      <h1>Blog Details</h1>
      {blogs.length > 0 ? (
        blogs.map((blog) => (
          <div key={blog.id}>
            <h3>{blog.title}</h3>
            <h5>{blog.author}</h5>
            <p>{blog.content}</p>
          </div>
        ))
      ) : (
        <p>No blogs found</p>
      )}
    </div>
  );
};

export default BlogDetails;
