import java.util.*;

public class Power_Logarithmic {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int p = power(x,n);
        System.out.println(p);
    }

    public static int power(int x, int n){
        if(n==0) return 1;
        int xpowernby2 = power( x, n/2);
        int xpowern = xpowernby2 * xpowernby2;
        
        if(n%2!=0){
            xpowern = xpowern * x;
        }
        return xpowern;
    }
}