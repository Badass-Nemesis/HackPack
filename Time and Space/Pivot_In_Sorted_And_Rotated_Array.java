import java.io.*;
import java.util.*;

public class Pivot_In_Sorted_And_Rotated_Array {

    public static int findPivot(int[] arr) {
        // basically humlog idhar binary search ka use kar rahe h pivot nikaalne ke liye
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < arr[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        // while loop se bahar nikalne pe pivot jo milega wo lo==hi pe hi milega.
        // isiliye kuch bhi likh sakte h return mein, arr[hi] or arr[lo]
        return arr[lo];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = findPivot(arr);
        System.out.println(pivot);
    }

}



// public class Main {

//   public static int findPivot(int[] arr) {
//     int lo = 0, hi = arr.length - 1;
//     while (lo < hi) {
//       int mid = (lo + hi) / 2;
//       if (arr[mid] > arr[hi]) {
//         lo = mid + 1;
//       } else {
//         hi = mid;
//       }
//     }
//     return arr[lo];
//   }

//   public static void main(String[] args) throws Exception {
//     Scanner scn = new Scanner(System.in);
//     int n = scn.nextInt();
//     int[] arr = new int[n];
//     for (int i = 0; i < n; i++) {
//       arr[i] = scn.nextInt();
//     }
//     int pivot = findPivot(arr);
//     System.out.println(pivot);
//   }
// }