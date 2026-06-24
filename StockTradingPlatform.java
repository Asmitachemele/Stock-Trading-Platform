import java.util.*;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class Portfolio {
    double balance;
    HashMap<String, Integer> holdings;

    Portfolio(double balance) {
        this.balance = balance;
        holdings = new HashMap<>();
    }

    void buyStock(Stock stock, int quantity) {
        double cost = stock.price * quantity;

        if (cost <= balance) {
            balance -= cost;
            holdings.put(stock.symbol,
                    holdings.getOrDefault(stock.symbol, 0) + quantity);

            System.out.println("Bought " + quantity + " shares of " + stock.symbol);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    void sellStock(Stock stock, int quantity) {
        int owned = holdings.getOrDefault(stock.symbol, 0);

        if (owned >= quantity) {
            balance += stock.price * quantity;
            holdings.put(stock.symbol, owned - quantity);

            System.out.println("Sold " + quantity + " shares of " + stock.symbol);
        } else {
            System.out.println("Not enough shares to sell!");
        }
    }

    void displayPortfolio() {
        System.out.println("\nPortfolio Holdings:");
        for (String stock : holdings.keySet()) {
            System.out.println(stock + " : " + holdings.get(stock) + " shares");
        }
        System.out.println("Available Balance: ₹" + balance);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock tata = new Stock("TATA", 1500);
        Stock infosys = new Stock("INFY", 1800);
        Stock reliance = new Stock("RELIANCE", 2500);

        Portfolio user = new Portfolio(100000);

        while (true) {
            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Stocks:");
                    System.out.println("TATA      ₹1500");
                    System.out.println("INFY      ₹1800");
                    System.out.println("RELIANCE  ₹2500");
                    break;

                case 2:
                    System.out.print("Enter Stock (TATA/INFY/RELIANCE): ");
                    String buyStock = sc.next();
                    System.out.print("Enter Quantity: ");
                    int buyQty = sc.nextInt();

                    if (buyStock.equalsIgnoreCase("TATA"))
                        user.buyStock(tata, buyQty);
                    else if (buyStock.equalsIgnoreCase("INFY"))
                        user.buyStock(infosys, buyQty);
                    else if (buyStock.equalsIgnoreCase("RELIANCE"))
                        user.buyStock(reliance, buyQty);
                    else
                        System.out.println("Invalid Stock!");
                    break;

                case 3:
                    System.out.print("Enter Stock (TATA/INFY/RELIANCE): ");
                    String sellStock = sc.next();
                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    if (sellStock.equalsIgnoreCase("TATA"))
                        user.sellStock(tata, sellQty);
                    else if (sellStock.equalsIgnoreCase("INFY"))
                        user.sellStock(infosys, sellQty);
                    else if (sellStock.equalsIgnoreCase("RELIANCE"))
                        user.sellStock(reliance, sellQty);
                    else
                        System.out.println("Invalid Stock!");
                    break;

                case 4:
                    user.displayPortfolio();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}