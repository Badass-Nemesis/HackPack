import java.util.*;
public class Inverse_Number {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //Code for inverse of a number from right to left.
        // int inv = 0;
        // int op = 1;
        // while(n!=0){
        //     int od = n % 10;
        //     int id = op;
        //     int ip = od;
        //     op++;
        //     inv = inv + id * (int)Math.pow(10,ip-1);
        //     n=n/10;
        // }

        //Code for inverse of a number from left to right.
        int d = 0;
        for(int i = n; i !=0; d++){
            i=i/10;
        }
        int inv = 0;
        int op = d;
        while(n!=0){
            int od = n % 10;
            int id = op;
            int ip = od;
            op--;
            inv = inv + id * (int)Math.pow(10,d-ip);
            n=n/10;
        }
        System.out.println(inv);
    }
}