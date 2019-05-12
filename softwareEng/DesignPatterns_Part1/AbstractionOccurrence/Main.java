public class Main {
  public static void main(String[] args) {
    Title lotr = new Title("Lord of the Rings", "Tolkein", 1234, 1954);
    Title hp = new Title("Harry Potter", "Rowling", 1321, 2000);
    LibraryItem lotr_1 = new LibraryItem(1, lotr);
    LibraryItem lotr_2 = new LibraryItem(2, lotr);
    LibraryItem lotr_3 = new LibraryItem(3, lotr);
    LibraryItem hp_1 = new LibraryItem(4, hp);
    LibraryItem hp_2 = new LibraryItem(5, hp);
    LibraryItem hp_3 = new LibraryItem(6, hp);
    lotr.addLibraryItem(lotr_1);
    lotr.addLibraryItem(lotr_2);
    lotr.addLibraryItem(lotr_3);
    hp.addLibraryItem(hp_1);
    hp.addLibraryItem(hp_2);
    hp.addLibraryItem(hp_3);
    System.out.println(lotr);
    System.out.println(hp);
  }
}
