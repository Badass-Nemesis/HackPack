import java.io.*;
import java.util.*;

public class Largest_Bst_Subtree {
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

    public static class BSTPair {
        boolean isBST;
        int min;
        int max;

        Node largestBSTRoot;
        int largestBSTHeight;
    }

    public static BSTPair isBST(Node node) {
        if (node == null) {
            BSTPair base = new BSTPair();
            base.isBST = true;
            base.max = Integer.MIN_VALUE;
            base.min = Integer.MAX_VALUE;
            base.largestBSTHeight = 0; // size
            base.largestBSTRoot = null; // root
            return base;
        }

        BSTPair leftPair = isBST(node.left);
        BSTPair rightPair = isBST(node.right);

        BSTPair parentPair = new BSTPair();
        parentPair.isBST = leftPair.isBST && rightPair.isBST
                           && (node.data >= leftPair.max && node.data <= rightPair.min);
        parentPair.min = Math.min(leftPair.min, Math.min(rightPair.min, node.data));
        parentPair.max = Math.max(leftPair.max, Math.max(rightPair.max, node.data));

        // below is the checking for largest BST. agar wo node BST hua, tab to koi
        // problem ni h, root mein uska node daal denge aur uska height/size mein
        // leftBST ka size + rightBST ka size + 1 kar denge, simple AF. but agar wo node
        // BST ni hua, tab sabse pehle check karenge ki leftBST ka size bada h ya
        // rightBST ka size. wo check karne ke baad humlog neeche wala BST (either
        // leftBST or rightBST) ka root aur height/size leke wo node ka root aur height
        // set kar denge. aur since ye recursion post order mein chal raha h, isiliye ye
        // neeche se upar aate waqt ho raha h, to upar kitna bhi non BST rahe usse koi
        // matlab ni h, kyunki neeche se aate waqt lagataar checking hoye jaa raha h BST
        // ka aur uske according hi set ho raha h sab. to upar ka non BST bhale hi bahut
        // upar ho, lekin uska root aur height represent karega sabse largest (neeche
        // wala) BST ka root aur height ko hi.
        if (parentPair.isBST) {
            parentPair.largestBSTRoot = node;
            parentPair.largestBSTHeight = leftPair.largestBSTHeight + rightPair.largestBSTHeight + 1;
        } else if (leftPair.largestBSTHeight > rightPair.largestBSTHeight) {
            parentPair.largestBSTRoot = leftPair.largestBSTRoot;
            parentPair.largestBSTHeight = leftPair.largestBSTHeight;
        } else {
            parentPair.largestBSTRoot = rightPair.largestBSTRoot;
            parentPair.largestBSTHeight = rightPair.largestBSTHeight;
        }

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
        BSTPair ans = isBST(root);
        System.out.println(ans.largestBSTRoot + "@" + ans.largestBSTHeight);
    }

}