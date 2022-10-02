import java.util.*;
public class GCD_LCM {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        int n1= num1;
        int n2= num2;
        int rem = 0;
        //Logic -> Pehle divide a by b, uska jo remainder aayega usko then set as divisor aur divide 'b' by that remainder.
        // Repeat untill remainder = 0. Euclid's algorithm h ye, bachpan mein jo padhe the.
        while(num1 % num2 !=0){
            rem = num1 % num2;
            num1=num2;
            num2=rem;
        }
        int gcd = num2;
        //Logic -> LCM = a*b/GCD & GCD = a*b/LCM
        int lcm = (n1*n2)/gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }    
}
