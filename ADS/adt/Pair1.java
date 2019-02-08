package adt;

public class Pair1<E> implements Pair<E>{
	private E first;
	private E second;

	public Pair1(E f, E s) {
		this.first = f;
		this.second = s;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair1<String> me = new Pair1<>("Alice", "Senior Lecturer");
		String my_name = me.first();
		System.out.println(my_name);
		System.out.println();
		Person pierre = new Person("Pierre", "Curie");
		Person marie = new Person("Marie", "Curie");
		Pair1<Person> curies = new Pair1<>(pierre, marie);
		Person p = curies.second();
		System.out.println("The most famous Curie is " + p);
		
		
	}


	@Override
	public E first() {
		// TODO Auto-generated method stub
		return this.first;
	}


	@Override
	public E second() {
		// TODO Auto-generated method stub
		return this.second;
	}


	@Override
	public void updateFirst(E e1) {
		// TODO Auto-generated method stub
		this.first = e1;
	}


	@Override
	public void updateSecond(E e2) {
		// TODO Auto-generated method stub
		this.second = e2;
	}

}
