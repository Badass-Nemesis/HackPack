import java.util.*;

public class test {

    public static void solve(int n, int[] arr) {
        int counter = 0;

        int sum = 0;
        for (int val : arr) {
            sum += val;
        }

        double mean = sum / n;

        if((sum*2)%n !=0){
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == mean * 2) {
                    counter++;
                }
            }
        }

        System.out.println(counter);
        return;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = scn.nextInt();
            }
            solve(m, arr);
        }
        scn.close();
    }
}
