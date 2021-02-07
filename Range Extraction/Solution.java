//import java.util.Arrays;

class Solution {
  
    public static String rangeExtraction(int[] arr) {
        //System.out.println( Arrays.toString(arr) );
            
        int index= 0; // start of the consecutive numbers
        String ans = "";
            
        for(int i= 0; i< arr.length-1; i++) {
            if(arr[i]+1 != arr[i+1]) // are they consecutive?
                ans+=(arr[i]+ ",");
            else {
                index= i;
                // i var increases until non consecutive
                while(i< arr.length-1 && arr[i]+1 == arr[i+1] ) i++;
          
                if(i-index < 2) // more than two consecutive numbers
                    ans+=(arr[index]+ ","+ arr[i]+ ",");
                else if(index != i) // more elements after consecutive numbers
                    ans+=(arr[index]+ "-"+ arr[i]+ ",");
                else 
                    ans+=("-"+ arr[i]); // only consecutive numbers
            }
            if(i+1 == arr.length-1) // at the end of the i loop, add the last non-consecutive number
                ans+=arr[i+1]+",";
        }// remove the blasted comma!
        return new StringBuilder(ans).deleteCharAt(ans.length()-1).toString();
    }
}
