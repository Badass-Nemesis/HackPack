import java.util.*;

public class Pattern8 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int nsp = n - 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nsp; j++) {
                System.out.print("\t");
            }

             System.out.print("*\t");

            nsp--;
            System.out.println();
        }

    }
}