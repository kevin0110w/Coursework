package lab.patterns.decorator;

public abstract class ShopComponentDecorator implements ShopComponent {
	protected ShopComponent component;
	
	public ShopComponentDecorator(ShopComponent component) {
		this.component = component;
	}
	
	public String getName() {
		return this.component.getName();
	}
	
	public abstract Double compPrice();
	
	public String toString() {
		return this.component.toString();
	}
}
