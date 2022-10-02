import java.util.*;

public class Any_base_to_any_base {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b1 = scn.nextInt();//source base
        int b2 = scn.nextInt();//convert to what base
        int d = getValue(n,b1,b2);
        System.out.println(d);
    }

    public static int getValue(int n, int b1, int b2){
        int dec = anybasetodecimal(n, b1);
        int destination = decimaltoanybase(dec, b2);
        return destination;
    }

    public static int decimaltoanybase(int n, int b) {
        int rv = 0;
        int p = 0;
        while (n > 0) {
            int dig = n % b;
            n = n / b;
            rv = rv + dig * (int) Math.pow(10, p);
            p++;
        }
        return rv;
    }

    public static int anybasetodecimal(int n, int b) {
        int rv = 0;
        int p = 0;
        while (n > 0) {
            int dig = n % 10;
            n = n / 10;
            rv = rv + dig * (int) Math.pow(b, p);
            p++;
        }
        return rv;
    }
}
