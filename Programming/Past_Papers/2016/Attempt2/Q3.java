public class Q3 {
  public static void main(String[] args) {
    int a = 9;
    int b = 6;
    String output=String.format("%d/%d=%d",a,b,a/b);
    System.out.println("p: 9/6=1");
    System.out.println(output);
    String output1=String.format("6/9=%1.1f",a/(float)b);
    System.out.println("p: 6/9=1.5");
    System.out.println(output1);
    String output3=String.format("%02d/%02d=%02d",a,b,a/b);
    System.out.println("p: 09/06=01");
    System.out.println(output3);
    String output4=String.format("%d/%d=%5.2f",a,b,a/(float)b);
    System.out.println("p: 9/6=01.50");
    System.out.println(output4);
    String output5 = String.format("%1.1f/%1.1f=%d",(float)a,(float)b,a/b);
    System.out.println("p: 9.0/6.0=1");
    System.out.println(output5);
  }
}
