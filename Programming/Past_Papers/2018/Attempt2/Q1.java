public class Q1 {
  public static void main(String[] args) {
    Console bigConsole = new Console(100,100); // This is the big
// console
Console smallConsole = new Console(10,10); // This is the small
// console

bigConsole.println(“Boltzmann”);
smallConsole.println(“Einstein”);

bigConsole = smallConsole;

bigConsole.println(“Maxwell”);

String name = “Feynman”; 


/**
Boltsmann will be printed on big Console
Einstein will be printed on small Console
Maxwell will be printed on a small Console
It's possible to print Feynman on the big Console
providing a new bigconsole object is created
and bigConsole was assigned to refer to the same
object
**/

  }
}
