import java.util.*;

public class StockList { 
  // 1st parameter is the stocklist (L in example), 
	// 2nd parameter is list of categories (M in example)
	public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
    
      if( lstOfArt.length== 0 || lstOf1stLetter.length== 0 ) return "";
    
      Map<String, Integer> hm = new HashMap<>();
      String[] apart;
      String letter, category = "", strVal;
      int value;
    
      for(int i= 0; i< lstOfArt.length; i++){
          apart = lstOfArt[i].split("\\s");
          letter = apart[0].substring(0,1);
          value = Integer.valueOf(apart[1]);
        
          if( !hm.containsKey( letter )){
              hm.put(letter, value);
          }else{
              hm.put(letter, hm.get(letter)+ value);
          }
      }
      
      for(String s: lstOf1stLetter){
          if(!hm.containsKey(s)){
              strVal = "0";
          }else{
              strVal = String.valueOf( hm.get(s) );
          }
          category+= "("+ s +" : "+ strVal +") - ";
      }
		  return category.substring(0, category.length()-3);
	}
}
