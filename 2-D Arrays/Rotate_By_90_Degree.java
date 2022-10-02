import java.util.*;

public class Rotate_By_90_Degree {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                arr[i][j]=scn.nextInt();
            }
        }

        //transpose
        for(int i = 0;i<arr.length;i++){
            for(int j = i;j<arr[0].length;j++){
                int temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }

        //reversing rows, so that 1st column becomes last column, 2nd column becomes 2nd last column etc......
        //matlab array ka half se pehle wala ko array ke half ke baad wale se interchange kar denge
        //since ye change karne mein bas column change hoga, row ni, isiliye for loop mein row chalega aur neeche column
        for(int i = 0;i<arr.length;i++){
            int left_index=0;
            int right_index=arr[i].length-1;
            while(left_index<right_index){
                int temp = arr[i][left_index];
                arr[i][left_index]=arr[i][right_index];
                arr[i][right_index]=temp;

                left_index++;
                right_index--;
            }
        }

        display(arr);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}