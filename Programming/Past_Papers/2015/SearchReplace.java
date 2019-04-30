import java.io.*;
import java.util.*;

public class SearchReplace
{  private static final String inputFile = "input.txt";
   private static final String outputFile = "output.txt";
   private static final String queryString = "organisation";
   private static final String replaceString = "organization";

   public static void main(String[] args)
   {  FileReader fr = null;
      FileReader reader2 = null;
      Scanner reader_i = null;
      Scanner reader_o = null;
      String line = "";
     {
      PrintWriter pw = null;
      try
      {  try
         {
           File in = new File("input.txt");
           File o = new File("output.txt");
           fr = new FileReader(in);
           reader2 = new FileReader(o);
           reader_i = new Scanner(fr);
           reader_o = new Scanner(reader2);
           pw = new PrintWriter("output.txt");
           while (reader_i.hasNextLine()) {
             String temp = reader_i.nextLine();
             if (temp.contains(queryString)) {
               // for (int i = 0; i < temp.
                    temp = temp.replaceAll(queryString, replaceString);
                 }
             line = line + temp + "\n";
           }
           pw.write(line);
         }
         finally
         {  if (fr != null)
               fr.close();
            if (pw != null)
               pw.close();
         }
      }
      catch (IOException exception)  {
        System.out.println("I/O ERROR: " + exception);
      }
   }
}
}
