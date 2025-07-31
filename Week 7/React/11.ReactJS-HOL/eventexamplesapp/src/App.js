import React, { Component } from 'react';
import './App.css';
import CurrencyConverter from './CurrencyConverter';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 5,
    };
  }

  increment = () => {
    this.setState({ count: this.state.count + 1 });
    this.sayHello();
  };

  sayHello = () => {
    alert("Hello! Member1");
  };

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  sayWelcome = (msg) => {
    alert(msg);
  };

  handleClick = (e) => {
    alert("I was clicked");
  };

  render() {
    return (
      <div className="App">
        <h1>React App</h1>
        <p><strong>Counter Display: {this.state.count}</strong></p>
        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>
        <button onClick={() => this.sayWelcome("welcome")}>Say welcome</button>
        <button onClick={(e) => this.handleClick(e)}>Click on me</button>

        <CurrencyConverter />
      </div>
    );
  }
}

export default App;
