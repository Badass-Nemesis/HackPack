import java.io.*;
import java.util.*;

public class Smallest_Number_Following_Pattern {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Integer> st = new Stack<>();
        int i = 1;
        for (int j = 0; j < str.length(); j++) {
            char ch = str.charAt(j);
            if (ch == 'd') {
                st.push(i);
                i++;
            } else if (ch == 'i') {
                st.push(i);
                i++;

                while (st.size() > 0) {
                    System.out.print(st.pop());
                }
            }
        }
        st.push(i);

        while (st.size() > 0) {
            System.out.print(st.pop());
        }
    }
}