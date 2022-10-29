import java.io.*;
import java.util.*;

public class Diameter_Of_A_Binary_Tree {
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

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
    }

    // this is not efficient, because in the diameter1 recursion, we are also firing
    // up the height recursion. so it basically becomes an n^2 complexity code
    public static int diameter1(Node node) {
        // write your code here

        if (node == null) {
            return 0;
        }

        // maximum dist. b/w two nodes in left hand side
        int factor1 = diameter1(node.left);

        // maximum dist. b/w two nodes in right hand side
        int factor2 = diameter1(node.right);

        // maximum b/w left's deepest node and right's deepest node
        int factor3 = height(node.left) + height(node.right) + 2;

        int dia = Math.max(factor1, Math.max(factor2, factor3));
        return dia;
    }

    // this is efficient
    public static class DiaPair {
        int height;
        int diameter;
    }

    public static DiaPair diameter2(Node node) {
        if (node == null) {
            DiaPair base = new DiaPair();
            base.height = -1;
            base.diameter = 0;
            return base;
        }

        // maximum dist. b/w two nodes in left hand side
        DiaPair factor1 = diameter2(node.left);

        // maximum dist. b/w two nodes in right hand side
        DiaPair factor2 = diameter2(node.right);

        // maximum b/w left's deepest node and right's deepest node
        DiaPair factor3 = new DiaPair();
        factor3.height = Math.max(factor1.height, factor2.height) + 1;
        factor3.diameter = Math.max(factor1.height + factor2.height + 2, Math.max(factor1.diameter, factor2.diameter));

        return factor3;
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

        // int diameter = 0;
        // diameter = diameter1(root);
        DiaPair ans = diameter2(root);
        System.out.println(ans.diameter);
    }

}