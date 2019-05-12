public class LibraryItem {
  private int barcode;
  private Title title;

  public LibraryItem(int barcode, Title title) {
    this.barcode = barcode;
    this.title = title;
  }

  public int getBarcode() {
    return this.barcode;
  }

  public void setBarCode(int code) {
    this.barcode = code;
  }

  public Title getTitle() {
    return this.title;
  }

  public void setTitle(Title title) {
    this.title = title;
  }

  public String toString() {
    return "Book: " + this.title.getName() + "\n Code:  " + this.barcode;
  }


}
