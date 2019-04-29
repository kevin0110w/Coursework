public class Test {
  public static void main(String[] args) {
    // Subject a = new Subject();
    // AnObserver o = new AnObserver(a);
    // a.setData(5);
    // a.setData(6);

    Dog dog = new Dog();
    Human human = new Human();
    DescribeVisitor d = new DescribeVisitor();
    dog.accept(d);
    human.accept(d);
  }
}
