import java.util.Scanner;

public class Lab6Ex2 {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Please enter an integer");
	int a = scanner.nextInt();
	System.out.println("Please enter how many entries you would like to see");
	int numberOfTimes = scanner.nextInt();
	timesTable(a, numberOfTimes);
	//for (int i = 0; i <= 10; i++) {
	//	System.out.println(a + " times " + i + " = " + (a*i));
	//}
	
	scanner.close();
}

	public static void timesTable(int value, int numberOfTimes) {
		for (int i = 0; i < numberOfTimes; i++) {
			System.out.println(value + " times " + i + " = " + (value*i));
		}
		
	}

}
