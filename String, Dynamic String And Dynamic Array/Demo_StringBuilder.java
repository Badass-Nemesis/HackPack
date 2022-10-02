import java.util.*;

public class Demo_StringBuilder {
    public static void main(String[] args){
        //declaration + initialization
        StringBuilder sb = new StringBuilder("hello");
        System.out.println(sb);

        char ch = sb.charAt(0);
        System.out.println(ch);

        //in normal string, we couldn't change the string (string is immutable), but stringbuilder is mutable/changable.
        sb.setCharAt(0,'d');
        System.out.println(sb);

        //we can also insert anything with 'insert' function in stringbuilder
        sb.insert(2,'y');
        System.out.println(sb);

        //we can also delete anything with 'delete' function in stringbuilder
        sb.deleteCharAt(2);
        System.out.println(sb);

        //add string element at it's last place
        sb.append('g');
        System.out.println(sb);

        System.out.println(sb.length());

        int n = 100000;
        long start = System.currentTimeMillis();

        //String gives bad performance due to immutability and interning. i.e. new memory will be allocated
        //if we try to add something at the last of string. that's why this below for loop will have O(n^2) complexity

        // String s = "";
        // for(int i = 0;i<n;i++){
        //     s+=i;
        // }

        //StringBuilder gives good performance because it is mutable and works in same memory.
        //below for loop will have O(n) complexity
        StringBuilder sbu = new StringBuilder();
        for(int i = 0; i<n;i++){
            sbu.append(i);
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println(duration);
    }    
}
