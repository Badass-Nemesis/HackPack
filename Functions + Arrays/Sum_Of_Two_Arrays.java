import java.util.*;

public class Sum_Of_Two_Arrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scn.nextInt();
        }
        // int max = 0;
        // if(n1<=n2){
        // max = n2;
        // }
        // else{
        // max = n1;
        // }
        // int[] sum = new int[max];

        // see below new and short code for above one.
        int[] sum = new int[n1 > n2 ? n1 : n2];
        // iska matlab -> is n1>n2? if True, then input = n1, if Flase then n2. Basically a true false code.
        int c = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = sum.length - 1;

        while (k >= 0) {
            int d = c;
            if (i >= 0) {
                d += arr1[i];
            }
            if (j >= 0) {
                d += arr2[j];
            }

            c = d / 10;
            d = d % 10;
            sum[k] = d;

            i--;
            j--;
            k--;
        }

        if (c != 0) {
            System.out.println(c);
        }

        for (int val : sum)
        // this line will give direct values that are stored in array, instead of index
        {
            System.out.println(val);
        }
    }
}
