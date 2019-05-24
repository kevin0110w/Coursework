import java.io.*;
import java.util.*;

public class Log {
  private PrintWriter out;
  private String fileContent;

  public Log(String fileContent) {
    this.fileContent = fileContent;
  }
  public void addLine(String string) {
    this.fileContent += string + "\n";
  }
  public void write() {
    try {
      File statement = new File("statement.txt");
      out = new PrintWriter(statement);
      out.write(this.fileContent);
    }  catch (Exception exception) {
    } finally {
      try {
        out.close();
      } catch (Exception e) {

      }
    }
  }
}
