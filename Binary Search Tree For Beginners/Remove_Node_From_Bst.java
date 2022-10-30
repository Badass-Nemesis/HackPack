import java.io.*;
import java.util.*;

public class Remove_Node_From_Bst {
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

    public static int max(Node node) {
        if (node.right != null) {
            return max(node.right);
        } else {
            return node.data;
        }
    }

    public static int min(Node node) {
        if (node.left != null) {
            return min(node.left);
        } else {
            return node.data;
        }
    }

    public static Node remove(Node node, int data) {
        // write your code here
        if (node == null) {
            return null;
        }

        if (data > node.data) {
            node.right = remove(node.right, data);
        } else if (data < node.data) {
            node.left = remove(node.left, data);
        } else {
            // all the work now begins here, where node.data = data
            if (node.left != null && node.right != null) {
                int leftMax = max(node.left);
                node.data = leftMax;
                node.left = remove(node.left, leftMax);
                return node;
                // ye condition mein yahi kaam ho raha h ki jab 2 child ho koi node ka, to fir
                // usme humlog remove karne ke liye left side ka max dekhenge aur node.data ko
                // left max se replace karke, fir jaise neeche bypass kiye the, usi tarah idhar
                // bhi bypass kar denge, aur saath hi saath left max ko remove karne ke liye bhi
                // recursion use kar denge, kyunki left max ko to humlog copy kiye the data,
                // usko hataye ni the humlog abhi. to left max wala node ko hatane ke liye bhi
                // chalaana padega firse recursion.
                // ab ye left ka hi max humlog isi liye liye h, because as per sir, left ka max
                // se replace karenge agar to fir left side se koi problem ni hoga kyunki left
                // mein sab chote hi milenge left max se, aur left ka checking factor for BST
                // yahi bolta h ki left side ka max se bada hona chahiye to become a node BST

                // And Also Because I DON'T FUQING KNOW. I want to try with right min.
                // well that was definitely wrong, and I DON'T KNOW WHY

                // int rightMin = min(node.right);
                // node.data = rightMin;
                // node.right = remove(node.right, rightMin);
                // return node;
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
                // above two conditions are for single child, i.e. either right one, or left
                // one. to isme ye karenge humlog, ki node jo abhi pass hua h, usko bypass karke
                // wo node ke parent ka connection, wo node ke child se kar denge. simple af. to
                // isme humlog yahi kiye h, ki left child agar present h sirf, to fir node ki
                // jagah node ka left return karenge, aur similarly right return karenge
            } else {
                return null;
                // this is no child condition. bhais ki tait pura hi uda do aur null return kar
                // do
            }
        }

        return node;
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

        Node root = construct(arr);
        root = remove(root, data);

        display(root);
    }

}