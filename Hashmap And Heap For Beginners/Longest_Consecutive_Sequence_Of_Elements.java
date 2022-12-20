import java.util.*;

public class Longest_Consecutive_Sequence_Of_Elements {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // int n1 = scn.nextInt();
        // int n2 = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int i : arr) {
            hm.put(i, true);
        }

        // ye false wala loop chalaane se aisa ho jayega ki sirf wahi elements ka true
        // rahega jiska usse just chota element exist ni karta h hashmap mein
        for (int i : arr) {
            if (hm.containsKey(i - 1)) {
                hm.put(i, false);
            }
        }

        int maxLength = 0; // isse decide karenge ki jo abhi tak mila h wo max length ka h ya ni
        int maxStartPoint = 0; // ye arr ka value ke liye h. isko minus infinity bhi kar sakte h
        for (int i : arr) {
            if (hm.get(i)) {
                int totalLength = 1; // since starting mein i le liye h, to length abhi 1 rahega
                int startingPoint = i; // i se start karenge check karna for max length

                while (hm.containsKey(startingPoint + totalLength)) {
                    totalLength++;
                }

                if (totalLength > maxLength) {
                    maxLength = totalLength;
                    maxStartPoint = startingPoint;
                }
            }
        }

        for (int i = 0; i < maxLength; i++) {
            System.out.println(maxStartPoint + i);
            // it's just like printing 1, 1+1 = 2, 1+2 = 3, ..... and so on until the max
            // length is reached
        }

        scn.close();
    }
}