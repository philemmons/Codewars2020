import java.util.*;

public class TopWords {
    
    public static List<String> top3(String s) {
        //System.out.println("s: "+ s);
        String regex1= "([_?;!.-/:,-])|\\n",
               regex2= "\\B(['])|([\\s{1}])\\B";            
        s= s.toLowerCase().replaceAll(regex1, " ").replaceAll(regex2, "").trim();

        if( s.equals("") ) return new ArrayList<String>();
      
        Map<String, Integer> hm= new HashMap<>();
        List<String> sList = new ArrayList<>();
        
        String[] strArr = s.split(" ");
        for(String word: strArr){
            if(!hm.containsKey(word))
                hm.put(word, 1);
            else hm.put(word, hm.get(word)+1);
        }

       // https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
       // https://www.tutorialspoint.com/java/java_mapentry_interface.htm
       // https://www.tutorialspoint.com/java/util/hashmap_entryset.htm
       // Sort the list 
        List< Map.Entry<String, Integer> > l = 
               new ArrayList< Map.Entry<String, Integer> >( hm.entrySet() ); 

        Collections.sort(l, new Comparator< Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> small, Map.Entry<String, Integer> big){
                return (big.getValue()).compareTo(small.getValue()); 
            } 
        }); 

      int index= 3;
      if(l.size()<3) index= l.size(); 
      for(int i= 0; i<index; i++){
          sList.add(l.get(i).getKey() );
      }
        //System.out.println(sList.toString());
      return sList;
    }
}
