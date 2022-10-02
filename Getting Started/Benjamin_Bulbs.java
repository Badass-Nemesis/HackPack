import java.util.*;
public class Benjamin_Bulbs {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //Logic -> Benjamin bulbs wala puzzle mein sirf square numbers hi on reh paa rahe h, if initial is off.
        //Isiliye humlog ko bas perfect square print kar dena h.
        for(int i = 1; i*i<=n;i++){
            System.out.println(i*i);
        }
    }
}
