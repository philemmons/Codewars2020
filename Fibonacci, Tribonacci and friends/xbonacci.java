// There is an precision loss when n and the sum on signature are high.
// eg 
// expected:<1.8109248265773008E16> but was:<1.8109248265773004E16>

import java.util.Arrays;

public class Xbonacci {
  
  public double[] xbonacci(double[] signature, int n) {

      if(n== 0) return new double[]{};
     
      double sum= 0.0;
      int sigIndex= 0;
      for(double d: signature){
          sum+= d;
      }
    
//System.out.println("N: "+ n+"  Sig sum: " + sum);  
    
      // init new array, copy first n elements from signature to tb, and padded with zero's
      //https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#copyOf(double[],%20int)
      double[] tb= Arrays.copyOf(signature, n);

      for(int i= signature.length; i< tb.length; i++){
          tb[i]= sum;
          sum+= ( tb[i]-tb[sigIndex++] );
      }
    
//System.out.println(Arrays.toString(tb));
    
      return tb;
  }
}
