public class Troll {
    public static String disemvowel(String str) {
        //replaceAll(String regex, String replacement)
        //Replaces each substring of this string that matches the given regular expression with the given replacement.
      
        //https://regexr.com/
      
      return str.replaceAll( "[aAeEiIoOuU]", "");
    
    }
}
