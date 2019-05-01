public class Main {
  public static void main(String[] args) {
    Human h = new Human("Kevin");
    Dog d = new Dog("Bob");
    System.out.println(h.getName());
    System.out.println(d.getName());
    d.giveBone();
    h = new Dog("Ted");
    System.out.println(h.getName());
    Dog g = new Human("Kevin");
  }

  public static class Human {
    private String name;
    public Human(String name) {
    this.name = name;
  }
    public String getName() {
    return this.name;
    }
  }
  public static class Dog extends Human {
    public String name;
    public Dog(String name) {
    super(name);
    }

    public String getName() {
    return super.getName();
    }

    public void giveBone() {
    System.out.println("yum");
    }
  }
}
