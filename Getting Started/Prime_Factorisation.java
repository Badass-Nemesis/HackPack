import java.util.*;
public class Prime_Factorisation {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //Logic -> same as finding prime numbers. 'i' ko 'n' sq. root tak hi iterate kar ke divide karenge.
        for(int i = 2; i*i<=n;i++){
            while(n%i==0){
                n=n/i;
                System.out.print(i);
            }
        }
        //Logic -> agar n = 1 nahi aa raha h divide karte rehne par bhi, iska matlab ek last prime factor
        //bacha hua h. Usse darne ki jarurat ni h, direct usko print kar dena h. Kyunki agar wo 'n' root
        //tak divide hoke 1 ni aaya h, to iska matlab ek koi prime number hi bacha h last mein.
        if(n!=1){
            System.out.print(n);
        }
    }
}