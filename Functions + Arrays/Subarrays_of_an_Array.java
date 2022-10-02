import java.util.*;

public class Subarrays_of_an_Array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        for (int itr = 0; itr < arr.length; itr++) {
            for (int j = itr; j < arr.length; j++) {
                for(int k=itr;k<=j;k++){
                    System.out.print(arr[k]+"\t");
                }
                System.out.println();
            }
        }
    }
}