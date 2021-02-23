
import java.util.*;

public class ObservedPin {

    private static final Map<Character,String> ADJACENTS = new HashMap<Character,String>() {{
        put('1', "124");
        put('2', "2135");
        put('3', "326");
        put('4', "4157");
        put('5', "54268");
        put('6', "6953");
        put('7', "748");
        put('8', "87590");
        put('9', "986");
        put('0', "08");
    }};

    public static List<String> getPINs(String observed) {
        
        List<String> ans = Arrays.asList("");
        
        for (char c: observed.toCharArray()) {
        	System.out.println("c: "+ c);
            List<String> tmp = new ArrayList<String>();
            
            for (char cc: ADJACENTS.get(c).toCharArray()) {
            	System.out.println("cc :"+ cc);
                for (String s: ans){ tmp.add(s+cc);
                System.out.println("s: "+ s);
                System.out.println(tmp.toString());
                }
            }
            ans = tmp;
        }
        return ans;
    }

    
	public static void main(String[] args) {
		
		List<String> ls = getPINs("11"); 
		System.out.println("\n"+ ls.toString() );
		//String[] ans= new String[]{"11", "21", "41", "12", "22", "42", "14", "24", "44"};
		//System.out.println( Arrays.asList(ans).toString() );
	}

}
