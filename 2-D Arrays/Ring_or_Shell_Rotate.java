import java.util.*;

public class Ring_or_Shell_Rotate {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[i][j]=scn.nextInt();;
            }
        }
        int s = scn.nextInt();
        int r = scn.nextInt();

        rotateShell(arr,s,r);
        display(arr);
    }

    public static void rotateShell(int[][] arr,int s,int r){
        int[] oned = fillOnedFromShell(arr,s); 
        rotate(oned,r);
        fillShellFromOned(arr,s,oned);
    }

    public static void rotate(int[]arr,int r){
        r=r%arr.length;
        if(r<0){
            r=r+arr.length;
        }
        reverse(arr,0,arr.length-r-1);
        reverse(arr,arr.length-r,arr.length-1);
        reverse(arr,0,arr.length-1);
    }

    public static void reverse(int[] arr, int i, int j){
        while(i<j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }

    
    public static int[] fillOnedFromShell(int[][]arr, int s){
        int minr = s-1;
        int minc = s-1;
        int maxr = arr.length-s;
        int maxc = arr[0].length-s;
        //left wall = (min row - max row + 1) = right wall, top wall = (min column - max column + 1) = bottom wall
        //4 minus isiliye, kyunki corners wale number repeat ho jaa rahe h har corner pe
        int size =  2*(maxr - minr + maxc - minc);
        //i.e. size = 2*(maxr-minr+1)+2*(maxc-minc+1)-4
        
        int[] oned = new int [size];
        int index = 0;
        //left wall
        for(int i = minr,j=minc;i<=maxr;i++){
            oned[index] = arr[i][j];
            index++;
        }
        
        //bottom wall
        for(int i = maxr,j=minc+1;j<=maxc;j++){
            oned[index] = arr[i][j];
            index++;
        }
        
        //right wall
        for(int i = maxr-1,j=maxc;i>=minr;i--){
            oned[index] = arr[i][j];
            index++;
        }
        
        //top wall
        for(int i = minr,j=maxc-1;j>minc;j--){
            oned[index] = arr[i][j];
            index++;
        }

        return oned;
    }

    public static void fillShellFromOned(int[][] arr,int s,int[]oned){
        int minr = s-1;
        int minc = s-1;
        int maxr = arr.length-s;
        int maxc = arr[0].length-s;
        
        int index = 0;
        //left wall
        for(int i = minr,j=minc;i<=maxr;i++){
            arr[i][j] = oned[index];
            index++;
        }

        //bottom wall
        for(int i = maxr,j=minc+1;j<=maxc;j++){
            arr[i][j] = oned[index];
            index++;
        }

        //right wall
        for(int i = maxr-1,j=maxc;i>=minr;i--){
            arr[i][j] = oned[index];
            index++;
        }

        //top wall
        for(int i = minr,j=maxc-1;j>minc;j--){
            arr[i][j] = oned[index];
            index++;
        }
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