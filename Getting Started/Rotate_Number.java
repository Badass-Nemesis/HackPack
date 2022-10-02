import java.util.*;

public class Rotate_Number {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int d = 0;
        for (int i = n; i != 0; d++) {
            i = i / 10;
        }
        // My code for Rotate Number.
        // int temp = n;
        // int dig = d;
        // if (k > d) {
        // k = k % d;
        // }
        // for(;k<0;){
        // k+=d;
        // }
        // int x = (temp % (int) Math.pow(10, k));
        // temp = x * (int) Math.pow(10, dig - k) + temp / (int) Math.pow(10, k);
        // System.out.println(temp);

        // Pepcoding code for Rotate Number.

        k = k % d;
        if (k < 0) {
            k += d;
        }

        int div = 1;
        int mult = 1;
        for (int i = 1; i <= d; i++) {
            if (i <= k) {
                div *= 10;
            } else {
                mult *= 10;
            }
        }
        int q = n / div;
        int r = n % div;

        int rot = r * mult + q;
        System.out.println(rot);
    }
}