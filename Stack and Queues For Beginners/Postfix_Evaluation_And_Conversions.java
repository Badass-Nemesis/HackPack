import java.io.*;
import java.util.*;

public class Postfix_Evaluation_And_Conversions {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Integer> eval = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch >= '0' && ch <= '9') {
                eval.push(ch - '0');
                infix.push(ch + "");
                prefix.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v2 = eval.pop();
                int v1 = eval.pop();
                eval.push(operation(v2, v1, ch));

                String infixv2 = infix.pop();
                String infixv1 = infix.pop();
                infix.push('(' + infixv1 + ch + infixv2 + ')');

                String prefixv2 = prefix.pop();
                String prefixv1 = prefix.pop();
                prefix.push(ch + prefixv1 + prefixv2);
            }
        }

        System.out.println(eval.pop());
        System.out.println(infix.pop());
        System.out.println(prefix.pop());
    }

    public static int operation(int v2, int v1, char ch) {
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