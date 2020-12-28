import java.util.*;

public class Keypad {
  public static int presses(String phrase) {
    
    System.out.println(phrase);
    
    Map<Character,Integer> hm = new HashMap<>();
    String[] group = new String[]{"1adgjmptw* #", "behknqux0", "cfilorvy", "23456s8z", "79"};
    char[] chArr;
    int numPress = 0;
    
    for(int i=0; i< group.length; i++){
        chArr = group[i].toCharArray();
        for(int k= 0; k< chArr.length; k++){
          hm.put(chArr[k], i+1);
        }
    }
    
    chArr = phrase.toLowerCase().toCharArray();
    for(int i= 0; i<chArr.length; i++){
      if( hm.containsKey(chArr[i]) )
          numPress+= hm.get(chArr[i]);
    }
    //System.out.println("numPress: " + numPress);
    return numPress;
  }
}
