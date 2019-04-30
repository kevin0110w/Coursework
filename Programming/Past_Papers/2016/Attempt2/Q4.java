import java.util.*;
import java.io.*;

public class Q4 {
  public static void main(String[] args) {
    ArrayList<Double> numbers = new ArrayList<Double>();
    File f = null;
    FileReader reader = null;
    Scanner s = null;
    try {
      f = new File("in.txt");
      reader = new FileReader(f);
      s = new Scanner(reader);
      while (!(Double.parseDouble(s.nextLine()) == -1.0)) {
        numbers.add(Double.parseDouble(s.nextLine()));
      }
    } catch (Exception e) {

    }
    Collections.sort(numbers);
    Double max = numbers.get(numbers.size()-1);
    Double min = numbers.get(0);
    Double weighting = 0.0;
    String line = "";
    for (Double x : numbers) {
      weighting = (x-min)/(max - min);
      line = line + String.format("%8.4f %4.2f", x, weighting) + "\n";
    }
    System.out.println(line);
  }
}
