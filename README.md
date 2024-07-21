# codeAlpha_Simulated-Stock-Trading-Platform
# Simulated Stock Trading Platform

## Description

This project is a simplified simulated stock trading platform written in Java. It includes the following features:

1. **Simulated Market Data**
2. **Buying/Selling Stocks**
3. **Tracking Portfolio Performance**

## Classes and Methods

### SimulatedMarket Class
- **Attributes:**
  - `prices`: A map storing stock prices.
  - `history`: A list storing historical market data.
  - `stocks`: A list of stock symbols.

- **Methods:**
  - `SimulatedMarket()`: Initializes the market with random prices for stocks.
  - `generateMarketData()`: Simulates market data by generating random price changes for each stock.
  - `getPrice(String stock)`: Returns the current price of the given stock.
  - `getHistory()`: Returns the historical market data.

### MarketData Class
- **Attributes:**
  - `date`: The date of the market data entry.
  - `stock`: The stock symbol.
  - `price`: The stock price.

- **Methods:**
  - `MarketData(Date date, String stock, double price)`: Initializes the market data entry.
  - `toString()`: Returns a string representation of the market data entry.

### Portfolio Class
- **Attributes:**
  - `balance`: The available balance in the portfolio.
  - `holdings`: A map storing the quantity of each stock held.
  - `transactions`: A list storing transactions.

- **Methods:**
  - `Portfolio(double initialBalance)`: Initializes the portfolio with the given initial balance.
  - `buy(String stock, int quantity, double price)`: Buys the specified quantity of the given stock at the given price.
  - `sell(String stock, int quantity, double price)`: Sells the specified quantity of the given stock at the given price.
  - `getHoldings()`: Returns the current holdings.
  - `getTransactions()`: Returns the transaction history.
  - `getBalance()`: Returns the current balance.

### Transaction Class
- **Attributes:**
  - `date`: The date of the transaction.
  - `stock`: The stock symbol.
  - `quantity`: The quantity of the stock involved in the transaction.
  - `price`: The price at which the transaction was made.
  - `type`: The type of transaction (Buy/Sell).

- **Methods:**
  - `Transaction(Date date, String stock, int quantity, double price, String type)`: Initializes the transaction.
  - `toString()`: Returns a string representation of the transaction.

### Main Class
- **Methods:**
  - `main(String[] args)`: The main method that simulates market data, buys and sells stocks, and displays market data, portfolio holdings, transactions, and balance.

## How to Run

1. **Compile the Java files:**
   ```bash
   javac SimulatedMarket.java MarketData.java Portfolio.java Transaction.java Main.java
