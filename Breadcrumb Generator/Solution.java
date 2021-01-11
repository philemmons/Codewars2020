import java.util.*;

public class Solution {
    
    public static String generate_bc(String url, String separator) {
        //System.out.println("url: "+ url);
        //System.out.println("separator: "+ separator);
      
        if(url.contains("index")) url = url.substring(0, url.indexOf("index"));
        if(url.contains("://")) url= url.substring(url.indexOf("//")+2, url.length() ); 
        
        //data containers
        String[] urlArr = url.split("/");
        int index= urlArr.length-1;//last crumb not included
        String acron;
        StringBuilder ans= new StringBuilder();
        
        //System.out.println(Arrays.toString(urlArr));
        
        //first crumb and default crumb
        if(urlArr.length == 1) return  "<span class=\"active\">HOME</span>";
        
        ans.append(urlArr[0].replace(urlArr[0], "<a href=\"/\">HOME</a>"));
        
        //last crumb pre-process
        urlArr[index]= urlArr[index].replaceAll("([!*+?=~.#&]+)\\w+", "");
        if(urlArr[index].isEmpty()) index--;
        
        acron= urlArr[index];
        if(acron.length()<=30) acron= acron.replaceAll("-", " ");
        else {
          acron= acron
            .replaceAll("\\b(the|of|in|from|by|with|and|or|for|to|at|a)\\b", "")
            .replaceAll("(\\B[a-z]|-)", "");
        }
        String last= "<span class=\"active\">"+ acron.replaceAll("([!*+?=~.#&]+)\\w+", "").toUpperCase()+ "</span>";
        
        String trail= "";
        //need to stack the crumbs  eg  home a  a/b  a/b/c   active 
        for(int i= 1; i< index; i++) {
          acron = urlArr[i];
          trail+= urlArr[i]+ "/";
          if(acron.length()<=30) 
            acron= acron.replaceAll("-", " ");
          else { 
            acron= acron
                .replaceAll("\\b(the|of|in|from|by|with|and|or|for|to|at|a)\\b", "")
                .replaceAll("(\\B[a-z]|-)", "");
          }
          ans.append(separator+ "<a href=\"/"+ trail+ "\">"+ acron.toUpperCase()+ "</a>");
        }
          
        //add the last crumb
        ans.append(separator + last);
        
        //display and return gen_bc
        //System.out.println(ans);
        return ans.toString();
    } 
  }
