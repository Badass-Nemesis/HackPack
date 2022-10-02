import java.util.*;

public class String_Compression {
    public static String compression1(String str){
		String s = str.substring(0,1);
        //if you want to use charAt to get string, then write below code
        // String s = str.charAt(0) + "";

        for(int i = 1; i<str.length();i++){
            char current = str.charAt(i);
            char previous = str.charAt(i-1);
            if(current!=previous){
                s+=current;
            }
        }
		return s;
	}

	public static String compression2(String str){
		String s = str.substring(0,1);
        //if you want to use charAt to get string, then write below code
        // String s = str.charAt(0) + "";

        int count = 1;
        
        for(int i = 1; i<str.length();i++){
            char current = str.charAt(i);
            char previous = str.charAt(i-1);
            if(current==previous){
                count++;
            }
            else{
                if(count>1){
                    s+=count;
                }
                s+=current;
            }   
        }
        if(count>1){
            s+=count;
        }
		return s;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}