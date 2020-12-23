import java.util.*;

public class EnoughIsEnough {

  public static int[] deleteNth(int[] elements, int maxOccurance) {
  
    //OMG - 2 hours to debug!!! 
    if( maxOccurance <= 0 || elements == null || elements.length == 0 ) return new int[] {};
    
    Map<Integer, Integer> hm = new HashMap<>();
    ArrayList<Integer> al = new ArrayList<>(0);
    int hmVal = 0;
    int arrVal = 0;
    
    for(int i= 0; i< elements.length; i++){
       arrVal = elements[i];
      if( !hm.containsKey( arrVal ) ){
        hm.put(arrVal, 1);
      }else{
        if( hm.get(arrVal) < maxOccurance)
            hm.replace(arrVal, hm.get(arrVal)+1 );
      }
    }
    
    for(int i=0; i<elements.length; i++){
      arrVal = elements[i];
      hmVal = hm.get(arrVal);
      if( hmVal > 0){
        al.add(arrVal);
        hm.replace(arrVal, hmVal-1 );
      }   
    }
    
    int[] array = new int[ al.size() ];
    //System.out.println(al.size() + "   " + array.length );
    for(int i=0; i< array.length; i++){
      array[i]=al.get(i);
    }
		return array;
	}//EOF
}//EOC
