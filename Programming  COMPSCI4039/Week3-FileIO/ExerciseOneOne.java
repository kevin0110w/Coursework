import java.util.*;

public class ExerciseOneOne {
 
	public static void main(String[] args) {
//		Scanner reader = new Scanner(System.in);
//		System.out.print("Please enter an integer: ");
//		String input = reader.nextLine();
//		Scanner t = new Scanner(input);
//		boolean isInt = true;
//		try {
//			int a = t.nextInt();			
//			} catch( InputMismatchException e) {
//			e.printStackTrace();
//			System.out.println("Type a number please!");
////		} finally {
////			System.out.println("Type a number!");}

		Scanner reader = new Scanner(System.in);
		System.out.print("Please enter an integer: ");
		boolean isInt = true;
		while (isInt) {
		String input = reader.nextLine();
		Scanner t = new Scanner(input);
		try {
			int a = t.nextInt();	
			if (t.hasNextInt()) {
				isInt = false;
			}
			} catch( InputMismatchException e) {
			System.out.println("Type a number please!");
			}
		}
		System.out.println("Thank you!");
	}
}
		
