import java.util.*;

public class Power_Recursion {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int xn = power(x,n);
        System.out.println(xn);
    }

    public static int power(int x, int n){
        if(n==0) return 1;
        int xpowernminus1 = power(x, n-1);
        int xpowern = x * xpowernminus1;
        return xpowern;
    }
}
