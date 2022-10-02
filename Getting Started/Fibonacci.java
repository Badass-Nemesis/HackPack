import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        //Logic used here to solve fibonnaci sequence is without recursion.
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int a = 0, b = 1;
        // if (n == a || n == b) {
        //     System.out.println(n);
        // } 
        // else {
        //     System.out.println(a);
        //     System.out.println(b);
        //     for (int i = 2; i < n; i++) {
        //         int c = a + b;
        //         System.out.println(c);
        //         a = b;
        //         b = c;
        //     }
        // }
        Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      
      int a = 0;
      int b = 1;
      for(int i = 0; i < n; i++){
          System.out.println(a);
           int c = a + b;
           a = b;
           b = c;
      }
    }
}
