import java.util.*;
import java.io.*;

public class Q4 {
  public static Double weighting(Double n, Double min, Double max) {
    Double weight = (n - min) / (max - min);
    return weight;
  }

  public static void main(String[] args) {
    File f = new File("in.txt");
    Scanner scanner = null;
    String end = "-1.0";
    ArrayList<Double> numbers = new ArrayList<Double>();
    try {
      scanner = new Scanner(f);
      do {
      String number = scanner.nextLine();
      numbers.add(Double.parseDouble(number));
    } while (!(scanner.nextLine().equals(end)));
  } catch (Exception e) {

  }
    Collections.sort(numbers);
    Double max = numbers.get(numbers.size()-1);
    Double min = numbers.get(0);
    System.out.println("max: " + max);
    System.out.println("min: " + min );
    for (int i = 0; i < numbers.size(); i++) {
      Double weight = weighting(numbers.get(i), min, max);
      String output = String.format("%08f.4, %04f.2", numbers.get(i), weight);
      System.out.println(output);
    }
  }
}
