package lab.patterns.decorator;

public class StaffDiscountDecorator extends ShopComponentDecorator {

	public StaffDiscountDecorator(ShopComponent component) {
		super(component);
		
	}

	@Override
	public Double compPrice() {
		if (this.component.getDiscountable()) {
			return this.component.compPrice() * (1 - (50/100.0));
		} else {
			return this.component.compPrice();
		}
	}

	@Override
	public boolean getDiscountable() {
		return this.component.getDiscountable();
	}
	
	public String toString() {
        return this.component.getName() + String.format(" (£%5.2f)",compPrice()) + " (with staff discount) ";
    }
}
