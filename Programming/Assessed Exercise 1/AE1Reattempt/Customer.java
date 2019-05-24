public class Customer {
  private String name;
  private double balance;
  private final double initialBalance;

  public Customer(String name, double balance) {
    this.name = name;
    this.balance = balance;
    this.initialBalance = balance;
  }

  public double getInitialBalance() {
    return this.initialBalance;
  }

  public String getCustomerName() {
    return this.name;
  }

  public double getCustomerBalance() {
    return this.balance;
  }

  public void setCustomerName(String name) {
    this.name = name;
  }

  public String getBalance() {
    String balance = String.format("%4.2f", this.balance);
    return balance;
  }
  public void setBalance(double balance) {
    this.balance += balance;
  }
  public String toString() {
    return this.name + ". Your balance is £" + getBalance();
  }
}
