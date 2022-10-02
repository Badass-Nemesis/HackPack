import java.util.*;
public class Prime2 {
    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();
        for(int i = low; i<=high; i++){
            int divisor =0;
            for(int j=2; j*j<=i;j++){
                if(i%j==0){
                divisor++;
                break;
                }
            }
            if(divisor == 0){
                System.out.println(i);
            }
        }
    }
}