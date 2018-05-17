import java.util.*;
import java.io.*;
import java.awt.event.KeyEvent;

public class test
{
   public static MyQueue<String> list = new MyQueue<String>();
   public static void main(String [] arg)
   {
      //inputWords();
      System.out.println(list);
   }
   
   public static void inputWords()
   {
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File("words.txt"));
      }
      catch(FileNotFoundException e)
      {
         System.out.println("words.txt not found.");
         System.exit(0);
      }
      
      while((list == null || list.size() < 20) && infile.hasNextLine())
         list.add(infile.nextLine());
   }
}