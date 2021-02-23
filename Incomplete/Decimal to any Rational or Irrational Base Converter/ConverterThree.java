
//AUTHOR: john_connor

public class ConverterThree {

	    private static final String DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    public static String converter(double x, int decimals, double base) {
	        StringBuilder result = new StringBuilder();
	        if (x < 0) {
	            x = -x;
	            result.append('-');
	        }
	        int n = decimals + 1;
	        while (x >= base) {
	            n++;
	            x /= base;
	        }
	        do {
	            int d = (int)x;
	            result.append(DIGITS.charAt(d));
	            x = (x - d) * base;
	            if (--n == decimals && decimals > 0)
	                result.append('.');
	        } while (n > 0);
	        return result.toString();
	    }

	public static void main(String[] args) {
		System.out.println(ConverterTwo.converter(13, 0, Math.PI));
//		103
		
		System.out.println(ConverterTwo.converter(17, 0, 2.5));
//		212
		
		System.out.println(ConverterTwo.converter(123456789, 0, 16));
//		75BCD15

	}

}
