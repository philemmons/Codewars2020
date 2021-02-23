// Author: jberg

public class ConverterTwo {

	private static final String DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String converter(double n, int decimals, double base) {
	    if (n == 0) return "0";

	    boolean isNeg = n < 0;
	    n = Math.abs(n);

	    StringBuilder sb = new StringBuilder();
	    for (int exponent = (int) (Math.log(n) / Math.log(base)); exponent > -decimals - 1; exponent--) {
	        if (exponent == -1) {
	            sb.append(".");
	        }
	        sb.append(DIGITS.charAt((int) (n / Math.pow(base, exponent))));
	        //n %= Math.pow(base, exponent);
		n -= digit * Math.pow(base, exponent);    
	    }
	    return (isNeg ? "-" : "") + sb.toString();
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
