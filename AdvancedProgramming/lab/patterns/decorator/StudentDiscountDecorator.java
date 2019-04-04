package lab.patterns.decorator;

public class StudentDiscountDecorator extends ShopComponentDecorator {

	public StudentDiscountDecorator(ShopComponent component) {
		super(component);
	}

	@Override
	public Double compPrice() {
		if (this.getDiscountable()) {
			return this.component.compPrice() * (1 - (10/100.0));
		} else {
			return this.compPrice();
		}
	}

	@Override
	public boolean getDiscountable() {
		return this.component.getDiscountable();
	}
	
	public String toString() {
        return this.component.getName() + String.format(" (£%5.2f)",compPrice()) + " (with student discount) ";
    }
}
