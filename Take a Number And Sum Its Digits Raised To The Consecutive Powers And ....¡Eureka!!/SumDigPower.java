import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

class SumDigPower {
    
    public static List<Long> sumDigPow(long a, long b) {
        //System.out.println(a +"  "+ b);
     
        ArrayList<Long> al = new ArrayList<>();
        ArrayList<Long> result = new ArrayList<>();

        char[] charArr;
        long exp, ans;
      
        for(long i= a; i<=b; i++) al.add(i);

        for(int i= 0; i< al.size(); i++){
            exp= 1L;
            ans= 0l;
            charArr= String.valueOf(al.get(i)).toCharArray();
        
            for(int k= 0; k< charArr.length; k++){
                ans+= Math.pow( Long.valueOf(String.valueOf( charArr[k]) ), exp++);
            }
         
            if(ans == al.get(i)) result.add(al.get(i));
        }
        return result;
    }
}
