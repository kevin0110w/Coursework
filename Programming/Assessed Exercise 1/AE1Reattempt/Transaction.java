public class Transaction {
  private Wine wine;
  private double balance;
  private double transactionCost = 0.0;
  private Customer customer;

  public Transaction(Wine transactedWine, Customer customer) {
    this.wine = transactedWine;
    this.customer = customer;
  }

  public double transactionCost() {
    if (this.wine.getWineQuantity() < 0) {
      this.transactionCost = ((this.wine.getWinePrice() * 0.8) * this.wine.getWineQuantity()) * -1;
    } else {
      this.transactionCost = this.wine.getWinePrice() * this.wine.getWineQuantity();
    }
    calculateRunningBalance();
    return this.transactionCost;
  }

  public String getTransactionCost(){
    String tCost = String.format("%4.2f", this.transactionCost);
    return tCost;
  }

  public void calculateRunningBalance(){
    customer.setBalance(this.transactionCost);
  }

  public String toString() {
    return this.wine.toString() + ", total cost = £" + String.format("%4.2f", transactionCost()) + ", new balance = £" + customer.getBalance();
  }

  public static void main(String[] args) {
    Transaction t1 = new Transaction(new Wine("Malbec", 1, 1.00), new Customer("Kevin", 20));
    System.out.println(t1);
  }
}
