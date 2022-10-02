import java.util.*;
 
public class Pattern9 {
  public static void main(String[] args)
  {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    for (int i = 1; i <= n; i++){ //decides the number of rows for output printing  
      for (int j = 1; j <= n; j++) //prints the stars in the row
      {
        if (i == j || i + j == n + 1)
          System.out.print("*\t");
        else
          System.out.print("\t");
      }
    System.out.println(); //changes the row on output console  
    }
  }
}