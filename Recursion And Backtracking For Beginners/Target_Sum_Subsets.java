import java.io.*;
import java.util.*;

public class Target_Sum_Subsets {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i]=scn.nextInt();
        }
        int target = scn.nextInt(); 
        printTargetSumSubsets(arr, 0, "", 0, target);
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if(sos>tar){
            return;
        }
        //write this above code to not get runtime error
        
        if(idx==arr.length){
            if(sos==tar){
                System.out.println(set+".");
            }
            return;
        }

        printTargetSumSubsets(arr, idx+1, set+arr[idx]+", ", sos+arr[idx], tar);
        printTargetSumSubsets(arr, idx+1, set, sos, tar);
    }

}