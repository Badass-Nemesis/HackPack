import java.io.*;
import java.util.*;

public class Merge_K_Sorted_Lists {
    public static class Pair implements Comparable<Pair> {
        int listIndex;
        // listIndex matlab ki kaun sa list access kar rahe h humlog. jaise ki 0th index
        // pe pehla list h (i.e. first ArrayList h), uske baad 1st index pe second list
        // h...........so on and so forth
        int dataIndex;
        // dataIndex basically ek pointer h, jo ki help karta h ye dekhne mein ki agla
        // hum kaun sa data entry kare ek particular list mein se
        int value;

        Pair(int listIndex, int dataIndex, int value) {
            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
            this.value = value;
        }

        public int compareTo(Pair other) {
            return this.value - other.value;
            // this helps to make an ordered priority queue, on the basis of int value
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();

        // write your code here

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // sabse pehle kitna lists h, uske jitna pair bana lenge, jo ki khud ek pointer
        // ki tarah use hoga, jo batayega ki agla kaun sa value hum utha sakte h wo list
        // ke andar se
        for (int i = 0; i < lists.size(); i++) {
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            pq.add(p);
        }

        // ye while loop se ye kaam hoga, ki mera lists.size() jitna jo hum pair banaye
        // h, usme se sabse pehle chota value wala uthayenge pair (priority queue mein)
        // se, aur fir wo pai ke hisaab se elements pickup karenge aur rv mein add karte
        // jayenge
        while (pq.size() > 0) {
            Pair p = pq.remove();
            rv.add(p.value);
            p.dataIndex++; // updating the dataindex so that agala value pe point kiya jaa sake wo
                           // particular list ka elements mein se

            // hum tabhi tak ke kaam karenge, jabtak dataindex mera koi particular list ka
            // last tak naa chala jaaye (i.e. size()-1)
            if (p.dataIndex < lists.get(p.listIndex).size()) {
                p.value = lists.get(p.listIndex).get(p.dataIndex);
                pq.add(p);
            }
        }

        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}