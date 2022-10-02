import java.util.*;

public class Diff_Of_Two_Arrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = scn.nextInt();
        }

        int[] diff = new int[n2];
        int c = 0;

        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = diff.length - 1;
        while (k >= 0) {
            int d = 0;
            int a1v = i >= 0 ? a1[i] : 0;
            // if a1[i] is inside the array, then give value inside array. If false, then give 0.
            // iska matlab ki agar koi aisa case aaye jisme a1 array mein koi value ho hi ni
            // minus karte waqt, to humlog ko usme 0 bhejna hoga taaki difference aage badh
            // sake. For ex = 100-1. isme to a1 ka sirf 1 element h, aage koi aayega ni diff
            // ke liye a1 ka.
            // to isme humlog 0 daal denge, jab a1 array ke bahar chala jaaye diff.
            if (a2[j] + c >= a1v) {
                d = a2[j] + c - a1v;
            } else {
                d = a2[j] + c + 10 - a1v;
                c = -1;
            }
            diff[k] = d;
            i--;
            j--;
            k--;
        }

        int index = 0;
        while (index < diff.length) {
            if (diff[index] == 0) {
                index++;
            } else {
                break;
            }
        }
        while (index < diff.length) {
            System.out.println(diff[index]);
            index++;
        }
    }
}