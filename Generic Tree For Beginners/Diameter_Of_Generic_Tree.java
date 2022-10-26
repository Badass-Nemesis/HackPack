import java.io.*;
import java.util.*;

public class Diameter_Of_Generic_Tree {
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

    static int dia = 0;

    // apparently, aisa hamesha jaruri ni h ki root se ho ke hi jaaye diameter. aisa
    // bhi ho sakta h hi koi ek child ka bahut jyada deep gaya h two sub-childs, to
    // fir wo sub-childs ki wajah se wo child wala area hi aa jayega diameter. to
    // isiliye humlog ye dch+sdch+2 check kar rahe h. ni to humlog direct ye bhi kar
    // sakte the ki deepest aur second deepest nikaal ke usme +2 karke result de de.

    public static int calcDiaReturnHeight(Node node) {
        int dch = -1; // deepest child height
        int sdch = -1; // second deepest child height

        for (Node child : node.children) {
            int ch = calcDiaReturnHeight(child);
            if (ch > dch) { // agar child height mera aaya deepest child height se bhi jyada, to fir deepest
                            // child height ko humko second deepest banana padega, aur fir deepest child
                            // update kar dena padega wo child height se
                sdch = dch;
                dch = ch;
            } else if (ch > sdch) { // ni to agar child height sirf second deepest child height se bada aaya, to fir
                                    // kuch ni, bas second deepest ko update karke usko child height ke equal kar
                                    // denge
                sdch = ch;
            }
        }

        // don't you dare asking me why I did this dch+sdch+2. I swear to god I'll kill
        // you, even if it's me who's asking.
        if (dch + sdch + 2 > dia) {
            dia = dch + sdch + 2;
        }

        dch++;

        return dch;
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
        calcDiaReturnHeight(root);
        System.out.println(dia);
    }

}