import java.io.*;
import java.util.*;

public class Sieve_Of_Eratosthenes {

    public static void printPrimeUsingSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= isPrime.length; i++) {
            if (isPrime[i] == true) {
                for (int j = i + i; j < isPrime.length; j += i) {
                    // jumping between i's multiples and marking them false
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i] == true) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
        scn.close();
    }
}
