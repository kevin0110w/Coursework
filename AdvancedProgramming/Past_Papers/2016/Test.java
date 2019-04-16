import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {
    Course mL = new Course("Machine Learning", 20);
    Course ap = new Course("Advanced Programming", 20);
    Programme rr = new Programme("Research Readings in Computing Science");
    Course iR = new Course("Information Retrieval", 5);
    Course hCI = new Course("Human-Centered Interaction", 5);
    rr.addComponent(iR);
    rr.addComponent(hCI);
    Programme mscit = new Programme("mscit");
    mscit.addComponent(mL);
    mscit.addComponent(ap);
    mscit.addComponent(rr);
    System.out.println(mscit.description() + "Total Number of Credits: " + mscit.getCredits());

    // ArrayList<Component> x = new ArrayList<Component>();
    // x.add(mL);
    // x.add(ap);
    // x.add(rr);
    // for (Component y:x) {
    //   System.out.println(y.description());
    // }
  }
}
