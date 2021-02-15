/*  https://stackoverflow.com/questions/46978133/base91-how-is-it-calculated
	
	First, you need to see the input as a bit stream!
	
	Then, read 13 bits from the stream, and form an integer value from it. 
	If the value of this integer is lower than or equal to 88 (1011000), then read 
	one additional bit, and put it into the 14th bit (lowest bit being 1st) 
	of the integer. This integer's (let's call it v) maximum value is: 8192+88 = 8280.
	
	Then split v into two indices: i0 = v%91, i1 = v/91. Then use a 91
	-element character table, and output two characters: table[i0], table[i1].
	
	(now you can see the reason of 88: for the maximal value (8280), both i0 and i1 become 90)
	
	So this process is more complicated than base64, but more space 
	efficient. Furthermore, unlike base64, the size of the output is
	a little bit dependent of the input bytes. A N-length sequence 
	of 0x00 will be shorter than a N-length sequence of 0xff 
	(where N is a sufficiently large number).
 */
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;

public class Base91 {
	
    private static char[] cArr= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&()*+,./:;<=>?@[]^_`{|}~\"".toCharArray();

    private static	int nineOne= 91, // Why 91? Because 90×90 < 213(=8192) < 91×91 (=8281)
                        i0=  0,
                        i1=  0,		 
                        len= 0,		 
                        val= 0;		 
    // bs- backward string builder; ans will contain our result 
    private static StringBuilder bs, ans;

    // decode hashmap stores our values for O(1) lookup
    private static Map<Character, Integer> deHM = new HashMap<>();
	
    public static String encode(String data) {
        //System.out.println("\nText: "+ data);
        if(data.length() == 0|| data.equals(null)) return "";

        bs = new StringBuilder();
        ans = new StringBuilder();

        // reverse the data chars so when the binary numbers are generated,
        // the first char is the rightmost eg test
        // "tset"    1110100 01110011 01100101 01110100
        // therefore, the design is to work from right to left
        // this was pointed out in discussion!

        for(int i= data.length()-1; i>= 0; i--) {
            bs.append(data.charAt(i));
        }

        // convert the SB to a string, get the bits for the entire string,
        // store it in a big int in binary form, and then back to a string.
        // why?  preserve our data - straight from javadoc
        //Note that this conversion can lose information about the overall 
        //magnitude of the BigInteger value as well as return a result with the opposite sign.

        String binary= new BigInteger( bs.toString().getBytes() ).toString(2),
               rightToLeft;// store 13(14) bits at a time

        //System.out.println(binary.length()%13);

        //easier to track instead of actually shifting
        len= binary.length();
        BigInteger bi;

        while(len > 12) {
            rightToLeft= binary.substring(len-13, len);
            bi = new BigInteger(rightToLeft, 2); 
            // definitely see above!
            if(bi.intValue() <= 88) 
                bi= bi.and(new BigInteger("16383"));

            val= bi.intValue();
            i0= val%nineOne;  // binary and
            i1= val/nineOne;  // binary shift
            ans.append(cArr[i0]).append(cArr[i1]);
            len-=13;
        }
        //less then 13 bits AND the most challenging portion
        if(len==0) 
            ans.append(cArr[0]);// 0%91=0
        else {
            rightToLeft= binary.substring(0, len);
            //System.out.println("rtl: "+ rightToLeft);

            //binary number constructor
            bi = new BigInteger( rightToLeft, 2 );
            //System.out.println("bi: "+ bi.toString());

            //this will insure the left most bits are valid
            bi= bi.and(new BigInteger("8191"));
            val=  bi.intValue();
            //System.out.println("val: "+ val);

            i0= val%nineOne;// binary and
            ans.append(cArr[i0]);
            //System.out.println("i0 index "+i0);

            i1= val/nineOne;// binary shift
            //System.out.println("i1 index "+i1);

            // https://www.reddit.com/r/learnprogramming/comments/8sbb3v/understanding_base91_encoding/
            if(len > 7 || val > 90)// avoids value (8280), both i0 and i1 become 90
            ans.append(cArr[i1]);

            //????? for some reason 12 bit have a 0 remainder, resulting in an 'A' appended
            // if someone knows why, please message me. oddly, it was only the 12 bit tests...sigh
            if(len==12) ans.append(cArr[0]);
        }
        return ans.toString(); // do it!
    }

	
    public static String decode(String data) { 
        if(data.length() == 0|| data.equals(null)) return "";

        bs= new StringBuilder();
        ans= new StringBuilder();

        len= data.length();

        // assist with keeping the order while working from the right to left
        // will keep the array size proportional to the number of bits
        int oddEven = (data.length()%2 == 0) ? 0 : 1;
        
        String[] sArr = new String[(data.length()/2)+oddEven];
        // load the data for faster retrieval
        for(int i=0; i< cArr.length; i++)  deHM.put(cArr[i],i);

        char mod, 
             div; 

        int i= 0; // i and k will be used after the loop completes
        int k=sArr.length-1; // storing values from the right to the left 
        for( ; i< len-1; i+=2, k--) {
            mod= data.charAt(i); // first two digits
            div= data.charAt(i+1);// right half of the number

            val= deHM.get(mod) + deHM.get(div)*91; // get the pre binary number
            // convert the value to a binary string, stored in big int into 13 bit section
            sArr[k] = String.format("%013d", new BigInteger( Integer.toBinaryString(val) ) );
        }
        // a partial value remains
        if(len%2 != 0) {
            // byte = 8 bits - 13 bits* 4 bits(2 digit)
            int padZero = (i*8-(13*i/2));
            // also, the last char is 14bits long
            char c = data.charAt(len-1);

            val= deHM.get(c);
            // all the array elements are the same length except for the last one, index 0
            sArr[0]= String.format("%0"+ padZero+"d", new BigInteger( Integer.toBinaryString(val) ) );
        }
        for(String str: sArr) ans.append(str);

        // prep for return
        String s= new String(new BigInteger(ans.toString(), 2).toByteArray());
        // reverse the string
        for(int m= s.length()-1; m>= 0; m--) 
            bs.append(s.charAt(m));

        return bs.toString();
    }
}
