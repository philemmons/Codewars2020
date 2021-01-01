// AUTHORS - jjvinar, fr0zen87, Miia Lamia, CzCz, Deam_Nocte, dyanlovezning, wbzhong, JustForYouH, Lolitalim, simon.nandhiyattu (plus 44 more warriors)
// AMAZING!!
// initializing the result array fills the elements with zeros AND the ascending sorting has the lowest element first, the open 'till'.

import java.util.Arrays;
public class Solution {

    public static int solveSuperMarketQueue(int[] customers, int n) {
      int[] result = new int[n];
      for(int i = 0; i < customers.length; i++){
        result[0] += customers[i];
        Arrays.sort(result);
      }
      return result[n-1];
    }
    
}
