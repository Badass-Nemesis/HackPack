// import java.util.*;

// public class Get_Subsequence {
//     public static void main(String[] args) throws Exception {
//         Scanner scn = new Scanner (System.in);
//         StringBuilder str = new StringBuilder(scn.next());
//         ArrayList<StringBuilder> res = gss(str);
//         System.out.println(res);
//     }

//     public static ArrayList<StringBuilder> gss(StringBuilder str) {
//         if(str.length()==0){
//             ArrayList<StringBuilder> bres = new ArrayList<>();
//             bres.insert(0,'');
//         }
//     }

// }

import java.io.*;
import java.util.*;

public class Get_Subsequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> res = gss(str);
        System.out.println(res);
    }

    // bc -> [ --,-c ,b-, bc ]
    // abc-> [ ---,--c, -b-, -bc, a--,ab-,abc]

    public static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>(); //bres = base result
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rres = gss(ros); //rres = recursion result
        ArrayList<String> mres = new ArrayList<>(); //mres = my result
        for (String val : rres) {
            mres.add("" + val);
        }
        for (String val : rres) {
            mres.add(ch + val);
        }

        return mres;
    }

}