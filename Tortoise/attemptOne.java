public static int[] race(int v1, int v2, int g) {
        // Given two speeds v1 (A's speed, integer > 0) 
        // and v2 (B's speed, integer > 0) 
        // and a lead g (integer > 0) 
        // how long will it take B to catch A? 
      
        // v1 and v2 are feet per hour
        // g is in feet
      
        // init checks
        if( v1>v2 ) return null;
      
        // init vars
        int[] result = new int[3];
        int hour, min, sec;
        // 1 hour = 60 min = 3600 sec
        // 1 min = 60 sec
      
      BigDecimal bdV1 = new BigDecimal(v1);
      BigDecimal bdV2 = new BigDecimal(v2);
      System.out.println(bdV1 + " v1 - feet per hour - v2 " + bdV2);
      BigDecimal secPerHr = new BigDecimal(3600.0);
      System.out.println("secPerhr: " + secPerHr);
      
      BigDecimal distA = new BigDecimal(0);
      BigDecimal distB = new BigDecimal(0);
      
      bdV1 = bdV1.divide(secPerHr, 16, RoundingMode.HALF_UP);
      bdV2 = bdV2.divide(secPerHr, 16, RoundingMode.HALF_UP);
      System.out.println(bdV1 + " increments " + bdV2);
       // double fpsV1 = v1/3600.0,
         //      fpsV2 = v2/3600.0,
           //    distA = 0, 
             // distB = 0 ;
        //convert feet per hour to feet per sec
        int seconds= 0;
        //count the number of iterations
        distA = distA.add(new BigDecimal(g));
        System.out.println(distA + " starting points " + distB);
        
        //if both started at the same distance g=0
        while( distA.compareTo(distB) > -1 ){
          seconds++;
          distA = distA.add(bdV1);
          distB = distB.add(bdV2);
          //System.out.println(distA + " " + distB + " " + seconds);
          
        }
      System.out.println("bdV1: " + bdV1.multiply(new BigDecimal(seconds) ) );
      System.out.println("bdV2: " + bdV2.multiply(new BigDecimal(seconds) ) );
      System.out.println("seconds: " + seconds);
      
      
    result[0] = seconds/3600;
      System.out.println(seconds/3600);
      
    result[1] = (seconds/60) - ( (seconds/3600) *60);
      System.out.println((seconds/60) - (result[0]*60));
      
    result[2] = (seconds - result[0]*3600 - result[1]*60);
      System.out.println(seconds - result[0]*3600 - result[1]*60);
      
  //for(int a: result) System.out.println(a);
      
      // System.out.println(seconds/3600.0);
        // result will be an array [hour, min, sec] which is the time needed in hours, minutes and seconds
        
        // (round down to the nearest second) ...
        return result;
    }
