import java.io.*;
import java.util.*;

public class Print_Encodings {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings(str, "");
    }

    public static void printEncodings(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        } else if (str.length() == 1) {
            char ch = str.charAt(0);
            if (ch == '0') {
                return;
            } else {
                // char code = (char)('a'+ch-'0'); -> isse value ni aayega. minus 1 karna padega
                char code = (char) ('a' + ch - '0' - 1);
                System.out.println(asf + code);
            }
        } else {
            char ch = str.charAt(0);
            String roq = str.substring(1);
            if (ch == '0') {
                return;
            } else {
                char code = (char) ('a' + ch - '0' - 1);
                printEncodings(roq, asf + code);
            }

            String ch12 = str.substring(0, 2);
            String roq12 = str.substring(2);

            int ch12value = Integer.parseInt(ch12);
            if (ch12value <= 26) {
                char code = (char) ('a' + ch - '0' - 1);
                printEncodings(roq12, asf + code);
            }
        }
    }

}


// import java.io.*;
// import java.util.*;

// public class Print_Encodings {

//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         String str = br.readLine();
//         printEncodings(str, "");
//     }

//     public static void printEncodings(String ques, String ans) {
//         if (ques.length() == 0) {
//             System.out.println(ans);
//             return;
//         } else if (ques.length() == 1) {
//             if (ques.charAt(0) == '0') {
//                 return;
//             } else {
//                 String ch0 = ques.substring(0, 1);
//                 String roq0 = ques.substring(1);
//                 String code0 = (char) ('a' + (Integer.parseInt(ch0) - 1)) + "";
//                 printEncodings(roq0, ans + code0);
//             }
//         } else {
//             if (ques.charAt(0) == '0') {
//                 return;
//             } else {
//                 String ch0 = ques.substring(0, 1);
//                 String roq0 = ques.substring(1);
//                 String code0 = (char) ('a' + (Integer.parseInt(ch0) - 1)) + "";
//                 printEncodings(roq0, ans + code0);

//                 String ch01 = ques.substring(0, 2);
//                 String roq01 = ques.substring(2);
//                 String code01 = (char) ('a' + (Integer.parseInt(ch01) - 1)) + "";

//                 if (Integer.parseInt(ch01) <= 26) {
//                     printEncodings(roq01, ans + code01);
//                 }
//             }
//         }
//     }
// }