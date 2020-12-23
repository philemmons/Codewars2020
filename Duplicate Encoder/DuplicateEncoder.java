import java.util.*;

public class DuplicateEncoder {
  
	static String encode(String word){
    //O(1) access to Key, swap Val is also constant 
    HashMap<Character, Character> hm = new HashMap<>();
    //prep the input into chars used as the key
    char[] chArr = word.toLowerCase().toCharArray();
    
    //input validate char in hashmap, otherwise init Key, Val
    //O(n) to create hm from array
    for(int i=0; i<chArr.length; i++){
      //does the Key exist?
      if( !hm.containsKey(chArr[i]) ){
        // no, create new 
        hm.put(chArr[i], '(');
      }else{
        // yes, swap Val
        hm.replace(chArr[i], ')' );
      }
    }
    //update array from hm values
    for(int i= 0; i<chArr.length; i++){
      chArr[i]=hm.get(chArr[i]);
    }
      
    return new String(chArr);
  }
  
}
