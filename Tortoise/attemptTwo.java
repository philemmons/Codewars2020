
import java.math.*;

public class Tortoise {
    public static int[] race(int v1, int v2, int g) {
        //note: distance = rate*time
        // source: http://mathforum.org/dr.math/faq/faq.distance.html
        // solve for time!
        // v1*time + g = v2*time
        // g = v2*time - v1*time
        // g = time(v2-v1)
        // g/(v2-v1) = time
      
        // init check
        if( v1>v2 ) return null;
      
        int[] result = new int[3];
        double min, sec;
      
        // 1.0*g convets int to double expresssion
        double time = (1.0*g)/(v2-v1);
        System.out.println("time before: "+time);
        time = (double)Math.round(time * 100000d) / 100000d;
        System.out.println("time after: "+time);
        // convert decimal to h:m:s
        // source: https://www.calculatorsoup.com/calculators/time/decimal-to-time-calculator.php
        // cast to int will round down
      
        result[0]= (int)time;
      
        min = (time - (double)result[0])*60.0;
      
        result[1]= (int)(min);
      
        sec = (min - (double)result[1])*60.0;
      
        result[2]= (int)(sec);
      
        for(int a: result) System.out.println(a);
        System.out.println();
        return result;
    }
}
