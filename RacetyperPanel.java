import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.PrintWriter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.*;
import java.io.*;


public class RacetyperPanel extends JPanel implements MouseListener
{
   protected static int SIZE = 30;  //size of cell being drawn
   protected static int mouseX;		//locations for the mouse pointer
   protected static int mouseY;
   
   private String line = "";
   protected static boolean shiftPressed;                //is shift being held down?
   
   private MyQueue<String> wordList = new MyQueue<String>();
   
   
   //**IMAGES**
   private ImageIcon RedCar = new ImageIcon("Images/RedCar.png");
   private ImageIcon Window = new ImageIcon("Images/Window.png");
   
   
   public RacetyperPanel()
   { 
      //addMouseListener(this);
      //mouseX = 0;
      //mouseY = 0;
      
      shiftPressed = false;
   }
  
   public void inputWords()
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
      
      while((wordList == null || wordList.size() < 20) && infile.hasNextLine())
      {
         wordList.add(infile.nextLine());
      }
   }
  
   //**GRAPHICS**
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.setColor(Color.white);		//set background color to white
      g.fillRect(0, 0, 3000, 2000); //fill the whole window with white
      g.setColor(Color.gray);       //set bg color to gray for control window
      g.fillRect(0, 0, 1500, 90);
      g.drawImage(Window.getImage(), 20, 150, 500, 250, null);
      //DRAW THE CONTROLS AND INFO
      
      inputWords();
      g.setColor(Color.black);
      g.setFont(new Font("SansSerif", Font.BOLD, 16)); 
      drawString(g, wordList.toString(), 20, 20);
      g.drawString(line, 20, 150);
      
   }
   
   public void drawString(Graphics g, String text, int x, int y) 
   {
      for (String line : text.split("\n"))
         g.drawString(line, x, y += g.getFontMetrics().getHeight());
   }

   public void processUserInput(int k)
   {  
      if(k == KeyEvent.VK_ESCAPE) //Exits if user presses escape
         System.exit(1);
      else if(k == KeyEvent.VK_SPACE) //space
         line += " ";
      else if(k == KeyEvent.VK_BACK_SPACE) //removes a letter
      {
         if(line.length() > 0)
            line = line.substring(0,line.length()-1);
      }
      else if(k == KeyEvent.VK_COMMA) //comma
      {
         if(shiftPressed)
            line += "<";
         else
            line += ",";
      }
      else if(k == KeyEvent.VK_PERIOD) //period
      {
         if(shiftPressed)
            line += ">";
         else
            line += ".";
      }
      else if(k == KeyEvent.VK_SLASH) //forward slash
      {
         if(shiftPressed)
            line += "?";
         else
            line += "/";
      }
      else if(k == KeyEvent.VK_SEMICOLON) //semicolon
      {
         if(shiftPressed)
            line += ":";
         else
            line += ";";
      }
      else if(k == KeyEvent.VK_QUOTE) //quotes
      {
         if(shiftPressed)
            line += "\"";
         else
            line += "'";
      }
      else if(k == KeyEvent.VK_OPEN_BRACKET) //open bracket
      {
         if(shiftPressed)
            line += "{";
         else
            line += "[";
      }  
      else if(k == KeyEvent.VK_CLOSE_BRACKET) //close bracket
      {
         if(shiftPressed)
            line += "}";
         else
            line += "]";
      }
      else if(k == KeyEvent.VK_BACK_SLASH) //back slash
      {
         if(shiftPressed)
            line += "|";
         else
            line += "\\";
      }
      else if(k==KeyEvent.VK_1)
      {
         if(shiftPressed)
            line += "!";
         else
            line += "1";
      }
      else if(k==KeyEvent.VK_2)
      {
         if(shiftPressed)
            line += "@";
         else
            line += "2";
      }
      else if(k==KeyEvent.VK_3)
      {
         if(shiftPressed)
            line += "#";
         else
            line += "3";
      }
      else if(k==KeyEvent.VK_4)
      {
         if(shiftPressed)
            line += "$";
         else
            line += "4";
      }
      else if(k==KeyEvent.VK_5)
      {
         if(shiftPressed)
            line += "%";
         else
            line += "5";
      }
      else if(k==KeyEvent.VK_6)
      {
         if(shiftPressed)
            line += "^";
         else
            line += "6";
      }
      else if(k==KeyEvent.VK_7)
      {
         if(shiftPressed)
            line += "&";
         else
            line += "7";
      }
      else if(k==KeyEvent.VK_8)
      {
         if(shiftPressed)
            line += "*";
         else
            line += "8";
      }
      else if(k==KeyEvent.VK_9)
      {
         if(shiftPressed)
            line += "(";
         else
            line += "9";
      }
      else if(k==KeyEvent.VK_0)
      {
         if(shiftPressed)
            line += ")";
         else
            line += "0";
      }
      else if(k==KeyEvent.VK_MINUS)
      {
         if(shiftPressed)
            line += "_";
         else
            line += "-";
      }
      else if(k==KeyEvent.VK_EQUALS)
      {
         if(shiftPressed)
            line += "+";
         else
            line += "=";
      }
      else if(k==KeyEvent.VK_BACK_QUOTE)
      {
         if(shiftPressed)
            line += "~";
         else
            line += "`";
      }
      else if(shiftPressed)
         line += KeyEvent.getKeyText(k);
      else 
         line += KeyEvent.getKeyText(k).toLowerCase();
      repaint();
   }
   
   public void mouseMoved(MouseEvent e)
   {}
   public void mousePressed(MouseEvent e)
   {}
   public void mouseReleased(MouseEvent e)
   {}
   public void mouseEntered(MouseEvent e)
   {}
   public void mouseClicked(MouseEvent e)
   {}
   public void mouseDragged(MouseEvent e)
   {}
   public void mouseExited(MouseEvent e)
   {}
   
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)	//this is called for each timer iteration
      {
         repaint();
      }
   }
      
}

/*                **EXTRA STUFF**
   //g.drawImage(RedCar.getImage(), mouseX-15, mouseY-15, SIZE, SIZE, null);
*/