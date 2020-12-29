
import java.util.Map;
import java.util.HashMap;

public class Solution
{
    public static int[] twoSum(int[] numbers, int target){
        
        Map<Integer, Integer> hm = new HashMap<>();
        int diff, dup= 0;
      
      // using the numbers array elements as keys will give O(1) lookup for the index 
        for(int i= 0; i<numbers.length; i++){
            if(!hm.containsKey(numbers[i]))
                hm.put(numbers[i], i);
            else
      // examining the number of duplicates in number arrays
                dup++;  
        }
      
        //System.out.println("# of duplicates: "+ dup);
      
        for(int i= 0; i<numbers.length; i++){
            diff = target- numbers[i];
            if(hm.containsKey(diff))
                return new int[]{ i, hm.get(diff)};
        }
        return new int[]{};
    }
}
