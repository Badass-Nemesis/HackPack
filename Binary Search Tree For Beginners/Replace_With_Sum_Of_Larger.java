import java.io.*;
import java.util.*;

public class Replace_With_Sum_Of_Larger {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
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

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    static int sum = 0;

    // in here, we are replacing the node.data with sum of it's all the larger items
    // that are present in the tree. also an INTERESTING FACT -> since the tree is
    // Binary Search Tree, that's why when we look at the in-order traversal, then
    // we would get the ascending order of all the elements in the tree, similarly
    // if we do a reverse in-order traversal (i.e. traversing from right to left in
    // in-order), then we would get the descending order of all the elements in the
    // tree
    public static void rwsol(Node node) {
        // write your code here
        if (node == null) {
            return;
        }

        rwsol(node.right);

        // here we are storing the node.data temporary so that we can change the sum
        // value, and since we are doing a reverse in-order traversal, that's why we
        // will get all the bigger elements in the in-order first, and that's why it'll
        // be easy to replace the node.data value and also to edit the sum value.
        int temp = node.data;
        node.data = sum;
        sum += temp;

        rwsol(node.left);

        return;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        rwsol(root);

        display(root);
    }

}