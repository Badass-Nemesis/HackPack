import java.util.*;

public class Print_Decreasing {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printDecreasing(n);
    }

    public static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printDecreasing(n - 1);
        // if(n>0){System.out.println(n);
        // printDecreasing(n-1);}
        // else{
        // return;
        // }
    }
}