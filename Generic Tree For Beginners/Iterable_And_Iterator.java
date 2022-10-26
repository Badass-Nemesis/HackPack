import java.io.*;
import java.util.*;

public class Iterable_And_Iterator {
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

    public static void IterativePreandPostOrder(Node node) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));
    }

    public static class GenericTree implements Iterable<Integer> {
        Node root;

        GenericTree(Node root) {
            this.root = root;
        }

        public Iterator<Integer> iterator() { // ye function banana padega kyunki Iterable ne demand kiya h
            Iterator<Integer> obj = new GenericTreePreOrder(root);
            return obj;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static class GenericTreePreOrder implements Iterator<Integer> {
        // ye help karega generic tree ko pre-order mein traversal karne mein

        Integer nextValue;
        Stack<Pair> st;

        GenericTreePreOrder(Node root) {
            st = new Stack<>();
            st.push(new Pair(root, -1));
        }

        public boolean hasNext() {
            if (nextValue == null) {
                return false;
            } else {
                return true;
            }
        }

        public Integer next() {
            Integer forwardReturn = nextValue;

            // moves nextValue forward, if not possible sets it to null

            nextValue = null;
            // isko aise samjho, ki ye to hum har baar set karke apne aap
            // ko bacha le rahe h. because humko chahiye ki mera jo tree h
            // wo traverse kare to fir pre order mein kaam ho uspe (printing wagera).
            // agar wo pre order mein ghus hi ni paya, to iska matlab ki last tak pahuch
            // chuke h (leaf tak).
            // aur since ye pre order mein ni ghusa tha, to fir isiliye nextValue ka value
            // change ni
            // hua, jo humlog neeche kiye h pre order mein.

            // churaya hua code, from iterative pre post order. huehuehuehue
            while (st.size() > 0) {
                Pair top = st.peek();
                if (top.state == -1) {
                    nextValue = top.node.data; // idhar humlog change kar rahe h nextValue ka value, from null to not
                                               // null.
                    top.state++;
                    break;
                } else if (top.state == top.node.children.size()) {
                    st.pop();
                } else {
                    Pair childPair = new Pair(top.node.children.get(top.state), -1);
                    st.push(childPair);
                    top.state++;
                }
            }

            return forwardReturn;
        }
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
        GenericTree gt = new GenericTree(root);

        for (int val : gt) { // syntactical sugar dependent on Iterable
            System.out.println(val);
        }

        // upar ka for loop ye neeche wala code mein convert ho jata h, uske baad
        // iterate hota h

        Iterator<Integer> gti = gt.iterator();
        while (gti.hasNext() == true) {
            System.out.println(gti.next());
        }
    }

}