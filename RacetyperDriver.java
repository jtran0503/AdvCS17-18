import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class RacetyperDriver
{
   public static RacetyperPanel screen;				   //Game window
   public static JFrame frame;
   public static int width, height;                //resizable dimensions

   public static void main(String[]args)
   {
      screen = new RacetyperPanel();
      frame = new JFrame("Racetyper 0.2.0");	                     //window title
      width = 30*screen.SIZE;
      height = 20*screen.SIZE;
      frame.setSize(width, height);					   //Size of game window
      frame.setLocation(200, 100);				         //location of game window on the screen
      frame.setExtendedState(JFrame.NORMAL);  	   //MAXIMIZED_BOTH, MAXIMIZED_VERT, or ICONIFIED
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(screen);		
      frame.setVisible(true);
      frame.addKeyListener(new listen());		      //Get input from the keyboard
   }
   
   public static class listen implements KeyListener 
   {
      
      public void keyTyped(KeyEvent e)
      {
         
      }
         
      public void keyPressed(KeyEvent e)
      {
         int k = e.getKeyCode();            
         if(k==KeyEvent.VK_SHIFT)
            screen.shiftPressed=true;
         else
            screen.processUserInput(k);
      }
      
      public void keyReleased(KeyEvent e)
      {
         int k = e.getKeyCode();
         if(k==KeyEvent.VK_SHIFT)
            screen.shiftPressed=false;
      }
   }
   
}