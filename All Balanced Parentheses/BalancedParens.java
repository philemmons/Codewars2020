import java.util.*;

public class BalancedParens {
	
	public static String join(String ans, int i) {
		  return ans.substring(0, i)+ "()"+ ans.substring(i);
	}

	public static List <String> balancedParens (int n) {
		  System.out.println("n-pair of parenthesis: "+ n);
		  if(n== 0) return Arrays.asList("");
		   
	    Set<String> lhsCurr = new LinkedHashSet<>();
	    Set<String> lhsNext = new LinkedHashSet<>();
	    
	    lhsCurr.add("");
	    
	    for(int i= 0; i< n; i++) {
		   for(String s: lhsCurr) {
			   for(int k= 0; k<= s.length(); k++) {
				   lhsNext.add(join(s, k));
			   }
		   }
		   lhsCurr.clear();
		   lhsCurr.addAll(lhsNext);
		   lhsNext.clear(); 
	    }
	   
	   List<String> result = new ArrayList<>(lhsCurr.size());
	   for(String s: lhsCurr)
		   result.add(s);
	    
	   return result;
    }
}
