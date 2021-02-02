import java.math.BigInteger;

public class Fusc {

      //recursively
//    public static BigInteger goRec( BigInteger n ) {
//        if( n.compareTo(BigInteger.ONE) == 0 ) return BigInteger.ONE;//.add(b.multiply( BigInteger.TWO ));
//        if( n.mod(BigInteger.TWO).equals(BigInteger.ZERO) ) {
//          return goRec( n.divide(BigInteger.TWO));
//        }
//        else {
//          return goRec( ( n.subtract(BigInteger.ONE) ).divide(BigInteger.TWO) ).add(
//              goRec( ( n.add(BigInteger.ONE) ).divide(BigInteger.TWO) ) ); 
//        }
//  }
  
  //Thank you ecolban - 
  //Try to think of alternative ways of testing for odd or even. 
  //May-be precompute/get all the bits of n in one operation. 
  //A number is stored in binary, isn't it? No need to recompute the bits.
  //Also, further reading by E.Dijkstra - https://www.cs.utexas.edu/users/EWD/transcriptions/EWD05xx/EWD578.html
  
  public static BigInteger fusc (BigInteger n) {
    //System.out.println("BigInteger 'n': "+ n.toString()); // wow! huge numbers
    BigInteger biA = BigInteger.valueOf(1),
           biB = BigInteger.valueOf(0),
           biZero= BigInteger.ZERO,
           biOne= BigInteger.ONE,
           biTwo= BigInteger.TWO;   
    
    if(n.compareTo(biZero) == 0) return biZero;

    while(n.compareTo(biZero) == 1 ) { // n>1, so when (a,b,0)= b;
        //EVEN number 2n
        if(!n.testBit(0)) {   // see above
            n= n.shiftRight(1); // n/2
            biA= biA.add(biB);  // (a+b,b)
        //ODD number 2n+1
        }else { 
            n= (n.subtract(biOne)).shiftRight(1); // (n-1)/2
            biB= biB.add(biA); // (a,b+a)
        }
    }
    return biB;
    }
}
