import java.util.*;
public class Decimal_To_Any_Base {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
     }
    
     public static int getValueInBase(int n, int b){
        int rv = 0;
        int p = 0;
        while(n>0){
            int dig = n%b;
            n=n/b;
            rv = rv+ dig*(int)Math.pow(10,p);
            p++;
        } 
        return rv;
     }
}
