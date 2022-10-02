import java.util.*;

public class Prime {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int i = 0, j = 0;
        int t = scn.nextInt();
        for (i = 0; i < t; i++) {
            int n = scn.nextInt();
            int divisor = 0;
            // for (j = 1; j <= n; j++) { 
                //normal logic, 2 nested 'for' loop likh ke saara number se divide kar kar ke dekhna ki kitna se divide hua h.
                //agar 2 divisor h, iska matlab prime h. agar 2 se jyada h, to iska matlab prime ni h.
            for (j = 2; j * j <= n; j++) {
                //optimized logic, ek number ka apna sq. root ka number se pehle ek number jarur hota h jisse wo divide ho jaye.
                //isiliye j sq. ko compare karenge n se, aur jaise hi koi ek number bhi mil gaya if ke andar 
                //jo 2 ke baad h, aur divide kar raha h, to usko break kar denge aur print karwa denge non-prime
                if (n % j == 0) {
                    divisor++;
                    break;
                }
            }
            //if (divisor == 2){
            if (divisor == 0) {
                System.out.println("prime");
            } else {
                System.out.println("not prime");
            }
        }
    }
}