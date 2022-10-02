import java.io.*;
import java.util.*;

public class Linked_List_To_Stack_Adapter {

    public static class LLToStackAdapter {
        LinkedList<Integer> list;

        public LLToStackAdapter() {
            list = new LinkedList<>();
        }

        // ek baat ka dhyan rakhe, ki jo humlog remove last wala likhe the pehle, wo
        // O(1) mein ni hua tha, aur ye Link to Stack wala mein sabko O(1) mein karna h.
        // To iske liye humko baad baad mein add karne ki jagah first first mein add
        // karte hue linked list banayenge. Aur jab remove/pop bolega to remove first
        // kar denge.

        // But java ka linked list sab kaam O(1) mein karta h to koi farak padna ni
        // chahiye waise.

        int size() {
            // write your code here
            return list.size();
        }

        void push(int val) {
            // write your code here
            list.addFirst(val);
        }

        int pop() {
            // write your code here
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return list.removeFirst();
            }
        }

        int top() {
            // write your code here
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return list.getFirst();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLToStackAdapter st = new LLToStackAdapter();

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
            }
            str = br.readLine();
        }
    }
}