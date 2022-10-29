import java.io.*;
import java.util.*;

public class Is_Balanced_Tree {
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

    // my code below 👇

    // public static class isBalancedPair {
    // boolean isBalanced;
    // int height;
    // }

    // public static isBalancedPair isBalancedTree(Node node) {
    // if (node == null) {
    // isBalancedPair base = new isBalancedPair();
    // base.isBalanced = true;
    // base.height = 0;
    // return base;
    // }

    // isBalancedPair leftPair = isBalancedTree(node.left);
    // isBalancedPair rightPair = isBalancedTree(node.right);

    // isBalancedPair parentPair = new isBalancedPair();
    // parentPair.isBalanced = leftPair.isBalanced && rightPair.isBalanced
    // && (Math.abs(leftPair.height - rightPair.height) <= 1);
    // parentPair.height = Math.max(leftPair.height, rightPair.height) + 1;

    // return parentPair;
    // }

    // sir's code below 👇

    public static boolean isBal = true;

    public static int isBalancedTree(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = isBalancedTree(node.left);
        int rightHeight = isBalancedTree(node.right);

        int gap = Math.abs(rightHeight - leftHeight);
        if (gap > 1) {
            isBal = false;
        }

        int totalHeight = Math.max(leftHeight, rightHeight) + 1;

        return totalHeight;
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

        // isBalancedPair ans = isBalancedTree(root);
        // System.out.println(ans.isBalanced);

        isBalancedTree(root);
        System.out.println(isBal);
    }

}