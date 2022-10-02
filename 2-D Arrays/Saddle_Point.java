//Saddle Point = least valued element in a row, and then element should be highest valued element in that same column.
//Saddle point could be zero or one in a 2-d matrix, but not more than one.

import java.util.*;

public class Saddle_Point {
    public static void main(String[] args){
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int[][] arr = new int [n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                arr[i][j]= scn.nextInt();
            }
        }

        for(int i = 0; i<n;i++){
            int small_c = 0;
            for(int j = 1; j<n; j++){
                if(arr[i][j]<arr[i][small_c]){
                    small_c = j;
                }
            }

            boolean flag = true;
            for(int k = 0; k<n; k++){
                if(arr[k][small_c]>arr[i][small_c]){
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                System.out.println(arr[i][small_c]);
                return;
            }
        }
        System.out.println("Invalid input");
    }  
}
