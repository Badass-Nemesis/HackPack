import java.util.*;
import java.io.*;

public class Prefix_Evaluation_and_Conversion {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<Integer> eval = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<String> infix = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v1 = eval.pop();
                int v2 = eval.pop();
                int val = operation(v1, v2, ch);
                eval.push(val);

                String postv1 = postfix.pop();
                String postv2 = postfix.pop();
                String postv = postv1 + postv2 + ch;
                postfix.push(postv);

                String infixv1 = infix.pop();
                String infixv2 = infix.pop();
                String infixv = "(" + infixv1 + ch + infixv2 + ")";
                infix.push(infixv);
            } else {
                eval.push(ch - '0');
                postfix.push(ch + "");
                infix.push(ch + "");
            }
        }

        System.out.println(eval.pop());
        System.out.println(infix.pop());
        System.out.println(postfix.pop());
    }

    public static int operation(int v1, int v2, char ch) {
        if (ch == '+') {
            return v1 + v2;
        } else if (ch == '-') {
            return v1 - v2;
        } else if (ch == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}