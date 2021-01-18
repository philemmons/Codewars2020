package cw;
//Note - others used a set collection, although the same O(n^2)
//excellent idea!! unique numbers, and get the size of the set!!!

public class Interval {

  public static int difference(int small, int large) {
    return Math.abs(large - small);
  }
  
    public static int sumIntervals(int[][] intervals) {
        if(intervals== null || intervals.length== 0) return 0;
             
        int a, b, x, y, ans= 0;
        
//         System.out.println("intervals.length: "+ intervals.length);
//         for(int i= 0; i< intervals.length; i++){       
//            System.out.print(intervals[i][0]+ "\t"+ intervals[i][1]);
//            System.out.println();
//         }
        
        for(int i= 0; i< intervals.length; i++) {
          a= intervals[i][0];
          b= intervals[i][1];
          for( int k= i+1; k< intervals.length; k++) {
            x= intervals[k][0];
            y= intervals[k][1];
            if(a<=x && a<=y &&      // a----------b
               b>=x && b>=y){       //    x----y  
              intervals[i][0]= 0; intervals[i][1]= 0;
              intervals[k][0]= a; intervals[k][1]= b;
            }else if(a>=x && a<=y &&  //     a-------b
                     b>=x && b>=y){   // x-------y   
              intervals[i][0]= 0; intervals[i][1]= 0;
              intervals[k][0]= x; intervals[k][1]= b;
            }else if(a<=x && a<=y &&  // a-------b
                     b>=x && b<=y){   //     x-------y
              intervals[i][1]= 0; intervals[i][0]= 0;
              intervals[k][0]= a; intervals[k][1]= y;
            }else if(a>=x && a<=y &&  //    a----b
                     b>=x && b<=y){   // x----------y 
              intervals[i][0]= 0; intervals[i][1]= 0;
              intervals[k][0]= x; intervals[k][1]= y;
            }
          }
          ans+= difference(intervals[i][0],intervals[i][1]);
        }
        return ans;
    }
}
