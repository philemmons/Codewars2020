
class Kata {
  public static String getMiddle(String word) {
    int wordLen = word.length(),
        half = wordLen/2;
    
    if(wordLen == 1) return word;
    
    if( wordLen % 2 == 0 ){
      // substring(start index, ending index- not included)
      return word.substring( half-1, half+1 );
    }else{
      return String.valueOf( word.charAt( half ) );
    } 
    
  }
}
