import java.util.*;

// binary tree mein max to max 2 child hi honge. kisi ka 1 bhi ho sakta h, aur leaf ka 0 child ho sakta h.

public class Introduction {

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
            this.state = state;
            this.node = node;
        }
    }

    public static void display(Node node){
        if(node == null){
            return;
        }

        //node self work
        String str = "";
        str += node.left == null? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null? "." : node.right.data + "";

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };

        Stack<Pair> st = new Stack<>();
        Node root = new Node(arr[0], null, null);
        Pair rp = new Pair(root, 1);
        // state 1 is for left child, 2 is for right child, 3 is for no child

        st.push(rp);

        int idx = 0; // this index is used for accessing elements from arr (array)

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    Node leftNode = new Node(arr[idx], null, null);
                    top.node.left = leftNode;
                    // or just write this below line
                    // top.node.left = new Node(arr[idx], null, null);
                    // Pair leftPair = new Pair(top.node.left, 1);

                    Pair leftPair = new Pair(leftNode, 1);
                    st.push(leftPair);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    Node rightNode = new Node(arr[idx], null, null);
                    top.node.right = rightNode;
                    // or just write this below line
                    // top.node.left = new Node(arr[idx], null, null);
                    // Pair leftPair = new Pair(top.node.left, 1);

                    Pair rightPair = new Pair(rightNode, 1);
                    st.push(rightPair);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        display(root);
    }
}