public class Kata {
  public static int findEvenIndex(int[] arr) {
      int index= -1,
          sum= 0,
          ltPre= 0,
          ltCur= 0,
          rtPre= 0,
          rtCur= 0;
      
      for(int i: arr) sum+= i;
      //System.out.println("sum: " + sum);
      
      ltCur = arr[0];
      rtCur = sum- ltCur;
      //System.out.println("  ltCur: " + ltCur + "  rtCur: " + rtCur + "\n");
                         
      if( (sum-arr[0]) == 0 ) return 0;
      if( sum-arr[arr.length-1] == 0 ) return arr.length-1;
      
      for(int i=1; i< arr.length; i++){
          if( ltCur == rtPre && rtCur == ltPre ){
              //System.out.println( "index: "+ (i-1) );
              return i-1;
          }else{
              ltPre = ltCur;
              rtPre = rtCur;
              ltCur = arr[i] + ltPre;
              rtCur = sum- ltCur;
              //System.out.println("ltPre: "+ ltPre + "  rtPre: "+ rtPre);
              //System.out.println("ltCur: "+ ltCur + "  rtCur: "+ rtCur + "\n");
          }
      }
      return -1;
  }
}
