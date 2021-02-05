import java.util.HashMap;
import java.util.Map;
/*
      | Symbol | Value |
    |----------------|
    | I      |  1    |
    | V      |  5    |
    | X      |  10   |
    | L      |  50   |
    | C      |  100  |
    | D      |  500  |
    | M      |  1000 |
    
      Thousands Hundreds  Tens  Units
    1   M       C         X     I
    2   MM      CC        XX    II
    3   MMM     CCC       XXX   III
    4           CD        XL    IV
    5           D         L     V
    6           DC        LX    VI
    7           DCC       LXX   VII
    8           DCCC      LXXX  VIII
    9           CM        XC    IX
    notice the 4 and 9 are subtracting 
    https://en.wikipedia.org/wiki/Roman_numerals
 */

public class RomanNumerals {

    public static String toRoman(int n) {
      System.out.println("\ntoRoman n: "+ n);
      //assuming 1 to 9999
      
      String[]  hund= new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, 
            tens= new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            unit= new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
      
      String strN = Integer.toString(n),
             th="", hu="", te="", un="";
      int len = strN.length();
      
      //match the digit in the first index(length-1) to the Roman numeral
      //skipping the zero
      
      if(len > 0) {
       un= unit[Character.getNumericValue(strN.charAt(len-1))];
      }
      if(len > 1) {
        te= tens[Character.getNumericValue(strN.charAt(len-2))];
      }
      if(len > 2) {
        hu= hund[Character.getNumericValue(strN.charAt(len-3))];
      }
      if(len > 3) {
       for( int i=0; i< Character.getNumericValue(strN.charAt(len-4)); i++){
          th+="M";
        }
      }
      return th+hu+te+un;
    }
   
    
   public static int fromRoman(String romanNumeral) {
      System.out.println("\nfromRoman romanNumeral: "+ romanNumeral);
      
      char[] k= new char[] {'I','V','X','L','C','D','M'};
      int[] v= new int[] {1,5,10,50,100,500,1000};
      Map<Character, Integer> hm= new HashMap<>();
      
      for(int i= 0; i< k.length; i++)  
          hm.put(k[i],  v[i]);
     
      int len= romanNumeral.length(),
          acc= 0,
          left;
       
      // 4's - CD XL IV
      // 9's - CM XC IX
      for(int i=len-1; i> -1; i--){
          char key= romanNumeral.charAt(i);
          //if the key is, will the index to the left be
          // v,   x -- i
          // l,   c -- x
          // d,   m -- c
          // if yes subtract
          acc+=hm.get(key);
          left= i-1;
          if(-1 < left) {
              if( romanNumeral.charAt(left)== 'I' && (key== 'V'||key== 'X') ) {
                acc-=1;
                i--;
              }else if( romanNumeral.charAt(left)== 'X' && (key== 'L'||key== 'C') ) {
                acc-=10;
                i--;
              }else if( romanNumeral.charAt(left)== 'C' && (key== 'D'||key== 'M') ) {
                acc-=100;
                i--;
              } 
          } 
      }
      return acc;
     }
  }
