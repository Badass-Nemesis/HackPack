import java.util.*;
public class Square_number {
    public static int f(int x){
        int xsquare = x* x;
        return (xsquare);
    }    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(f(n));
    }
}
