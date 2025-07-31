import React, { Component } from 'react';

class CurrencyConverter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: '',
      currency: '',
    };
  }

  handleAmountChange = (e) => {
    this.setState({ amount: e.target.value });
  };

  handleCurrencyChange = (e) => {
    this.setState({ currency: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const rupee = parseFloat(this.state.amount);
    const euroRate = 80; // 1 Euro = 80 INR
    const euroAmount = rupee * euroRate;
    alert(`Converting to Euro Amount is ${euroAmount}`);
  };

  render() {
    const headingStyle = {
      fontSize: '24px',
      fontWeight: 'bold',
      color: 'green',
    };

    return (
      <div>
        <h2 style={headingStyle}>Currency Convertor!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <label>
            Amount:
            <input
              type="text"
              value={this.state.amount}
              onChange={this.handleAmountChange}
            />
          </label>
          <br />
          <label>
            Currency:
            <input
              type="text"
              value={this.state.currency}
              onChange={this.handleCurrencyChange}
            />
          </label>
          <br />
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default CurrencyConverter;
