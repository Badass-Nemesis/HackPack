import java.io.*;
// import java.util.*;
import java.util.PriorityQueue;

public class Sort_K_sorted_Array {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        // write your code here

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // putting k+1 elements in a funnel
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        // moving the funnel forward by removing one element and putting the next array
        // element
        for (int i = k + 1; i < arr.length; i++) {
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }

        // jo last mein elements bachega uske liye h ye while loop. since ye priority
        // queue h, aur sabse chota wala pehle niklega, to usse aur easy ho jayega print
        // karne mein. sirf direct remove aur print karna hoga.
        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }

    }

}