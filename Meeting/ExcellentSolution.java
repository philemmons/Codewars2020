//Solution provided by krovosisya, denys12 - excellent job!

import java.util.Arrays;

class Meeting {   
  public static String meeting(String s) {
    String[] friends = s.toUpperCase().split(";");
        for (int i = 0; i < friends.length; i++){
            int index = friends[i].indexOf(":");
            friends[i] = "(" + friends[i].substring(index+1) + ", " + friends[i].substring(0,index) + ")";
        }
        Arrays.sort(friends);
        
        return String.join("", friends);
    }
}
