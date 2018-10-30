
public class Wine {
	private String name;
	private int quantity;
	private double price;
//	private Wine[] wine = new Wine[999]; 
	
	public Wine(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public void setWineName(String name) {
		this.name = name;
	}
	
	public String getWineName() {
		return this.name;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPricePerBottle() {
//		return this.price * this.quantity;
		return this.price;
	}
	
	public double getTotalCostPerOrder() {
		return this.price * this.quantity;
	}

	
//	public void printPrint() {
//		String output = "";
//		for (int i = 0; i < this.wine.length; i++) {
//			output = this.wine[i].name + output;
//			System.out.println(output);
////			output = "Wine name: " + this.wine[i].name + ", Wine price: " + this.wine[i].price + "\n" + output;
//		}
//	}
}
