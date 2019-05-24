import java.util.Scanner;
import java.util.ArrayList;

public class TransactionLogger {
  private Log log;
  private boolean isValid;
  private Customer customer;
  private double balance;
  private ArrayList<Transaction> transactions;

  public TransactionLogger() {
    this.isValid = true;
    this.transactions = new ArrayList<Transaction>();
  }

  public void start() {
    Scanner reader = new Scanner(System.in);
    getCustomerDetails(reader);
    while (isValid) {
      getWineOrder(reader);
    }
    this.log.write();
  }

  public void getCustomerDetails(Scanner reader) {
    System.out.println("Welcome to Lilybank Wine Merchants.");
    System.out.print("Please enter your name: ");
    String name = reader.nextLine();
    System.out.print("Please enter your starting balance: ");
    double balance = Double.parseDouble(reader.nextLine());
    this.customer = new Customer(name, balance);
    this.log = new Log(customer.toString() + "\n");
  }

  public void getWineOrder(Scanner reader) {
    System.out.print("Please enter a wine name: ");
    String wineName = reader.nextLine();
    if (wineName.equals(" ")) {
      this.isValid = false;
      return;
    }
    int wineQuantity = getWineQuantity(reader);
    double wineCost = getWineCost(reader);
    Wine newWine = new Wine(wineName, wineQuantity, wineCost);
    Transaction transaction = new Transaction(newWine, this.customer);
    double transactionCost = getCost(wineQuantity, wineCost);
    this.log.addLine(transaction.toString());
    }


  public int getWineQuantity(Scanner reader) {
    int wineQuantity = 0;
    System.out.print("Please enter quantity (Integer): ");
    while (true) {
    try {
       wineQuantity = Integer.parseInt(reader.nextLine());
    } catch (Exception e) {
      System.out.println("Please try again! ");
    }
    break;
    }
    return wineQuantity;
  }

  public double getWineCost(Scanner reader) {
    double winePrice = 0.0;
    System.out.print("Please enter the price of the wine: ");
    while (true) {
    try {
       winePrice = Double.parseDouble(reader.nextLine());
    } catch (Exception e) {
      System.out.println("Please try again! ");
    }
    break;
    }
    return winePrice;
  }


  public double getCost(int quantity, double price) {
    double transaction = quantity * price;
    return transaction;
  }
  public void setStartingBalance() {
      this.balance = customer.getCustomerBalance();
  }

  public void setCustomerBalanceAfterPurchase(double wineTransaction) {
    this.balance += wineTransaction;
  }

  public void setCustomerBalanceAfterRefund(double wineTransaction) {
    this.balance -= wineTransaction;
  }
}
