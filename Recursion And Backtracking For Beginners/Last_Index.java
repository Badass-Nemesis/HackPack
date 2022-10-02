import java.util.*;

public class Last_Index {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int d = scn.nextInt();
        System.out.println(lastIndex(arr, n-1, d));
    }

    public static int lastIndex(int[] arr, int idx, int x){
        // if(idx==arr.length) return -1;
        // int liisa = lastIndex(arr, idx+1, x);
        // //liisa = last index in smaller array
        // if(idx==-1){    
        //     if(arr[idx]==x){
        //         return idx;
        //     }
        //     else return -1;
        // }
        // else return liisa;
        if(idx>0) return -1;
        if (arr[idx] == x) {
            return idx;
        } else {
            int fiisa = lastIndex(arr, idx - 1, x);
            return fiisa;
        }
    }

}