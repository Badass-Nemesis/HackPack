import java.lang.reflect.Array;
import java.util.*;

public class Demo_Arraylists{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list + " -> " + list.size()); 
        //list is to access the contents list size is to give current list size

        list.add(10);// code to add something in list
        list.add(20);
        list.add(30); 
        System.out.println(list + " -> " + list.size());

        list.add(1, 1000);//code to add something in middle of list
        System.out.println(list + " -> " + list.size());

        list.set(1, 2000);//code to change/replace the value at index
        System.out.println(list + " -> " + list.size());

        int val = list.get(1); //get content from 1st index
        System.out.println(val);

        list.remove(1);//code to remove from 1st index
        System.out.println(list + " -> " + list.size());

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("bello");
        list2.add("cello");
        System.out.println(list2 + " -> " + list2.size());

        for(int i = 0; i<list.size(); i++){
            int val1 = list.get(i);
            System.out.println(val1);
        }

        for(int val1 : list){
            System.out.println(val1);
        }

        //above are two for loops code to print the value of arraylists iteratively

        System.out.println(list);
    }
}