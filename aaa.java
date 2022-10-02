import java.util.*;

public class aaa {

    public static int solve(int n, int[] A, int[] B) {
        int startingPoint = 0;
        int gasNow = 0;
        int totalGasAdd = 0;
        int totalCostAdd = 0;
        for (int i = 0; i < n; i++) {
            totalGasAdd = totalGasAdd + A[i];
            totalCostAdd = totalCostAdd + B[i];
        }

        if (totalCostAdd > totalGasAdd) {
            return -1;
        } else {
            for (int i = 0; i < n; i++) {
                gasNow = gasNow + A[i] - B[i];
                if (gasNow < 0) {
                    gasNow = 0;
                    startingPoint = i + 1;
                }
            }
            return startingPoint;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = scn.nextInt();
        }
        int res = solve(n, A, B);
        System.out.println(res);
        scn.close();
    }
}