public class ProdFib { // must be public for codewars 
  
  public static long[] productFib(long prod) {

    long fn= 0, fnPlusOne= 1, temp= 0;
    
    while(fn*fnPlusOne < prod){
      temp= fn;
      fn= fnPlusOne;
      fnPlusOne+= temp;
    }
    
    if( fn*fnPlusOne == prod )return new long[]{fn, fnPlusOne, 1};
    
    return new long[]{fn, fnPlusOne, 0};
   }
}
