import java.util.Arrays;

public class Kata {
  public static int[] DataReverse(int[] data) {
      //for(int i: data) System.out.print( i+ " ");
      //System.out.println();
      int totalBits= data.length,
          bit= 8,
          bytes= totalBits/bit,
          index= 0;
      int[] bizarro = new int[totalBits];
    
      for(int i= bit*(bytes-1); i> -1; i-=bit) {
         for(int k= i; k< i+bit; k++) {
           bizarro[index++]= data[k];
         }
      }
    //for(int i: bizarro) System.out.print( i+ " ");
    return bizarro;
  }
}
