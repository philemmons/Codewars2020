import java.util.*;

class Rank {
    
    public static String nthRank(String st, Integer[] we, int n) {
      System.out.println(st);
      
      for(int i= 0; i<we.length; i++) System.out.print(we[i]+ " ");
      System.out.println("\n"+n);
      
        
        if(st.length() == 0) return "No participants";

        String[] name= st.split(",");
        if(n>name.length) return "Not enough participants";
        //Arrays.sort(name);
      
        int[] wn = new int[name.length];
        char[] chArr;
     // int wn= -1;
      //String[] wnName = new String[name.length];
        int[] wnSort = new int[name.length];
        Map<String, Integer> hm = new HashMap<String, Integer<>();
        //ArrayList<String> stringAL;
      // Each letter of a firstname has a value which is its rank in the English alphabet. 
        //   A and a have rank 1, B and b rank 2 and so on.
      
      
      
        // The length of the firstname is added to the sum of these ranks hence a number som.
        for(int k=0; k< name.length; k++){
            chArr = name[k].toCharArray();
            wn[k]+= chArr.length;
          
            for(int i= 0; i<chArr.length; i++){
                wn[k]+= Character.getNumericValue(chArr[i])-9;
            } 
          
            wn[k]*= we[k];
          
       
              hm.put( name[k], wn[k] ); 
          //}else{
            // same wn - sort name alpha,
            // hm.get(wn[k]).add(name[k]);
            // hm.get(wn[k]).replaceall( Collections.sort(hm.get(wn[k]) ) );
        //}
            System.out.println(name[k]+ "  "+ wn[k]);
           // wnName[k]= String.valueOf(wn[k])+", "+ name[k];
         }
        // Arrays.sort(wnName);
      //for(String i: wnName) System.out.print( i+ "  ");
//      for(int i= 0; i< name.length; i++){
//           if(!hm.containsKey(wn[i])){
//               hm.put(wn[i], name[i]);
//           }else{
//             //same wn - sort name alpha,
//            if(name[i].compareTo(hm.get(wn[i]))> 0){
//               hm.put(wn[i], name[i])
//           }
//      }
      
        //List<Integer> kl = new ArrayList<>(hm.keySet()); 
        //Collections.sort(kl, Collections.reverseOrder());
      
        // An array of random weights is linked to the firstnames and 
        //   each som is multiplied by its corresponding weight to get what they call a winning number.

        // sort the firstnames in decreasing order of the winning numbers. 
        //   When two people have the same winning number sort them alphabetically by their firstnames.  
      
      return "";
    }
}
