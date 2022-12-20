import java.io.*;
import java.util.*;

public class Write_Priority_Queue_Using_Heap {

    public static class PriorityQueue {
        // isme basically humlog ye kar rahe h ki arraylist ko ek complete binary tree
        // (matlab upar sab bhara hua, aur neeche left se right bhara hua) ke jaisa
        // treat kar rahe h. jaise ki array ka 0th index wala root rahega, aur since
        // left se right bhar rahe h, to left child 1th index wala hoga aur right child
        // 2nd index wala hoga. ab isme child ka index aur parent ka index mein ye
        // relation h ki left child index = 2*parent + 1 aur right child index =
        // 2*parent + 2. isse humlog ek complete binary tree represent kar lenge. aur
        // child index se parent index nikaalna hoga agar to wo bhi nikaal lenge ye
        // formula use karke -> parent index = (child-1)/2 .....(isme agar koi decimal
        // wala bhi aa jayega to wo int mein convert hone ke baad sahi hi parent index
        // dega)
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public void add(int val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        private void upheapify(int i) {
            if (i == 0) {
                return;
            }

            int parentIndex = (i - 1) / 2;

            if (data.get(i) < data.get(parentIndex)) {
                swap(i, parentIndex);
                upheapify(parentIndex);
            }
        }

        public void swap(int i, int j) {
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        public int remove() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            swap(0, data.size() - 1);
            int val = data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }

        private void downheapify(int i) {
            int mini = i;

            int leftIndex = (2 * i) + 1;
            if (leftIndex < data.size() && data.get(leftIndex) < data.get(mini)) {
                mini = leftIndex;
            }

            int rightIndex = (2 * i) + 2;
            if (rightIndex < data.size() && data.get(rightIndex) < data.get(mini)) {
                mini = rightIndex;
            }

            if (mini != i) {
                swap(mini, i);
                downheapify(mini);
            }
        }

        public int peek() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}