import java.util.*;

public class Pattern3 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        //Pepcoding code

        // int nsp = n - 1;
        // int nst = 1;
        // nsp = number of spacing, nst = number of stars
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < nsp; j++) {
        //         System.out.print("\t");
        //     }

        //     for (int j = 0; j < nst; j++) {
        //         System.out.print("*\t");
        //     }

        //     nsp--;
        //     nst++;
        //     System.out.println();
        //}

        //My code
        
        for(int i=0;i<n ;i++){
            for(int j=0; j<n-i-1; j++){
                System.out.print("\t");
            }
            for(int k=0; k<=i; k++){
                System.out.print("*\t");
            }
            System.out.println();
        }

    }
}
