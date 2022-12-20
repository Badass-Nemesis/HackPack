import java.util.*;

public class Introduction {
    public static void main(String[] args) {
        // ____________________________________HASHMAP___________________________________

        // one main thing to remember is that we won't get the output of sysout in the
        // same order that we put the values into hashmap.... i.e. we can't decide the
        // arrangement of the elements in hashmap
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 250);
        hm.put("China", 300);
        hm.put("Russia", 30);
        hm.put("Pak", 20);
        hm.put("US", 25);
        hm.put("UK", 10);

        System.out.println(hm);

        hm.put("Nigeria", 5); // inserting new value
        hm.put("India", 260); // updating existing value using the right Key

        System.out.println(hm);

        System.out.println(hm.get("India")); // prints only the value, not the keys
        System.out.println(hm.get("Utopia")); // will return null because Utopia is not there

        System.out.println(hm.containsKey("India")); // true
        System.out.println(hm.containsKey("Utopia")); // false

        Set<String> keys = hm.keySet(); // storing all the keys of hm into this keyset
        System.out.println(keys);

        for (String key : hm.keySet()) {
            Integer val = hm.get(key);
            System.out.println(key + " " + val);
        }

        // ____________________________________HEAP______________________________________

        // priority queue is also a queue, it follows FIFO. just one difference that it
        // arranges the element in according to a priority. by default the priority is
        // given first to smallest element (i.e. the smallest element will have higher
        // priority). based on the priority, the first one with higher priority will get
        // out if we give remove command to it.

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // isse choti values ko priority milegi
        PriorityQueue<Integer> pqr = new PriorityQueue<>(Collections.reverseOrder()); // isse badi value ko priority milegi

        int[] ranks = { 22, 99, 3, 11, 88, 4, 1 };
        for (int val : ranks) {
            pq.add(val);
            pqr.add(val);
        }
        // since add humara log(n) complexity ka h, aur for loop n baar chala h, to
        // isiliye total input jo diye h wo nlog(n) complexity ka h

        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
        while (pqr.size() > 0) {
            System.out.println(pqr.peek());
            pqr.remove();
        }
        // similarly like above, ye remove and print wala bhi nlog(n) complexity ka h
    }
}