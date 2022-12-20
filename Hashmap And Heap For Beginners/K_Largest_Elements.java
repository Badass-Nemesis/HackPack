import java.util.*;
import java.io.*;

public class K_Largest_Elements {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        solve(n, num, k);
        scn.close();
    }

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array,n length of array and k.
    // It should print required output.

    // sir's code
    public static void solve(int n, int[] arr, int k) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else {
                if (arr[i] > pq.peek()) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }

        Stack<Integer> descending = new Stack<>();
        while (pq.size() > 0) {
            descending.push(pq.remove());
        }

        while (descending.size() > 0) {
            System.out.print(descending.pop() + " ");
        }
    }

    // my dumb code
    public static void solve2(int n, int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : arr) {
            pq.add(val);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.remove();
        }

        System.out.println(pq.peek());
    }
}