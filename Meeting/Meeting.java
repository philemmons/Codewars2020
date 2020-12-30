import java.util.*;
class Meeting {
    
    public static String meeting(String s) {
        // makes this string uppercase
        String upName = s.toUpperCase();  
        // split the names
        String[] names = upName.split(";");
        // sorting DS
        List<String> al = new ArrayList<>();
        // first and last name swap var
        String[] temp;
      
        for(int i= 0; i< names.length; i++){
            //prep for the swap
            temp = names[i].split(":");
            // Last name and first name of a guest come in the result between parentheses separated by a comma.
            al.add("("+ temp[1]+ ", "+ temp[0]+ ")");
        }
        // gives it sorted in alphabetical order by last name.
        // When the last names are the same, sort them by first name.(Including duplicates)
        Collections.sort(al);
        // back to a string
        upName = "";
        for(String obj: al) 
            upName+=obj;
        return upName;
    }
}
