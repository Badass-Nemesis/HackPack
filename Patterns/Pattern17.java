import java.util.*;

public class Pattern17 {
  public static void main(String[] args)
  {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int sp = n / 2; //variable to store space count
    int st = 1;     //variable to store star count
    for (int i = 1; i <= n; i++)
    {
      for (int j = 1; j <= sp ; j++) //printing whitespaces
      {
        if ( i == n / 2 + 1)    //checking middle row
        {
          System.out.print("*	");
        }
        else
        {
          System.out.print("	");
        }
      }
      for (int j = 1 ; j <= st; j++) // printing the stars
      {
        System.out.print("*	");
      }
      if ( i <= n / 2)    //checking if less than or equal to middle row
      {
        st++;       //increasing stars till middle row
      }
      else {
        st--;       //decreasing stars post middle row
      }
      System.out.println(); //Changing the row
    }
  }
}