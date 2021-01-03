public class Solution{
  
  public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves){
   
      if(moves.length == 0) return new String[]{};
      
      String[] cursor = new String[moves.length];
      int row= 0, col= 0;
    
      for(int i= 0; i< moves.length; i++){
        
          switch(moves[i]) {
            case "up":
                row--;
                if(row < 0) row= 0;
                cursor[i] = fighters[row][col];
              break;
            case "right":
                col++;
                if(col > 5) col= 0;
                cursor[i] = fighters[row][col];
              break;
            case "down":
                row++;
                if(row > 1) row= 1;
                cursor[i] = fighters[row][col];
              break;
            case "left":
                col--;
                if(col < 0) col= 5;
                cursor[i] = fighters[row][col];
              break;
            default:
              cursor[i]= fighters[row][col];
          }
      }
    
    return cursor;
  }
}
