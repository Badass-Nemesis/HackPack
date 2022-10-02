import java.util.*;

public class Spiral_Display {
    public static void main(String[] args){
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scn.nextInt();
            }
        }

        int minr = 0;
        int minc = 0;
        int maxr = arr.length-1;
        int maxc = arr[0].length-1;
        int total_ele=n*m;
        int count = 0;
        while(count<total_ele){
            // left wall
            for(int i=minr,j=minc;i<=maxr && count<total_ele;i++){
                System.out.println(arr[i][j]);
                count++;
            }
            minc++;
            
            //bottom wall
            for(int i=maxr,j=minc;j<=maxc && count<total_ele;j++){
                System.out.println(arr[i][j]);
                count++;
            }
            maxr--;

            //right wall
            for(int i=maxr,j=maxc;i>=minr & count<total_ele;i--){
                System.out.println(arr[i][j]);
                count++;
            }
            maxc--;

            //top wall
            for(int i=minr,j=maxc;j>=minc && count<total_ele;j--){
                System.out.println(arr[i][j]);
                count++;
            }
            minr++;
        }
    }
}
