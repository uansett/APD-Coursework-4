package johansen.stian.apd.cw4;
import java.util.Iterator;
import java.util.Scanner;

class UseStringSets2
{
// String set maintenance program, with iterator test at end

 public static void main(String[] args) 
 {
  Scanner in = new Scanner(System.in);
  MySet<String> set = new MySet<String>();
  System.out.print(": ");
  String line = in.nextLine();
  while(line.charAt(0)!='q')
     {
      String[] words;
      switch(line.charAt(0))
         {
          case 's' : 
                System.out.println(set.size());
                break;
          case 'p' : 
                System.out.println(set);
                break;
          case 'i' : 
                words=line.split(" ");
                for(int i=1; i<words.length; i++)
                   set.insert(words[i]);
                break;
          case 'r' : 
                words=line.split(" ");
                for(int i=1; i<words.length; i++)
                   set.remove(words[i]);
                break;
          case 'm' :
                words=line.split(" ");
                for(int i=1; i<words.length; i++)
                   System.out.println(set.isIn(words[i]));
                break; 
          default:
                System.out.print("i - insert, r - remove, m - member,");
                System.out.println(" p - print, s - size, q - quit");
                break;
         } 
      System.out.print(": ");
      line = in.nextLine();
     }
  System.out.print("\nEnter a string length: ");
  int n = in.nextInt();
  Iterator<String> it = new Filter<String>(set.iterator(),new LongerThan(n));
  System.out.println("Set elements length greater than "+n+":\n");
  while(it.hasNext())
      System.out.println("  "+it.next());
 }
 private static class LongerThan implements Checker<String>{
 private int value;
     private LongerThan(int n){
         value = n;
     }
        @Override
        public boolean check(String obj) {
            return (obj.length() > value);
        }
 }
}