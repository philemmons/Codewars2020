import java.util.*;

public class Xbonacci {

  public double[] tribonacci(double[] s, int n) {
      // hackonacci me
      if( n== 0 ) return new double[]{};
      
      // init new array
      double[] tb;
    
      //copy first 3 elements from s to tb
      //https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#copyOf(double[],%20int)
      tb = Arrays.copyOf(s, n);
    
      for(int i= 3; i< tb.length; i++){
        tb[i]= tb[i-3]+tb[i-2]+tb[i-1];
      }
    
      return tb;
  }
}
