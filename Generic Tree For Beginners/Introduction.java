import java.util.*;

public class Introduction {
    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
        // parent, child, leaf
        // ancestor, descendent, root
    }

    // Generic tree ke liye bas ek node chahiye rehta h root wala. Isiliye no need
    // to make a class for it.

    // public class GenericTree{
    // Node root;
    // }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ",";
        }

        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1 };

        // instead of making a separate class, just use root Node here
        Node root = null;
        Stack<Node> st = new Stack<>();

        // constructor code basically

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node(); // node banao
                t.data = arr[i]; // node mein data set karo

                if (st.size() > 0) {
                    st.peek().children.add(t); // stack ka top wala mein jo pada hua h uska children ka arraylist mein
                                               // add kar denge node ko
                } else {
                    root = t;
                }
                st.push(t); // aakhir mein stack mein push karo, taaki iska aage jaake children wagera check
                            // ho jaye
            }
        }

        display(root);
    }
}
