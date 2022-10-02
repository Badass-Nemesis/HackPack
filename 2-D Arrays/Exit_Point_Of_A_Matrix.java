import java.util.*;

public class Exit_Point_Of_A_Matrix {
    public static void main(String[] args){
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0; j<m;j++){
                arr[i][j]=scn.nextInt();
            }
        }

        int dir = 0; // 0 -> east, 1 -> south, 2 -> west, 3 -> north
        int i = 0; //row
        int j = 0; //column
        while(i<arr.length && j<arr[0].length){
            dir = (dir + arr[i][j])%4; //ye 2 kaam karega. 3 se bada ho jaane pe wapas cycle chalaayega direction ka
                                       // aur dir = dir+1 or dir+0 ka value bhi dega. 1 hoga to dir change, ni to same.
            if(dir==0)j++; //east jayega to column badhega
            else if(dir==1)i++; //sount jayega to row badhega
            else if(dir==2)j--; //west jayega to column ghatega
            else if(dir==3)i--; //north jayega to row ghatega

            if(i<0){
                i++;
                break;
            }
            else if(j<0){
                j++;
                break;
            }
            else if(i==arr.length){
                i--;
                break;
            }
            else if(j==arr[0].length){
                j--;
                break;
            }
        }

        //agar upar wala if else likhenge to neeche wala likhne ka jarurat ni h. direct print.

        // if(i<arr.length){
        //     System.out.println(i);
        // }
        // else{
        //     System.out.println(i-1);
        // }
        // if(j<arr[0].length){
        //     System.out.println(j);
        // }
        // else{
        //     System.out.println(j-1);
        // }
        System.out.println(i);
        System.out.println(j);
    }    
}
