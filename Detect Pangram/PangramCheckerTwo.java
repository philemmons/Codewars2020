public class PangramCheckerTwo {
  public boolean check(String sentence){
  
  //NOTE: the iteration of characters
  //thank you: aei1967, Dadaji, Ja67, Ruslan Havrylenko, cristhianp, APRobertson, Jhon Huamani, Udiane, Turi-byte, HotCurry (plus 9 more warriors)
  
        for (char c = 'a'; c<='z'; c++)
        
            if (!sentence.toLowerCase().contains("" + c))
                return false;
        return true;

  }
}
