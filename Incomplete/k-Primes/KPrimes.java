
//https://www.geeksforgeeks.org/k-primes-numbers-k-prime-factors-range/
//https://www.geeksforgeeks.org/sieve-of-eratosthenes/
//https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Algorithm_and_variants

import java.util.Arrays;
public class KPrimes {
    
    public static long[] countKprimes(int k, long start, long end) {
      System.out.println(end);
      
      boolean[] prime= new boolean[(int)end];
      int[] countK = new int[(int)end+1];
      Arrays.fill(countK, 0);
      
//       for(int num= 2; num * num <= (int)end; num++){
//          // If true then num is a prime
//          if( prime[num] == true ){
//             // Update all num multiples
//             for(int i= num*2; i<= (int)end; i+= num)
//                 prime[i] = false;
//           }
//       }
      
//       start= 14; end=18; k=2
//       // sum prime factors of all numbers up to B
//       for(int num= 2; num<= (int)end; num++)  
//             if( countK[num] == 0 )  
//                 for(int i = num; i <= (int)end; i += num)  
//                     countK[i]++; 
      
//       for(int i= (int)start; i<= (int)end; i++)
//           if( countK[i] == k )
//               System.out.print( i + " "); 
      
         
    
         System.out.print("k = " + k + ":");
 
         for (int i = (int)start, c = 0; i < (int)end; i++) {
            if (kprime(i, k)) {
               System.out.print(" " + i);
               c++;
            }
         }
 
             return new long[]{};
     
      
   }
 
   public static boolean kprime(int n, int k) {
      int f = 0;
      for (int p = 2; f < k && p * p <= n; p++) {
         while (n % p == 0) {
            n /= p;
            f++;
         }
      }
     f= f + ((n > 1) ? 1 : 0) == k;
      return f;
   }
  
    public static int puzzle(int s) { 
      return -1;
    }

}
