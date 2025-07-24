// src/Posts.js
import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            loading: true,
            hasError: false
        };
    }

    loadPosts() {
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then(response => response.json())
            .then(data => {
                const postsArray = data.slice(0, 10).map(
                    post => new Post(post.id, post.title, post.body)
                );
                this.setState({ posts: postsArray, loading: false });
            })
            .catch(error => {
                throw new Error("Failed to load posts");
            });
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        this.setState({ hasError: true });
        alert("An error occurred: " + error.message);
    }

    render() {
        const { posts, loading, hasError } = this.state;

        if (hasError) {
            return <p style={{ color: 'red' }}>Something went wrong. Please try again later.</p>;
        }

        if (loading) {
            return <p>Loading posts...</p>;
        }

        return (
            <div className="posts-container">
                <h1>Posts</h1>
                {posts.map(post => (
                    <div className="post" key={post.id}>
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                        <hr />
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;
