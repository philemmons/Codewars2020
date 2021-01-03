public class Dinglemouse {

  public static int countDeafRats(final String town) {
      // System.out.println("Town: "+ town);
      // How many deaf rats are there?
      // P = The Pied Piper, O~ = Rat going left, ~O = Rat going right
    
      String s = town.replaceAll(" ", "");
      int deaf, p = s.indexOf('P');
      // check to see if the P it at the begin or end of string
      // skip the left right halves
      if(s.startsWith("P")){
          deaf= half(s, true);
      }else if(s.endsWith("P")){
          deaf= half(s, false);
      }else{
          //divide into left half and right half of Piper
          String left= s.substring(0, p+1);
          String right= s.substring(p, s.length());
          deaf= half(left, false) + half(right, true);
      }
    return deaf;
  }
  
  public static int half(String l, boolean side){
      int d= 0;
      char head= 'O', tail= '~';
      if(side){
           head= '~';
           tail= 'O';
      }
      char[] chArr= l.replace("P", "").toCharArray();
      for(int i= 0; i< chArr.length; i+=2){
          if( chArr[i] == head && chArr[i+1] == tail )
              d++;
      }
      return d;
  }
  
}
