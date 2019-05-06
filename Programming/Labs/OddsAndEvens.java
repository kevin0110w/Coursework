
package oddsandevens;


import java.util.*;

public class OddsAndEvens {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Let's play a game called \"Odds and Evens\".");
        System.out.println("What is your name?");
        String name = s.nextLine();
        System.out.println("Hi " + name + ", which do you choose? (O)dds or (E)vens?");
        String input = s.nextLine();
        if (input.equals("O")) {
            System.out.println(name + " has picked odds! The computer will be evens.");
        } else {
            System.out.println(name + " has picked evens! The computer will be odds.");
        }
        
        System.out.println("--------------------------------------------------------");
        
        System.out.println("How many \"fingers\" do you put out?");
        int userNumber = Integer.parseInt(s.nextLine());
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The computer plays " + computer + " \" fingers\".");
        System.out.println("--------------------------------------------------------");
        int sum = userNumber + computer;
        System.out.println(userNumber + " + " + computer + " = " + sum);
        boolean oddOrEven = sum % 2 == 0;
        if (oddOrEven) {
            System.out.println(sum + " is even!");
            if (userNumber % 2 == 0) {
                System.out.println("That means " + name + " wins!!!");
            } else {
                System.out.println("Computer is the winner!");
        }
        }else {
            System.out.println(sum + " is odd!"); 
            if (!(userNumber % 2 == 0)) {
                System.out.println("That means " + name + " wins!!!");
            } else {
                System.out.println("Computer is the winner!");
        }
        System.out.println("--------------------------------------------------------");
        
        }
    
    }
}
