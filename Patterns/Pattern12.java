import java.util.*;

public class Pattern12 {
  public static void main(String[] args)
  {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int a = 0, b = 1; // First two Fibonacci numbers
    for (int i = 1; i <= n; i++)
    {
      for (int j = 1; j <= i; j++)
      {
        System.out.print(a + "	");
        int c = a + b; //Since next fibonacci number is sum of
        a = b; //previous two fibonacci numbers  
        b = c;
      }
      System.out.println();
    }
  }
}