import java.util.*;

public class Digits {
    public static void main(String [] args){
        //Below code is printing how many number of digits there are in the input number
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = 0;
        int k = n;
        for(int i = n;i!=0;d++){
            i=i/10;
        }
        System.out.println(d);
        //Code for printing digits of a number line by line (left to right)
        int j = (int)Math.pow(10,d-1);
        while(j>0){
            int d1=n/j;
            System.out.println(d1);
            n=n%j;
            j=j/10;
        }
        //Code for printing digits of a number line by line (right to left)
        while(k!=0){
            int m = k%10;
            System.out.println(m);
            k=k/10;
        }
    }
}