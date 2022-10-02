import java.util.*;

public class First_Index_And_Last_Index {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i]=scn.nextInt();
        }
        int data = scn.nextInt();
        int low = 0;
        int high = n-1;
        int first_index=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(data>arr[mid]){
                low=mid+1;
            }
            else if(data<arr[mid]){
                high=mid-1;
            }
            else{
                first_index=mid;
                high=mid-1;
            }
        }
        System.out.println(first_index);

        low = 0;
        high = n-1;
        int last_index=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(data>arr[mid]){
                low=mid+1;
            }
            else if(data<arr[mid]){
                high=mid-1;
            }
            else{
                last_index=mid;
                low=mid+1;
            }
        }
        System.out.println(last_index);
    }
}
