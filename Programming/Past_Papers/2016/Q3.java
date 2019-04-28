public class Q3 {
  public static void main(String[] args) {
    int a = 9;
    int b = 6;

    String output=String.format("%d/%d=%d",a,b,a/b);
    System.out.println("Predicted: 1");
    System.out.println(output);
    String output2=String.format("6/9=%1.1f",a/(float)b);
    System.out.println("Predicted: 1.5");
    System.out.println(output2);
    String output3=String.format("%02d/%02d=%02d",a,b,a/b);
    System.out.println("Predicted: 001");
    System.out.println(output3);
    String output4=String.format("%d/%d=%2.2f",a,b,a/(float)b);
    System.out.println("Predicted: 1.50");
    System.out.println(output4);
    String output5 = String.format("%1.1f/%1.1f=%d",(float)a,(float)b,a/b);
    System.out.println("Predicted: 1.50");
    System.out.println(output5);
  }
}
