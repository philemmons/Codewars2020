package binary.multiple.of.three;

import java.util.regex.Pattern;

public class BinaryRegexp {
	

	
	public static Pattern multipleOf3() {
	    // Regular expression that matches binary inputs that are multiple of 3
		//source: https://stackoverflow.com/questions/39385971/how-to-know-if-a-binary-number-divides-by-3
		/*
		 * Basically count the number of non-zero odd positions bits and 
		 * non-zero even position bits from the right. If their difference 
		 * is divisible by 3, then the number is divisible by 3.
		 * For example:
		 * 15 = 1111 which has 2 odd and 2 even non-zero bits. 
		 * The difference is 0. Thus 15 is divisible by 3.
		 * 
		 * 	^          # match beginning of string
			0*         # match zero or more '0'
			(          # start group 1
 			 10*       # match '1' followed by zero or more '0'
 			 10*       # match '1' followed by zero or more '0'
			)*         # end group 1 - match zero or more times
			$          # end of string
			
			source: https://stackoverflow.com/questions/2703316/regular-expression-for-bit-strings-with-even-number-of-1s
		 */
	    //return Pattern.compile("\\b^0*(10*10*)*$\\b");
		 return Pattern.compile("(0|1(01*0)*1)*");
		 //author - Frederikbh, ecolban, Robin479, coolzxbin, ImayaDismas, nibbler13, jamethy, sjinfosys, Prashant1061992, zwq_code (plus 82 more warriors)
	}
	public static void main(String[] args) {
		System.out.println(BinaryRegexp.multipleOf3().matcher(" 0").matches());
//	    assertEquals(false, BinaryRegexp.multipleOf3().matcher(" 0").matches());
		
		System.out.println(BinaryRegexp.multipleOf3().matcher("abc").matches());
//	    assertEquals(false, BinaryRegexp.multipleOf3().matcher("").matches());
		
		System.out.println(BinaryRegexp.multipleOf3().matcher("000").matches());
//	    assertEquals(true, BinaryRegexp.multipleOf3().matcher("000").matches());
//
		System.out.println(BinaryRegexp.multipleOf3().matcher("110").matches());
//	    assertEquals(true, BinaryRegexp.multipleOf3().matcher("110").matches());
		
		System.out.println(BinaryRegexp.multipleOf3().matcher("111").matches());
//	    assertEquals(false, BinaryRegexp.multipleOf3().matcher("111").matches());
		
		System.out.println(BinaryRegexp.multipleOf3().matcher(Integer.toBinaryString(12345678)).matches());
//	    assertEquals(true, BinaryRegexp.multipleOf3().matcher(Integer.toBinaryString(12345678)).matches());

	}

}
