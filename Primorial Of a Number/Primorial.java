import java.math.BigInteger;

public class Primorial {
    public static String numPrimorial(int n) {
        if(n== 1) return "2";
     
        boolean tf= true;// indicates if num is prime number
        int num= 3;// current number 
        BigInteger ooze= new BigInteger("2");// https://www.tutorialspoint.com/java/math/java_math_biginteger.htm
        
        // https://www.geeksforgeeks.org/java-program-for-sieve-of-eratosthenes/
        while(n-1> 0){ // number of primorials 
            for(int p= 2; p<num; p++){
                if(num % p == 0)
                    tf= false; // not prime
            }
            if(tf){ // prime number found
                ooze= ooze.multiply(BigInteger.valueOf(num));
                n--; 
            }
            num++; // continue the search for prime number
            tf= true;
        }
        return ooze.toString();
    }
}
