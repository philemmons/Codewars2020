public class StripComments {

  public static String stripComments(String text, String[] commentSymbols) {
      for(String s: commentSymbols) System.out.print(s + "  ");
      System.out.println();
      // special characters use two backslash, where as the alpha numeric chars do not
      String regex= "([\\";
      StringBuilder sb= new StringBuilder();// easy to append and delete
      String[] str= text.split("\n"); // removing the trailing comments from starting index to string's end
      
      for(String s: commentSymbols) {
          if(s.matches( "([0-9a-zA-Z])" ) ) regex = "([";
          for( int i= 0; i< str.length; i++) {
              // pad the front white spaces and avoid overkill the regex!
              str[i]= ("@" + str[i].replaceAll(regex+ s+ "].*)", "")).trim().substring(1);
          }
      }
      // join the string back together
      for(String s: str) {
          sb.append(s+ "\n");
      }
      // remove the last \n
      sb.delete(sb.length()-1, sb.length());
      
    return sb.toString();
  }
}
