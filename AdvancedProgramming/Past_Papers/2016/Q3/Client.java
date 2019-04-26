import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
  private static int PORT;
  private static String IP;

  public static void main(String[] args) {
    PORT = 8765;
    IP = "127.0.0.1";
    Socket client = null;
    Scanner scanner = null;
    PrintWriter out = null;
    BufferedReader in = null;
    try {
      client = new Socket(IP, PORT);
      scanner = new Scanner(System.in);
      out = new PrintWriter(client.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      while (true) {
        System.out.println("name or programme or q to quit");
        String command = scanner.nextLine();
        boolean correctlyEntered = false;
        while (!correctlyEntered) {
        if (command.equals("q")) {
          break;
        } else if (!(command.equals("name") || command.equals("programme"))) {
          System.out.println("Please try again");
          System.out.println("name or programme or q to quit");
          command = scanner.nextLine();
          correctlyEntered = true;
        }
      }
        out.println(command);
        System.out.println("Please enter matric for person of interest");
        String matric = scanner.nextLine();
        out.println(matric);
        String result = in.readLine();
        System.out.println(result);
      }
      }  catch (Exception e) {
      } finally {
        try {
          client.close();
          scanner.close();
          in.close();
          out.close();
        } catch (Exception e) {

        }
      }
    }
  }
