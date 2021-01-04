// AUTHOR: trust-the-Process
// Great Exmaple, and super clean recursion

import java.util.*;

public class SumOfK {

    static Integer bestSum;
    
    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        bestSum = 0;
        choose(t, k, ls, 0, 0);
        return bestSum == 0 ? null : bestSum;
    }
    
    private static void choose(int t, int k, List<Integer> ls, int index, int sum) {
      if (sum > t)
        return;
      
      if (k == 0) {
        bestSum = Math.max(sum, bestSum);
        return;
      }
      
      for (int i = index; i < ls.size(); i++) {
        choose(t, k - 1, ls, i + 1, sum + ls.get(i));
      }
      
      return;
    }
}
