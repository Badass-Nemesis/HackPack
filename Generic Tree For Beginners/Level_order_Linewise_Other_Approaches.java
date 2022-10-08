import java.io.*;
import java.util.*;

public class Level_order_Linewise_Other_Approaches {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {

        }

        // ye wala constructor isiliye de rahe h humlog, taaki linewise2 wala mein flag
        // ko use kar sake
        Node(int data) {
            this.data = data;
        }

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

    public static int size(Node node) {
        int s = 0;

        for (Node child : node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child : node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        int h = -1;

        for (Node child : node.children) {
            int ch = height(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
    }

    public static void traversals(Node node) {
        System.out.println("Node Pre " + node.data);

        for (Node child : node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        System.out.println("Node Post " + node.data);
    }

    public static void levelOrderLinewise(Node node) {
        // write your code here
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> childQ = new ArrayDeque<>();

        q.add(node);

        while (q.size() > 0) {
            node = q.remove();
            System.out.print(node.data + " ");
            for (Node child : node.children) {
                childQ.add(child);
            }
            if (q.size() == 0) {
                q = childQ;
                childQ = new ArrayDeque<>();
                System.out.println();
            }
        }

    }

    // this code uses a flag. P.S. don't put null in queue, it'll give NullPointer
    // error.
    public static void levelOrderLinewise2(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        q.add(new Node(-1)); // ye -1 wala node mera flag ka kaam karega

        while (q.size() > 0) {
            node = q.remove();

            // agar q se jo abhi remove kiye, uska value -1 ni h, tab jaake wo node ka child
            // add hoga queue mein
            if (node.data != -1) {
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    q.add(child);
                }
            } else { // ni to agar -1 hua, to fir pehle to child wagera jo sab h uska last mein add
                     // karenge -1, uske baad enter maar ke print karne chal jayega wapas while loop
                     // mein
                if (q.size() > 0) {
                    q.add(new Node(-1));
                    System.out.println();
                }
            }
        }

    }

    // isme humlog ek level mein data members count ke hisaab se enter maar ke print
    // karte h
    public static void levelOrderLinewise3(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        while (q.size() > 0) {
            int count = q.size(); // count kar liye ki ye level mein kitne nodes the
            for (int i = 0; i < count; i++) { // ab count ke hisaab se bas utni baar hi loop chalega
                node = q.remove();
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    q.add(child);
                }
            }
            System.out.println(); // count tak chalne aur print hone ke baad fir enter maar denge
        }

    }

    // ye private class use ho raha h linewise4 ke liye
    private static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    // ab isme humlog ek pair class banayenge, node aur wo node ka level ka, aur
    // usko use karenge
    public static void levelOrderLinewise4(Node node) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(node, 1));

        int level = 1;
        while (q.size() > 0) {
            Pair p = q.remove();
            if (p.level > level) {
                level = p.level;
                System.out.println();
            }

            System.out.println(p.node.data + " ");
            for (Node child : p.node.children) {
                Pair childPair = new Pair(child, p.level + 1);
                q.add(childPair);
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

        Node root = construct(arr);
        levelOrderLinewise(root);
    }

}