public class DirReduction {
    public static String[] dirReduc(String[] arr) {
      String nesw= "";
      for(String s: arr) nesw+= s+ ",";
      
      while(nesw.contains("NORTH,SOUTH,") || nesw.contains("SOUTH,NORTH,") || nesw.contains("EAST,WEST,") || nesw.contains("WEST,EAST,")){
                nesw= nesw.replaceAll("NORTH,SOUTH,|SOUTH,NORTH,|EAST,WEST,|WEST,EAST,", "");
      }
      if(nesw.length()>0) 
          arr = nesw.split(",");
      else 
          return new String[]{};
      
      return  arr;
    }
}
