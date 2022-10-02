import java.util.*;

public class Demo_String{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        //normal decralation + initialization
        // String s1 = "hello";
        // String s2 = "hello";
        //the above two codes will have same address, as 'hello' will be present in intern pool.

        // String s = new String "hello";
        //this code will avoid interning, and 'hello' will be stored in new address.

        //In the above two declarations, the first two will have same shell address pointing to a character array address where 'hello'
        //is stored. But the 3rd code will have different shell address, and will also point to the same character array address
        //So, both the declarations are indirectly connected.

        //taking one whole line input. two consecutive inputs can be taken with only space between inputs
        // String s1 = scn.next();
        // String s2 = scn.next();

        //taking two line input. two inputs can be taken with one line for 1st input, and then second line
        //(by pressing enter) for 2nd input
        // String s1 = scn.nextLine();
        // String s2 = scn.nextLine();
        // System.out.println(s1);
        // System.out.println(s2);

        //for printing string length, we have to write the syntax as like we are calling a function
        // iska matlab simple h, bas ek () dena padega last mein extra.
        String s = scn.nextLine();
        System.out.println(s);
        System.out.println(s.length()); //  <- this line

        //s.charAt() -> ye syntax similar h array ke value access wala syntax se. arr[0] etc....
        //we use it to access the string array basically. to get value at 0 index -> s.charAt(0)
        char ch = s.charAt(0);
        System.out.println(ch);

        for(int i = 0; i<s.length();i++){
            //char ch = s.charAt(i);
            //System.out.println(ch);
            System.out.println(s.charAt(i));
        }

        String s1 = "abcd";
        //ye substring syntax sirf string[1 se 2] tak hi print karega, 3 ignore hoga.
        System.out.println(s1.substring(1,3)); 
        //s1.substring(0,0) -> isme kuch ni milega
        //s1.substring(3,2) -> isme exception milega
        //s1.substring(1) -> isme 1 se last tak print ho jayega sab. i.e. bcd print ho jayega
        for(int i = 0; i<s1.length();i++){
            for(int j = i+1; j<=s1.length();j++){
                //Substring ss = s1.substring(i,j);
                //System.out.println(ss);
                System.out.println(s1.substring(i,j));
            }
        }

        String s2 = "Hello";
        s2+=" ";
        s2+="w";
        s2+="o";
        s2+=10; // great thing about string, we can add int as well as char in it.
        //String s3 = "World"
        //String s4 = s2+" "+s3
        //System.out.println(s4);

        System.out.println(s2);
        //Important
        //System.out.println("Hello"+10+20); // -> iska output aayega Hello1020, 10 & 20 string banke add hoga
        //System.out.println(10+20+"Hello"); // -> isme pehle int h, isiliye iska output 30Hello aayega. 30 int string mein convert hoga.

        String s3 = "abc def ghi jkl mno";
        String[] parts = s3.split(" ");
        for(int i = 0; i<parts.length;i++){
            System.out.println(parts[i]);
        }
        //ye above code mein basically parts naam ka ek array bann gaya h normal, string element ke saath
        //s3.split(" "); -> iska matlab split karenge string ko space aane pe. jab space aayega, tab split
        //agar wo s3 string comma se separated hota, example String s3 = "abc,def,ghi,jkl mno"
        //to s3.split(","); -> ye code comma aane pe split kar dega string ko
        //lekin last mein "jkl mno" print hoga, kyunki usme comma ni h jo seplit ho jaaye
    }
}