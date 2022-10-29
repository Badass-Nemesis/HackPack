import java.io.*;
import java.util.*;

public class Print_Nodes_K_Distance_Away {
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

    public static void printKLevelsDown(Node node, int k, Node blocker) {
        if (node == null || node == blocker || k < 0) {
            return;
        }

        if (k == 0) {
            System.out.println(node.data);
        }

        printKLevelsDown(node.left, k - 1, blocker);
        printKLevelsDown(node.right, k - 1, blocker);
    }

    public static ArrayList<Node> path;

    public static boolean findAndPath(Node node, int data) {

        if (node == null) {
            return false;
        }

        if (node.data == data) {
            path.add(node);
            return true;
        }

        boolean leftFind = findAndPath(node.left, data);
        if (leftFind) {
            path.add(node);
            return true;
        }

        boolean rightFind = findAndPath(node.right, data);
        if (rightFind) {
            path.add(node);
            return true;
        }

        return false;
    }

    public static void printKNodesFar(Node node, int data, int k) {
        // write your code here
        path = new ArrayList<>();

        findAndPath(node, data);

        for (int i = 0; i < path.size(); i++) {
            printKLevelsDown(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
            // ye above mein blocker node humlog isiliye de rahe h taaki printKlevel wala
            // mein jab dhundha jaaye, tab wo pehle se explored node wala mein naa ghus
            // jaaye. aur (k-i) isiliye likhe h, kyunki jo path humlog ko mila h node to
            // root path se, to kyunki sabse pehle neeche wala node se start ho raha h
            // arraylist, to usme humlog kab pehle wale ko call laga ke printKLevel wala
            // code run karenge to wo run hone ke baad jab next arraylist wala node pe
            // aayega, to iska matlab h ki wo node jo h, wo target node se ek edge upar h. 1
            // edge upar matlab target node se jo k level duur h, wo ab currently node se
            // k-i edges duur h (that includes the above one too).
        }
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

        int data = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        printKNodesFar(root, data, k);
    }

}