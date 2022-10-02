import java.util.*;

public class Toggle_Case {
    public static String toggleCase(String str){
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i<sb.length(); i++){
            char ch = sb.charAt(i);
            // small p - small a = capital P - capital A (dist. same rehta h dono ka)
            //bas ab small ya capital nikaalne ke liye ek ko right side ya left side le jayenge to nikal jayega
            if(ch >= 'a' && ch <= 'z'){
                //below is logic for converting small case to upper case. isme capital A mein kya add kar sakte h ki mera
                //wahi character upper case mein aa jaye. wo add karenge character at i - small a.
                char upperch = (char)('A' + ch - 'a');//ye char mein wapas convert karne ke liye (char)(......) likhe h
                sb.setCharAt(i, upperch);
            }
            else{
                //same here, bas capital A ki jagah small a se minus karenge.
                char lowerch = (char)('a' + ch - 'A');//ye char mein wapas convert karne ke liye (char)(......) likhe h
                sb.setCharAt(i, lowerch);
            }
        }

        return sb.toString();
    }
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}