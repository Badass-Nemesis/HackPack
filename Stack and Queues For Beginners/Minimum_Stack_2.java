import java.io.*;
import java.util.*;

public class Minimum_Stack_2 {

    public static class MinStack {
        Stack<Integer> data;
        int min; // pichle time space constant ni tha. lekin iss baar sirf ek variable de ke min
                 // ke liye, space constant kar diya gaya h.

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            return data.size();
        }

        void push(int val) {
            if (data.size() == 0) {
                data.push(val);
                min = val;
            } else if (val >= min) {
                data.push(val);
            } else {
                data.push(val + val - min); // this is basically a simple flag/detection , taaki pata chal sake original
                                            // value min mein save h aur asli val ki jagah val se chota chij store kiye
                                            // h
                min = val;
            }
        }

        int pop() {
            if (data.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else if (data.peek() >= min) {
                return data.pop();
            } else {
                int minimum = min;
                min = 2 * min - data.peek();
                data.pop();
                return minimum;
            }

        }

        int top() {
            if (data.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else if (data.peek() > min) {
                return data.peek();
            } else {
                return min;
            }
        }

        int min() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return min;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}