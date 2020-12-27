public class NthSeries {
  
  public static String seriesSum(int n) {
      // n, only be given Natural Numbers as arguments
      // If the given value is 0 then it should return 0.00
      if( n==0 ) return "0.00";
      
      double sum= 0.0;
      //sum up series up to n times
      //    1/1 + 1/4 + 1/7 + 1/10 + 1/13...
      //  n=  0     1     2      3      4
      //  1/3n+1
      n--;
      while( n > -1 ){
          //remember decemials or sum will java will treat them as INTS
          sum+= 1.0/(3.0*n + 1.0);
          n--;
      }
      //https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
      return String.format("%.2f", sum);
  }

}
