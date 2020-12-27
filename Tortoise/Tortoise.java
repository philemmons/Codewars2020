public class Tortoise {
    public static int[] race(int v1, int v2, int g) {
        //note: distance = rate*time, solve for time!
        // v1*time + g = v2*time
        // g = v2*time - v1*time
        // g = time(v2-v1)
        // g/(v2-v1) = time

        if( v1>v2 ) return null;
      
        int[] result = new int[3];
        double time = (1.0*g)/(v2-v1);
        //System.out.println("deciaml hours: "+time);

        // using only INTEGERS
        // hours
        result[0]= (int)time;
        // minutes
        result[1]= (int)(time*60) %60;
        // seconds
        result[2]= (int)(time*3600) %60;
      
        //for(int a: result) System.out.println(a);
        //System.out.println();
        return result;
    }
}
