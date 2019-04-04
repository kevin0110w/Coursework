package lab.patterns.decorator;

public class ShopLeaf implements ShopComponent {
	private String name;
	private Double price;
	private boolean discountable;

	public ShopLeaf(String name, Double price, boolean discountable) {
		this.name = name;
		this.price = price;
		this.discountable = discountable;
	}
	
	public ShopLeaf(String string, double d) {
		this.name = string;
		this.price = d;
	}

	/**
	 * Returns this price of an item after a discount has been applied
	
	@Override
	public Double compPrice(Double discount) {
		if (discountable) {
			return this.price = (1.0 -  (discount/100.0)) * this.price;
		} else {
			return this.price;
		}
	}
	 */
	
	@Override
    public String toString() {
        return this.name + String.format(" (£%5.2f)",compPrice());
    }

	@Override
	public boolean getDiscountable() {
		return this.discountable;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Double compPrice() {
		return this.price;
	}
}

