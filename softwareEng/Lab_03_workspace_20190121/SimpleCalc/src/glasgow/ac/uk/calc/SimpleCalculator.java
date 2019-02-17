package glasgow.ac.uk.calc;

//import Scanner as we require it.
import java.util.Scanner;

//the name of our class its public
public class SimpleCalculator {
  //void main
      public static void main (String[] args)
      {
          //declare int and char
          int a,b,result=0;
          char c;

          //Declare input as scanner
          Scanner input = new Scanner(System.in);

          //Take inputs
           System.out.println("Enter no. :");
           a = input.nextInt();
           System.out.println("Enter no. :");
           b = input.nextInt();
           System.out.println("Enter Operator :");
           String st = input.next();
           c = st.charAt(0);
           
           calculate(a,b,c);
           
      }
      
      public static int calculate(int a, int b, char c) {

    	  int result=-1;
    	  
          //add a switch statement
          switch(c)
          {
          case '+':
              result = a+b;
              return result;
           
          case '-':
              result = a-b;
              return result;
      
          case 'x':
              result = a*b;
              return result;
     
          case '/':
              result = a/b;
              return result;
         
          default:
             return (Integer) null;
          }
      }
}
