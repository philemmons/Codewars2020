import java.util.Arrays;

public class Kata {

  public static long nextSmaller(long n) {
//      System.out.println(n);
      
      char[] chArr= String.valueOf(n).toCharArray();
      int index= chArr.length -2,// initialize index to start comparing digit to the right
          x= -1,// first digit that has smaller digit to its right
          y= -1;// largest digit that is to the right of x and is smaller than x
      boolean go= true;// avoid break in loop - no pasta here
      char temp;// swap variable
      
      // find x
      while(index > -1 && go) {
          if(chArr[index]>chArr[index+1]) {
              x= index;
              go= false;
          }else
              index--;
      }
      //all digits are in ascending or equal value
      if(x==-1) return -1;
      
      // find y
      int value=0;
      while(index < chArr.length) {
          if(chArr[x]>chArr[index] && chArr[index]>value ) {
              y= index;
              value= chArr[index];
          }
          index++;
      }
      // all the digits are larger than x
      if(y==-1) return -1;
      
      // swap elements at index x and y
      temp= chArr[x];
      chArr[x]= chArr[y];
      chArr[y]= temp;
            
      // 0721 is out since we don't write numbers with leading zeros
      if(chArr[0]=='0') return -1;
      
      // is there any digits right of y?
      x= (x < chArr.length-1)? x+1: x;
    
      // sort all of the digits to the right of Y in descending order
      // x is the swapped index of y, hence x
      char[] sortArr = Arrays.copyOfRange(chArr, x, chArr.length);
      Arrays.sort(sortArr);
    
      // copy the sorted array in descending order, from x-index to the end of array
      for(int i= x, k=sortArr.length-1; i<chArr.length; i++, k--) 
          chArr[i]=sortArr[k];
      
      return Long.valueOf(String.valueOf(chArr));
    }
}
