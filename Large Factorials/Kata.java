import java.math.BigDecimal;

public class Kata{

  private static BigDecimal factorial(BigDecimal bdN) {
    if(bdN.equals(zero) || bdN.equals(one) ) return one;
    
    return bdN.multiply(factorial( bdN.subtract(one) ) );
  }
  
  private static BigDecimal one= new BigDecimal(1),
                              zero= new BigDecimal(0);
  
  public static String Factorial(int n) {
    //System.out.println("int n: "+ n);
    BigDecimal bdN = new BigDecimal(n);
    BigDecimal result = (factorial(bdN));
    
    return result.toPlainString();
  }
}
