import java.util.*;

public class Get_Common_Elements_1 {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : arr1) {
            if (hm.containsKey(i)) {
                int frequency = hm.get(i);
                hm.put(i, frequency + 1);
            } else {
                hm.put(i, 1);
            }
        }

        for (int i : arr2) {
            if (hm.containsKey(i)) {
                System.out.println(i);
                hm.remove(i);
            }
        }

        scn.close();
    }

}