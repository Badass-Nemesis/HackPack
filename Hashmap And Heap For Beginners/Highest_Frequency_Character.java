import java.util.*;

public class Highest_Frequency_Character {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                int frequency = hm.get(s.charAt(i));
                hm.put(s.charAt(i), frequency + 1);
            } else {
                hm.put(s.charAt(i), 1);
            }
        }
        scn.close();

        char highestFrequencyChar = s.charAt(0);
        for (char ch : hm.keySet()) {
            if (hm.get(ch) > hm.get(highestFrequencyChar)) {
                highestFrequencyChar = ch;
            }
        }

        System.out.println(highestFrequencyChar);
    }
}
