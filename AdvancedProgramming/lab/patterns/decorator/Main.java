package lab.patterns.decorator;

public class Main {
	public static void main(String[] args) {
		ShopComponent stuff = new ShopLeaf("stuff", 10.0, true);
		ShopComponent stuff1 = new ShopLeaf("stuff1", 11.0, true);
		ShopComponent stuff2 = new ShopLeaf("stuff2", 12.0, true);
		ShopComposite composite = new ShopComposite("composite");
		composite.addItem(stuff);
		composite.addItem(stuff2);
		composite.addItem(stuff1);
		ShopComponent studentDiscount = new StudentDiscountDecorator(stuff);
		ShopComponent staffDiscount = new StaffDiscountDecorator(stuff);
		ShopComponent studentDiscount1 = new StudentDiscountDecorator(composite);
		System.out.println(studentDiscount);
		System.out.println(staffDiscount);
		System.out.println(studentDiscount1);
	}
	/*
		ShopLeaf apple = new ShopLeaf("Apple",0.35);
        ShopComposite multiApple = new ShopComposite("Apple pack");
        for(int i=0;i<6;i++) {
            multiApple.addItem(apple);
        }        
        ShopComposite basket = new ShopComposite("Basket");
        basket.addItem(multiApple);
        ShopLeaf bread = new ShopLeaf("Bread",0.8);
        basket.addItem(bread);

        
        System.out.println(basket);

        StudentDiscountDecorator studentBasket = new StudentDiscountDecorator(basket);
        System.out.println(studentBasket);
        StaffDiscountDecorator staffBasket = new StaffDiscountDecorator(basket);
        System.out.println(staffBasket);
       }
        */
	
}
