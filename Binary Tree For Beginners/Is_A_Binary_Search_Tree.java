import java.io.*;
import java.util.*;

public class Is_A_Binary_Search_Tree {
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

    public static class BSTPair {
        boolean isBST;
        int min;
        int max;
    }

    public static BSTPair isBST(Node node) {
        if (node == null) {
            BSTPair base = new BSTPair();
            base.min = Integer.MAX_VALUE;
            base.max = Integer.MIN_VALUE;
            base.isBST = true;
            return base;
        }

        BSTPair leftPair = isBST(node.left);
        BSTPair rightPair = isBST(node.right);

        BSTPair parentPair = new BSTPair();
        // checking for tree ki tarah bst
        parentPair.isBST = leftPair.isBST && rightPair.isBST
                           && (node.data >= leftPair.max && node.data <= rightPair.min);
        // the above is checking for bst. firstly we check if the left node is qualified
        // for BST or not, then right node is qualified for BST or not, then we will
        // check for the current node's qualification (i.e. if it ranges between the
        // left's max and the right's min). we would also need the node's left's min and
        // node's right's max also...... because if let's say that there is a node above
        // the current node, then the above node would require the below node's min max
        // (according to left right node location) to calculate it's isBST
        parentPair.min = Math.min(node.data, Math.min(leftPair.min, rightPair.min));
        parentPair.max = Math.max(node.data, Math.max(leftPair.max, rightPair.max));

        return parentPair;
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

        // write your code here

        BSTPair b = isBST(root);
        System.out.println(b.isBST);
    }

}