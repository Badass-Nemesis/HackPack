import java.io.*;
import java.util.*;

public class Iterative_Preorder_And_Postorder_Of_Generic_Tree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void IterativePreandPostOrder(Node node) {
        // write your code here
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1)); // sabse pehle minus -1 state leke push karenge

        String pre = "";
        String post = "";

        while (st.size() > 0) {
            Pair top = st.peek(); // isse top wale ko ek jagah store karek uspe operation karenge
            if (top.state == -1) { // agar state mera -1 h, to iska matlab wo pre area mein h.
                pre += top.node.data + " "; // sabse pehle to add kar denge pre wala stack mein
                top.state++; // aur uske baad state ko badha ke 0 kar denge
            } else if (top.state == top.node.children.size()) {
                // agar state mera child size ke barabar h, iska matlab hum post order mein h.
                // 1st example -> jaise ki agar leaf h mera top (Pair top), to pehle to wo pre
                // wala area mein enter karke add ho jayega string mein. lekin jab while loop
                // firse chalega, tab wahi top pe rahega firse, aur uska state ab 0 ho gaya
                // hoga. isliye fir wo post area mein enter karega, aur fir post string mein add
                // karke fir usko pop kar denge, kyunki recursion mein bhi aisa hi hota tha, ki
                // jab post order chal gaya wo euler mein uska, tab fir wo erase ho jayega. 2nd
                // example -> agar maan lete h ki ek node ka 3 child h, to fir usme kya hoga, ki
                // 1 child traversal ke baad (pura pre post khatam karke wo 1st child ka), fir
                // jab wapas while loop mein enter karega, tab wo node hi aayega top (Pair top)
                // mein. aur wo top mein aake else block mein ghusega. aur else block mein har
                // baar ghusne pe state plus hote rahega, 2nd child add hone ke baad. fir jab
                // 2nd child khatam kar lega apna pre post, tab fir again node enter karega top
                // mein. fir 3rd child ke liye else block enter karega wo. AND since wo node
                // (Pair top) ka state 0 kar diye the humlog, jab pre block mein ghusa tha wo,
                // iski wajah se jab bhi children aayega stack mein, tab wo node ka state
                // hamesha plus hote rahega. at last, uska state apne children ke size ke
                // barabar ho jayega, aur tab fir wo post area mein enter hoga, aur pop ho
                // jayega string mein add hone ke baad.
                post += top.node.data + " ";
                st.pop();
            } else {
                Pair childPair = new Pair(top.node.children.get(top.state), -1);
                st.push(childPair);
                top.state++;
            }
        }

        System.out.println(pre);
        System.out.println(post);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        IterativePreandPostOrder(root);
    }

}