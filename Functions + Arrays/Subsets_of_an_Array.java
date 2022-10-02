import java.util.*;

public class Subsets_of_an_Array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int limit = (int) Math.pow(2, n);
        for (int i = 0; i < limit; i++) {
            int temp = i;
            // convert i to binary and then use 0's and 1's to know when to print or not.
            // i.e. if we input a number 5, then we can find it's binary by doing 5 % 2
            // again and again
            String set = "";
            for (int j = n - 1; j >= 0; j--) {
                int r = temp % 2;
                temp = temp / 2;
                if(r==0){
                    set="-\t"+set;
                }
                else{
                    set=arr[j]+"\t"+set;
                }
            }
            System.out.println(set);
        }
    }
}
