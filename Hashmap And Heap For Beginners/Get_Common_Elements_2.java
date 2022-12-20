import java.util.*;

public class Get_Common_Elements_2 {
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
                // funfact I wasted my 15 mins time debugging the whole code, but the error was
                // in the above line. instead of frequency +1, I wrote frequency++ and don't
                // know why but for some reason, it was not adding up correctly in the hashmap
            } else {
                hm.put(i, 1);
            }
        }

        for (int i : arr2) {
            if (hm.containsKey(i) && hm.get(i) > 0) {
                System.out.println(i);
                int frequency = hm.get(i);
                hm.put(i, frequency - 1);
            }
        }

        scn.close();
    }

}