
import java.lang.Math;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

//********* the expected and but was are reversed! 

public class Converter {
	
	// Weird Number Bases
	// https://datagenetics.com/blog/december22015/index.html
	
	//Numbers in Different Bases
	//http://www.cs.appstate.edu/~dap/classes/1100/sect1_1.html
	
	//Representing number in non integer base  
	//https://mathhelpforum.com/threads/representing-number-in-non-integer-base.235730/
	
	private static String digit= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private static BigDecimal biBeta, biN, biBase, ip, fp;
	
	private static Map<Character, Integer> repeating = new HashMap<>();
	
	
	public static void integerPart(BigDecimal biN, BigDecimal biBase, StringBuilder ipSB) {
		
		while(biN.intValue() != 0) {
			
	    	biBeta= biN.divide(biBase, MathContext.DECIMAL64);
	    	
	    	//if( biBeta.compareTo(biBase) > 1  )
	    	//	biBeta= new BigDecimal(biBase.intValue());
	    	
	    	ipSB.append(digit.charAt(biN.remainder(biBase).intValue() ) );
	    	biN= biBeta;
	    }
	}

	public static void fractionalPart(BigDecimal biN, BigDecimal biBase, StringBuilder fpSB) {
		if(ip.doubleValue() == 0) fpSB.append("0");
		fpSB.append(".");
		
		//boolean stop = false;
		char c;
		while( biN.doubleValue() !=0 ) {
			
	    	biBeta= biN.multiply(biBase, MathContext.DECIMAL64);
	    	//System.out.println(biBeta.toString());
	    	c= digit.charAt(biBeta.intValue() );
	    	fpSB.append(c);
	    	
	    	//in progress - track repeating series or use B/beta-1 for the number of NNReal digits
	    	if( !repeating.containsKey(c) ){
	    		repeating.put(c, 1);
	    	}else {
	    		repeating.put(c, repeating.get(c) +1);
	    	}
	    	
	    	System.out.println(biBeta.intValue());
	    	
	    	biN= biBeta.subtract(new BigDecimal(biBeta.intValue()));
	    	//System.out.println(biN.toString());
		}
	}
	
	public static void fractionBase(BigDecimal biN, BigDecimal biBase, StringBuilder fbSB) {
		
		while(biN.intValue() != 0) {
			
	    	biBeta= biN.divide(biBase, MathContext.DECIMAL64);
	    	
	    	//if( biBeta.compareTo(biBase) == 1  )
	    	//	biBeta= biBase;
	    	
	    	 System.out.println(biN+ "  "+ biBase+ "  "+ biBeta);
	    	 
	    	 System.out.println(biN.remainder(biBase).intValue());
	    	 
	    	fbSB.append(digit.charAt(biN.remainder(biBase).intValue() ) );
	    	
	    	biN= new BigDecimal(biBeta.intValue());
	    	System.out.println("biN: "+ biN);
	    }
	}
	
	public static String converter(double n, int decimals, double base) {
	    System.out.println("\nnum: "+ n+ "\ndec: "+ decimals+ "\nbase: "+ base);
	 
	    boolean neg = false;
	    if(n<0) {
	    	neg= true;
	    	n=Math.abs(n);
	    }
	    
	    biN = new BigDecimal(n);
	    
	    System.out.println(biN);
	    biBase= new BigDecimal(base);
	    
	    ip= new BigDecimal(biN.intValue(),MathContext.DECIMAL64);
	    System.out.println("ip: "+ ip.toString()); 
	    
	    
	    fp= new BigDecimal(biN.subtract(ip).doubleValue(),MathContext.DECIMAL64);
	    
	    System.out.println("fp: "+ fp.toString());
	    
	    
	    //System.out.println(biN.divide(biBase,RoundingMode.DOWN));
	    
	    StringBuilder ipSB= new StringBuilder(),
	    			  fpSB= new StringBuilder(),
	    			  fbSB= new StringBuilder();
	    
	    if(biBase.doubleValue()/biBase.intValue() != 1)
	    	fractionBase(ip, biBase, fbSB);
	    
//	    if(ip.doubleValue() > 0)
//	    	integerPart(ip, biBase, ipSB);
//	    
//	    if(fp.doubleValue() > 0)
//	    	fractionalPart(fp, biBase, fpSB);
//
//	    
//	    if(neg)ipSB.append("-"); 
//	    
//	    return ipSB.reverse().append(fpSB).toString();
	    return fbSB.reverse().toString();
	 }

	public static void main(String[] args) {
		System.out.println(Converter.converter(13, 0, Math.PI));
//		103
		
		System.out.println(Converter.converter(17, 0, 2.5));
//		212
		
//		System.out.println(Converter.converter(13, 0, 2));
//		1101
		
//		System.out.println(Converter.converter(-13, 0, 2));
//		-1101
		
//		System.out.println(Converter.converter(123456789, 0, 16));
//		75BCD15
		
//		System.out.println(Converter.converter(0.375, 0, 2));
//		75BCD15

	}

}
