package iterators_and_design_patterns;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Random;

//Iterator interface defines hasNext(), next() and remove()
//Iterable - one method - iterator() - returns an object that implements iterator
//arraylist also iterable,, thus syntatically similar
// need to make a new iterator that has it's own defined position
//public class Iterators_1 implements Iterator<Double>, Iterable <Double>{
public class Iterators_1 implements Iterable <Double>{

//public class Iterators_1 implements Iterable {

//	int pos;
	int length;
	double[] array;
	
	public Iterators_1(int length) {
//		this.pos = 0;
		this.array = new double[length];
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter length: ");
		int length = Integer.parseInt(s.nextLine());
		Iterators_1 example = new Iterators_1(length);
//		Iterator<Double> b = example;
		example.populateArray();
//		example.printArray();
//		while (example.hasNext()) {
//			System.out.print(example.next() + " ,");
//		}
		for (Double d : example) {
			System.out.println(d);
		}
		s.close();
	}
	
	public  void populateArray() {
		Random r = new Random();
		for (int i = 0; i < this.array.length; i++) {
			double value = r.nextDouble() - 0.5;
			this.array[i] = value;
		}
	}
	
	public void printArray() {
		for (int i = 0; i < this.array.length; i++) {
			System.out.print(this.array[i] + " ," );
		}
	}
	/*
	/**
	 * while position is less than the length of the array
	
	@Override
	public boolean hasNext() {
		return this.pos < this.array.length;
	}
	/**
	 * return the next element
	 
	@Override
	public Object next() {
		return this.pos++;
	}
	*/
	
//	@Override
//	public boolean hasNext() {
//		return this.pos < this.array.length;
//	}
//
//	@Override
//	public Double next() {
////		if (this.array[pos] % 2 == 0) {
////			return (double) this.pos++;
////		} else if (this.array[pos] % 2 != 0) {
////			
////		}
//		return array[pos++];
//	}
//	
//	@Override
//	public void remove() {
//		throw new UnsupportedOperationException();
//	}

	@Override
	public Iterator<Double> iterator() {
//		return this; // using that instance of the object thus only does one iteration
		return new Iterator<Double>() {
			private int  pos = 0;
			public boolean hasNext() {
				return pos < length;
			}
			@Override
			public Double next() {
				return array[pos++];
			}
		}
	;,m 
	}
}
