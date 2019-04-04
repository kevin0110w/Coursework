package lab.patterns.decorator;

import java.util.ArrayList;

public class ShopComposite implements ShopComponent {
	public String name;
	public ArrayList<ShopComponent> children;
	
	public ShopComposite(String name) {
		this.name = name;
		this.children = new ArrayList<ShopComponent>();
	}
	
	public void addItem(ShopComponent component) {
		this.children.add(component);
	}
	public void removeItem(ShopComponent component) {
		this.children.remove(component);
	}
	@Override
	public String toString() {
		String fullString = name;
		fullString += "{";
		for (ShopComponent component : children) {
			name += component + ", ";
		}
		fullString += "}";
		return fullString;
		}
	@Override
	public boolean getDiscountable() {
		return true;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public Double compPrice() {
		Double price = 0.0;
		for (ShopComponent component : children) {
			price += component.compPrice();
		}
		return price;
	}
}
