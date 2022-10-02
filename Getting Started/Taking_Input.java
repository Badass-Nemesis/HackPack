import java.util.*;
public class Taking_Input {
    public static void main(String[] args){
        Scanner scn = new Scanner (System.in);
        
        int n = Integer.parseInt(scn.nextLine()); //for taking input of both input and string
        // int n = scn.nextInt(); //normal code for integer input
        for (int i=0;i<=n;i++){
            System.out.println(i);
        }

        String name = scn.nextLine(); //normal code for string input
        System.out.println("Hello "+name);
    }
}
