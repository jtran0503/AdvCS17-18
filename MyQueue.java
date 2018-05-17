  //d oberle 2005
  
public class MyQueue<E> implements Queueable<E>
{
   private java.util.LinkedList<E> list;
   
   public MyQueue()
   {
      list = new java.util.LinkedList<E>();
   }
   
   public void add(E x)
   {
      list.add(x);
   }
   
   public E remove()
   {
      if(list.size() > 0)
      {
         E x = list.get(0);
         list.remove(0);
         return x;
      }
      return null;
   }
   
   public boolean isEmpty()
   {
      if(list.size() > 0)
         return false;
      return true;
   }
   
   public E peek()
   {
      return list.get(0);
   }
   
   public int size()
   {
      return list.size();
   }
   
   public String toString()
   {
      String ans = "";
      
      for(int i = 0; i < 10; i++)
         ans += list.get(i) + "   ";
         
      ans += "\n";
      
      for(int i = 10; i < 20; i++)
         ans += list.get(i) + "   ";
         
      return ans;
   }
   
}