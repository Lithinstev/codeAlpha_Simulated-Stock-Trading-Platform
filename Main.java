import java.util.*;

class SimulatedMarket {
    private Map<String, Double> prices;
    private List<MarketData> history;
    private List<String> stocks;

    public SimulatedMarket() {
        this.stocks = Arrays.asList("AAPL", "GOOGL", "MSFT", "AMZN", "TSLA");
        this.prices = new HashMap<>();
        this.history = new ArrayList<>();

        for (String stock : stocks) {
            prices.put(stock, 100 + (400 * Math.random()));
        }
    }

    public void generateMarketData() {
        Date date = new Date();
        Random rand = new Random();
        for (String stock : stocks) {
            double priceChange = -5 + (10 * rand.nextDouble());
            double newPrice = prices.get(stock) + priceChange;
            prices.put(stock, newPrice);
            history.add(new MarketData(date, stock, newPrice));
        }
    }

    public Double getPrice(String stock) {
        return prices.get(stock);
    }

    public List<MarketData> getHistory() {
        return history;
    }
}

class MarketData {
    private Date date;
    private String stock;
    private double price;

    public MarketData(Date date, String stock, double price) {
        this.date = date;
        this.stock = stock;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Stock: " + stock + ", Price: " + price;
    }
}

class Portfolio {
    private double balance;
    private Map<String, Integer> holdings;
    private List<Transaction> transactions;

    public Portfolio(double initialBalance) {
        this.balance = initialBalance;
        this.holdings = new HashMap<>();
        this.transactions = new ArrayList<>();

        for (String stock : Arrays.asList("AAPL", "GOOGL", "MSFT", "AMZN", "TSLA")) {
            holdings.put(stock, 0);
        }
    }

    public boolean buy(String stock, int quantity, double price) {
        double totalCost = price * quantity;
        if (balance >= totalCost) {
            balance -= totalCost;
            holdings.put(stock, holdings.get(stock) + quantity);
            transactions.add(new Transaction(new Date(), stock, quantity, price, "Buy"));
            return true;
        }
        return false;
    }

    public boolean sell(String stock, int quantity, double price) {
        if (holdings.get(stock) >= quantity) {
            holdings.put(stock, holdings.get(stock) - quantity);
            balance += price * quantity;
            transactions.add(new Transaction(new Date(), stock, quantity, price, "Sell"));
            return true;
        }
        return false;
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }
}

class Transaction {
    private Date date;
    private String stock;
    private int quantity;
    private double price;
    private String type;

    public Transaction(Date date, String stock, int quantity, double price, String type) {
        this.date = date;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Stock: " + stock + ", Quantity: " + quantity + ", Price: " + price + ", Type: " + type;
    }
}

public class Main {
    public static void main(String[] args) {
        SimulatedMarket market = new SimulatedMarket();
        Portfolio portfolio = new Portfolio(10000);

        // Simulate some market data
        for (int i = 0; i < 10; i++) {
            market.generateMarketData();
        }

        // Display market data
        System.out.println("Market Data:");
        for (MarketData data : market.getHistory()) {
            System.out.println(data);
        }

        // Buy some stocks
        if (portfolio.buy("AAPL", 10, market.getPrice("AAPL"))) {
            System.out.println("Bought 10 AAPL stocks");
        } else {
            System.out.println("Insufficient funds to buy AAPL stocks");
        }

        // Sell some stocks
        if (portfolio.sell("AAPL", 5, market.getPrice("AAPL"))) {
            System.out.println("Sold 5 AAPL stocks");
        } else {
            System.out.println("Insufficient holdings to sell AAPL stocks");
        }

        // Display portfolio
        System.out.println("\nPortfolio Holdings:");
        System.out.println(portfolio.getHoldings());

        System.out.println("\nPortfolio Transactions:");
        for (Transaction transaction : portfolio.getTransactions()) {
            System.out.println(transaction);
        }

        System.out.println("\nPortfolio Balance:");
        System.out.println(portfolio.getBalance());
    }
}
