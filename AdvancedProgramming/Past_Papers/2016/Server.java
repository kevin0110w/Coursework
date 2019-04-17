import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Server {
  private static final int PORT = 8765;
  private ServerSocket listener;
  private StudentDatabase sd;
  private Socket client;
  private ArrayList<ClientThread> allClients = new ArrayList<ClientThread>();

  public void runServer(StudentDatabase sd) {
    try {
      listener = new ServerSocket(PORT);
      while (true) {
        client = listener.accept();
        this.sd = sd;
        ClientThread newClient = new ClientThread(client, sd, allClients);
        allClients.add(newClient);
        newClient.start();
    }
  } catch (Exception e) {
  }finally {
      try {
        listener.close();
      } catch (Exception e) {

      }
    }
  }

public static class ClientThread extends Thread {
  private Socket client;
  private PrintWriter out;
  private Scanner in;
  private ArrayList<ClientThread> allClients;
  private StudentDatabase sd;

  public ClientThread(Socket socket, StudentDatabase sd, ArrayList<ClientThread> threads) {
    this.client = socket;
    this.allClients = threads;
    this.sd = sd;
  }

  public void run() {
    try {
        out = new PrintWriter(client.getOutputStream(), true);
        in = new Scanner(client.getInputStream());
        String response;
        while (true) {
          String command = in.next();
          if (command == null) {
            break;
          } else if (command.equals("name")) {
            String matric = in.next();
            String name = sd.getName(matric);
            out.println(name);
          } else if (command.equals("programme")) {
            String matric = in.next();
            String programme = sd.getProgramme(matric);
            out.println(programme);
          }
        }
    } catch (Exception e) {

    }
  }
}

  public static void main(String[] args) {
    StudentDatabase sd = new StudentDatabase();
    Student kw = new Student("Kevin", "SD", "999999");
    sd.addStudent(kw);
    new Server().runServer(sd);
  }
}
