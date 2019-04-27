public class FourE {
  static class Parent {
    public String name;
    public Parent() {
      name = "I am the parent";
    }

    public String getName() {
      return name;
    }
  }

  static class Child extends Parent {
    public Child() {
      super();
      super.name = "I am the child";
    }

    public boolean isBorn() {
      return true;
    }

    @Override
    public String getName() {
      return super.name;
    }
  }

  public static void main(String[] args) {
    Parent c = new Child();
    // c.isBorn();  // does not work, file will not compile.
    System.out.println(c.getName());
    c = new Parent();
    System.out.println(c.getName());
  }
}
