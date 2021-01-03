import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static String dashatize(int num) {
        //System.out.println(num);
        //not an integer, return an empty value.
        if(num != (int)num) return "";
      
        // the negative sign should be removed AND - 2's compliments for int!!
        // https://stackoverflow.com/questions/5444611/math-abs-returns-wrong-value-for-integer-min-value
        long n = Math.abs((long)num);
      
        // Return a string
        String ans= "";
        char[] chArr = Long.toString(n).toCharArray();
        Queue<Character> cQ = new LinkedList<>();
      
        for( char c: chArr) cQ.add(c);
      
        //  dash'-'marks before and after each odd integer,
        if(Character.getNumericValue( cQ.peek() ) % 2 != 0) ans+= cQ.poll()+ "-";
      
        while(!cQ.isEmpty()){
            if( Character.getNumericValue( cQ.peek() ) % 2 != 0 ){
                if( ans.endsWith("-") )
                    ans+= cQ.poll()+ "-";
                else
                    ans+= "-"+ cQ.poll()+ "-";
            }else{
                ans+= cQ.poll();
            }
        }
        // do not end the string with a dash mark.
        if(ans.endsWith("-")) ans = ans.substring(0, ans.length()-1);
        //System.out.println(ans);
        return ans;
    }
}
