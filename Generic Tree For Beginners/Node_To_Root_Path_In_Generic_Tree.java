import java.io.*;
import java.util.*;

public class Node_To_Root_Path_In_Generic_Tree {
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

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        // write your code here
        if (node.data == data) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(node.data);
            return res;
        }

        for (Node child : node.children) {
            ArrayList<Integer> pathTillChild = nodeToRootPath(child, data);
            if (pathTillChild.size() > 0) {
                pathTillChild.add(node.data);
                return pathTillChild;
            }
        }

        return new ArrayList<>();
    }

    public static ArrayList<Integer> nodeToRootPath2(Node node, int data) {
        res = new ArrayList<>();
        nodeToRootPath3(node, data);
        return res;
    }

    public static ArrayList<Integer> res;

    public static void nodeToRootPath3(Node node, int data) {

        if (node.data == data) {
            res.add(node.data);
            // System.out.println("Hello");
            return;
        }

        for (Node child : node.children) {
            nodeToRootPath3(child, data);
            if (res.size() > 0) {
                res.add(node.data);
                // System.out.println(res);
                return;
            }
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

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        ArrayList<Integer> path = nodeToRootPath2(root, data);
        System.out.println(path);
        // display(root);
    }

}