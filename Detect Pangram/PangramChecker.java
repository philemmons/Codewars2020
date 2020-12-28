import java.util.*;

public class PangramChecker {
  
  public boolean check(String sentence){
    Set<Character> hs = new HashSet<>();
    char[] chArr = sentence.toLowerCase().toCharArray();
    
    for(char c: chArr){
      if( c >= 'a' && c <= 'z' && !hs.contains(c) ){
          hs.add(c);
          //System.out.println("char: "+ c);
      }
    }
    return hs.size() == 26;
  }
}
