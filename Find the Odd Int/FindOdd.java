import java.util.Map;
import java.util.HashMap;

public class FindOdd {
	public static int findIt(int[] a) {
    
      Map<Integer, Integer> hm = new HashMap<>();
      int oddOne= 0;
    
      for(int i: a){
          if(!hm.containsKey(i)){
              hm.put(i, 1);
          }else{
              hm.put(i, hm.get(i)+1);
          }
      }
      // good review iterating through hashmap
      for (Map.Entry<Integer, Integer> itr : hm.entrySet()){
          if( itr.getValue() %2 != 0 ){
              oddOne= itr.getKey();
          }
      }
  	return oddOne;
  }
}
