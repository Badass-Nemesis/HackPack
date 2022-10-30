import java.io.*;
// import java.util.*;

public class Size_Sum_Max_Min_Find_In_Bst {
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

    // ye construct wala code BST wala alag rahega. Nados pe wo pichle wala code hi
    // h, but asli construction aisa rahega 👇

    public static Node construct(Integer[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int mid = (lo + hi) / 2;

        Node lchild = construct(arr, lo, mid - 1);
        Node rchild = construct(arr, mid + 1, hi);
        Node node = new Node(arr[mid], lchild, rchild);

        return node;
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

    public static int size(Node node) {
        // write your code here
        if (node == null) {
            return 0;
        }

        int leftSize = size(node.left);
        int rightSize = size(node.right);

        int totalSize = leftSize + rightSize + 1;

        return totalSize;
    }

    public static int sum(Node node) {
        // write your code here
        if (node == null) {
            return 0;
        }

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        int totalSUm = leftSum + rightSum + node.data;

        return totalSUm;
    }

    public static int max(Node node) {
        // write your code here
        if (node.right != null) {
            return max(node.right);
        } else {
            return node.data;
        }
        // because since it is a binary search tree, so all the max values should be
        // allocated in the right hand side of the total tree
    }

    public static int min(Node node) {
        // write your code here
        if (node.left != null) {
            return min(node.left);
        } else {
            return node.data;
        }
        // because since it is a binary search tree, so all the min values should be
        // allocated in the left hand side of the total tree
    }

    public static boolean find(Node node, int data) {
        // write your code here
        if (node == null) {
            return false;
        }

        if (data > node.data) {
            // agar data wo node ka data se bada aa gaya, iska matlab ki hum left chale gaye
            // h (i.e. kam value wala area mein chale gaye h), humko high wala area mein
            // jana hoga, i.e. right
            return find(node.right, data);
        } else if (data < node.data) {
            // agar data wo node ka data se chota aa gaya, iska matlab ki hum right chale
            // gaye h (i.e. high value wala area mein chale gaye h), humko low wala area
            // mein jana hoga, i.e. left
            return find(node.left, data);
        } else {
            return true;
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

        Node root = construct(arr, 0, arr.length - 1);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int min = min(root);
        boolean found = find(root, data);

        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);
        System.out.println(found);
    }

}