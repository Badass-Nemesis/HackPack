import java.util.*;

public class Print_Factorial {
    public static void main(String[] args){
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int f = factorial(n);
        System.out.println(f);
    }

    public static int factorial(int n){
        if(n==1) return 1;
        // if(n==0) return 1;
        int factorialnminus1 = factorial(n-1);
        int factorialn = n * factorialnminus1;
        return factorialn;
    }
}
