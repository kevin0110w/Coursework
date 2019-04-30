public class Q1 {
  public static void check(int m) {
    int month = m;
    switch (month) {
    case 2:
    case 4:
    case 6:
    System.out.println("Thai Food");

    case 1:
    case 3:
    case 5:
    System.out.println("Indian Food");
    break;

    default:
      System.out.println("British Food");

    }
  }

  public static void check2(int a, int b) {
    int val = (a<b) ? a:b;
    System.out.println(val);
    // int val = (a=b) ? a:b; // syntax here is wrong, rather than testing for equality you are assigning a value
    // System.out.println(val);
  }

  public static void main(String[] args) {
  check(4); // should print thai food and british food because 4 matches with case 4 and there's no break
  check(5); // should only print indian food because it breaks
  check(9); // should print British food because it doesnt match any of the prior cases so goes to default
  check2(3,2); //should print b which is 2 because it evaluates to 'false';

  }
  }
