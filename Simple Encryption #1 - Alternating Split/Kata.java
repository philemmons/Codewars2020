public class Kata {

  public static String encrypt(final String text, final int n) {
      if(text == null) 
          return null;
      if(text.length() <= 1 || n<= 0 ) 
          return text;
      
      char[] chArr = text.toCharArray();
      char[] enArr = new char[text.length()];
      int rtPart = text.length()/2, 
          ltPart = 0;
          
      for(int i= 0; i< chArr.length; i+=2){
         enArr[rtPart++] = chArr[i];
      }
      
      for( int i= 1; i< chArr.length; i+= 2){
        enArr[ltPart++] = chArr[i];
      }
      
      for(int i= 0; i< enArr.length; i++){
        chArr[i]=enArr[i];
      }
      //System.out.println(chArr);
  
      return encrypt( String.valueOf(chArr), n-1 );   
  }
  
  public static String decrypt(final String encryptedText, final int n) {
      if(encryptedText == null)
          return null;
      if(encryptedText.length() <= 1 || n<= 0) 
          return encryptedText;
      
      char[] chArr = encryptedText.toCharArray();
      char[] deArr = new char[encryptedText.length()];
      int rtPart = encryptedText.length()/2, 
          ltPart = 1, 
          ptr =0;
      
      for(int i= rtPart; i< chArr.length; i++){
        deArr[ptr] = chArr[i];
        ptr+=2;
      }
      
      for( int i= 0; i< rtPart; i++){
        deArr[ltPart] = chArr[i];
        ltPart+=2;
      }
      
      for(int i= 0; i< deArr.length; i++){
        chArr[i] = deArr[i];
      }
     // System.out.println(chArr);
      return decrypt( String.valueOf(chArr), n-1 );
   }
}
