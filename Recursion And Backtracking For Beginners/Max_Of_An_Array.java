import java.util.*;

public class Max_Of_An_Array {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(maxOfArray(arr, 0));
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx == arr.length -1) return arr[idx];
        //misa = max in smaller array
        int misa = maxOfArray(arr, idx + 1);
        if(misa>arr[idx]){
            return misa;
        }
        else{
            return arr[idx];
        }
    }

}