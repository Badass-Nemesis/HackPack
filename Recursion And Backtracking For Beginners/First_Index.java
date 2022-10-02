import java.util.*;

public class First_Index {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int d = scn.nextInt();
        System.out.println(firstIndex(arr, 0, d));
    }

    public static int firstIndex(int[] arr, int idx, int x) {
        if(idx==arr.length) return -1;
        if (arr[idx] == x) {
            return idx;
        } else {
            int fiisa = firstIndex(arr, idx + 1, x);
            return fiisa;
        }

        // if(idx==arr.length) return -1;
        // int fiisa = firstIndex(arr, idx+1, x);
        // //fiisa = first index in samller array
        // if(arr[idx]==x) return idx;
        // else return fiisa;
    }

}