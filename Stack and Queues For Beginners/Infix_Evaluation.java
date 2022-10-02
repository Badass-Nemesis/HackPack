import java.io.*;
import java.util.*;

public class Infix_Evaluation {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<Integer> opnds = new Stack<>();
        Stack<Character> optors = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                optors.push(ch);
            } else if (Character.isDigit(ch)) {
                opnds.push(ch - '0');
            } else if (ch == ')') {
                while (optors.peek() != '(') {
                    int v2 = opnds.pop();
                    int v1 = opnds.pop();
                    char optor = optors.pop();
                    int value = operation(v1, v2, optor);
                    opnds.push(value);
                }
                optors.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (optors.size() != 0 && optors.peek() != '(' && priority(ch) <= priority(optors.peek())) {
                    int v2 = opnds.pop();
                    int v1 = opnds.pop();
                    char optor = optors.pop();
                    int value = operation(v1, v2, optor);
                    opnds.push(value);
                }
                optors.push(ch);
            }
        }
        while (optors.size() != 0) {
            int v2 = opnds.pop();
            int v1 = opnds.pop();
            char optor = optors.pop();
            int value = operation(v1, v2, optor);
            opnds.push(value);
        }
        System.out.println(opnds.peek());

    }

    public static int priority(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return 2;
        }
    }

    public static int operation(int v1, int v2, char optor) {
        if (optor == '+') {
            return v1 + v2;
        } else if (optor == '-') {
            return v1 - v2;
        } else if (optor == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}