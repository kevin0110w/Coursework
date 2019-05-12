public class Singleton {
    private Singleton singleton;

    private Singleton() {
      this.singleton = new Singleton();
    }

    public static Singleton getSingleton() {
      if (this.singleton == null) {
        this.singleton = new Singleton();
      }
      return this.singleton;
    }
}
