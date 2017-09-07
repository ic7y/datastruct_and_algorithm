package algorithm;

/**
 * @Description
 * @Author Created by t.wu on 2017/9/7.
 */
public class ReverseString {

    public static String reverseWords(String s) {
        if(s==null || s.length()==0){
            return s;
        }
        String[] arr = s.split(" ");
        for(int i=0 ; i< arr.length; i++){
            arr[i]=reverse( arr[i] );
        }
        String res = "";
        for(String str: arr){
            res+=str+" ";
        }
        res = res.substring(0,res.length()-1);
        return res;
    }
    private static String reverse(String s){
        System.out.println(s);
        int length = s.length();
        char[] res = s.toCharArray();
        for(int i = 0 ; i < length/2 ; i++){
            char tmp = s.charAt(i);
            res[i]=s.charAt(length-1-i) ;
            res[length-1-i]=tmp;
        }
        String d = String.valueOf(res);
        System.out.println(d);
        return  d;
    }
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println("arg=" + arg);
        }
        String sf= "Let's take LeetCode contest";
        System.out.println(reverseWords(sf));
    }
}
