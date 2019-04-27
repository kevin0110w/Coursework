import java.util.Scanner;

public class TimesTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.println("Please type a number: ");
		int number = Integer.parseInt(s.nextLine());
		int i = 1;
		do {
			int sum = number * i;
			System.out.println(number + " x " + i + " = " + sum);
			i++;
		} while (i <= 10);
		s.close();
	}

}
