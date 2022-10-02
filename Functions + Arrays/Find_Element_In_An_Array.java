import java.util.*;
public class Find_Element_In_An_Array {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] a = new int [n];

        for (int i = 0; i<a.length;i++){
            a[i] = scn.nextInt();
        }

        int data = scn.nextInt();
        int index = -1;
        for(int i = 0; i<a.length; i++){
            if(a[i] == data){
                index = i;
                break;
            }
        }

        System.out.println(index);
    }    
}
