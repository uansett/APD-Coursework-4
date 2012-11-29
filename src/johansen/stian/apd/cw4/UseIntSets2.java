/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package johansen.stian.apd.cw4;
import java.util.*;

class UseIntSets2
{
// Integer set maintenance program, with iterator test

 public static void main(String[] args) 
 {
  Scanner in = new Scanner(System.in);
  MySet<Integer> set = new MySet<Integer>();
  System.out.print(": ");
  String line = in.nextLine();
  while(line.charAt(0)!='q')
     {
      String[] numbers;
      switch(line.charAt(0))
         {
          case 's' : 
                System.out.println(set.size());
                break;
          case 'p' : 
                System.out.println(set);
                break;
          case 'i' : 
                numbers=line.split(" ");
                for(int i=1; i<numbers.length; i++)
                   set.insert(new Integer(numbers[i]));
                break;
          case 'r' : 
                numbers=line.split(" ");
                for(int i=1; i<numbers.length; i++)
                   set.remove(new Integer(numbers[i]));
                break;
          case 'm' :
                numbers=line.split(" ");
                for(int i=1; i<numbers.length; i++)
                   System.out.println(set.isIn(new Integer(numbers[i])));
                break; 
          default:
                System.out.print("i - insert, r - remove, m - member,");
                System.out.println(" p - print, s - size, q - quit");
                break;
         } 
      System.out.print(": ");
      line = in.nextLine();
     }
  Iterator<Integer> it = new Filter<Integer>(set.iterator(),new Odd());
  System.out.println("Odd set elements are:\n");
  while(it.hasNext())
      System.out.println("  "+it.next());
 }
 
 private static class Odd implements Checker<Integer>{
        @Override
        public boolean check(Integer obj) {
            return (obj.intValue() % 2 != 0);
        }
 }
}
