public class DescribeVisitor implements MyVisitor {
  public void visit(Dog dog) {
    System.out.println(dog.getName() + " with " + dog.getLegs() + " legs.");
  }

  public void visit(Human human) {
    System.out.println(human.getName() + " with " + human.getLegs() + " legs.");
  }
}
