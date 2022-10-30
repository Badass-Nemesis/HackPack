import java.io.*;
import java.util.*;

public class Target_Sum_Pair_In_Bst {
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

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data < data) {
            return find(node.right, data);
        } else if (node.data > data) {
            return find(node.left, data);
        } else {
            return true;
        }
    }

    public static void travelAndPrint(Node root, Node node, int target) {
        if (node == null) {
            return;
        }

        travelAndPrint(root, node.left, target);

        // what we are doing here is that we are finding complement of every single
        // node.data and finding that complement in the whole tree, so that we can print
        // the target sum pair if the complement is found
        int complement = target - node.data;
        if (node.data < complement) {
            // the above if block prevents from entering twice inside to print, because if
            // there exists complement, then the print block will get executed twice
            if (find(root, complement)) {
                // we were passing the root in travelAndPrint just for this find function
                System.out.println(node.data + " " + complement);
            }
        }

        travelAndPrint(root, node.right, target);
    }

    public static void travelAndFill(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        travelAndFill(node.left, list);

        list.add(node.data);

        travelAndFill(node.right, list);
    }

    public static class ITPair {
        Node node;
        int state;

        ITPair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void bestApproach(Node node, int data) {
        Stack<ITPair> leftStack = new Stack<>();
        Stack<ITPair> rightStack = new Stack<>();

        leftStack.push(new ITPair(node, 0));
        rightStack.push(new ITPair(node, 0));

        Node left = getNextNodeFromNormalInorder(leftStack);
        Node right = getNextNodeFromReverseInorder(rightStack);

        while (left.data < right.data) {
            if (data > left.data + right.data) {
                left = getNextNodeFromNormalInorder(leftStack);
            } else if (data < left.data + right.data) {
                right = getNextNodeFromReverseInorder(rightStack);
            } else {
                System.out.println(left.data + " " + right.data);
                left = getNextNodeFromNormalInorder(leftStack);
                right = getNextNodeFromReverseInorder(rightStack);
            }
        }
    }

    public static Node getNextNodeFromNormalInorder(Stack<ITPair> st) {
        while (st.size() > 0) {
            ITPair top = st.peek();
            if (top.state == 0) {
                if (top.node.left != null) {
                    st.push(new ITPair(top.node.left, 0));
                }
                top.state++;
            } else if (top.state == 1) {
                if (top.node.right != null) {
                    st.push(new ITPair(top.node.right, 0));
                }
                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }

        return null;
    }

    public static Node getNextNodeFromReverseInorder(Stack<ITPair> st) {
        while (st.size() > 0) {
            ITPair top = st.peek();
            if (top.state == 0) {
                if (top.node.right != null) {
                    st.push(new ITPair(top.node.right, 0));
                }
                top.state++;
            } else if (top.state == 1) {
                if (top.node.left != null) {
                    st.push(new ITPair(top.node.left, 0));
                }
                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }

        return null;
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

        // write your code here

        // first approach. space complexity is log(n) i.e. height, and time is O(n.h)
        // [h=height or log(n)]
        // travelAndPrint(root, root, data);

        // second approach. space complexity is O(n) and time is also O(n)
        // ArrayList<Integer> list = new ArrayList<>();
        // travelAndFill(root, list);
        // int i = 0;
        // int j = list.size() - 1;
        // while (i < j) {
        // if (data > list.get(i) + list.get(j)) {
        // i++;
        // } else if (data < list.get(i) + list.get(j)) {
        // j--;
        // } else {
        // System.out.println(list.get(i) + " " + list.get(j));
        // i++;
        // j--;
        // }
        // }

        // third approach. space complexity is log(n) i.e. height, and time is O(n)
        bestApproach(root, data);
    }

}