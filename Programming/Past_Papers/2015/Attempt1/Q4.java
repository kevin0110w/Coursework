import java.io.*;
import java.util.*;

public class SearchReplace
{  private static final String inputFile = "input.txt";
   private static final String outputFile = "output.txt";
   private static final String queryString = "organisation";
   private static final String replaceString = "organization";

   public static void main(String[] args)
   {  FileReader reader = null;
      FileReader reader2 = null;
      Scanner reader_i = null;
      Scanner reader_o = null;
      String line = "";
     {
      PrintWriter out = null;
      try
      {  try
         {
           File i = new File("input.txt");
           File o = new File("output.txt");
           reader = new FileReader(i);
           reader2 = new FileReader(o);
           reader_i = new Scanner(reader);
           reader_o = new Scanner(reader2);
           while (reader_i.hasNextLine()) {
             String temp = reader_i.readLine();
             if (temp.contains(queryString)) {
               for (int i = 0; i < temp.length(); i++) {
                 if (temp.charAt(i).equals(queryString.charAt(i) && temp.charAt(11).equals(queryString.charAt(11)))) {
                   temp.substring(i,i+10) = replaceString;
                 }
               }
             }
             // line = line + reader.readLine();
             line = line + temp + "\n";


           }
           output.write(line);
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
