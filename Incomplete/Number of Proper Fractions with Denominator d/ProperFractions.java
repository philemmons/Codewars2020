import java.math.BigInteger;

public class ProperFractions {
  public static long properFractions(long n) {
      //System.out.println("n: "+ n);
       
      BigInteger bigIntN = BigInteger.valueOf(n);
      BigInteger big1 = new BigInteger("1");
      long counter= 0;
    // numerator range is 1...n-1
    // between 0 and one exclusive!
    for(long i= 1; i< n; i++){
      if(BigInteger.valueOf(i).gcd( bigIntN ).compareTo(big1) == 0)
          counter++;
    }
      return counter;
  }
  //https://en.wikipedia.org/wiki/Euclidean_algorithm
  /****recursive timed out
  public static long gcd(long a, long b){
    if(b == 0)
        return a;
    else
        return gcd(b, a % b);
  }

  public static long gcd(long a, long b){
      while(a != b){ 
          if(a > b)
              a-= b;
          else
              b-= a;
      }
      return a;
  }
*/
}
