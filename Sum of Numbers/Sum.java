 public class Sum {
    
      public int GetSum(int a, int b){
        //Good luck!
         if(a == b) return a;
         
         if(a > b) 
           return sum( b, a );
         else
           return sum( a, b ); 
       }
  
      public int sum( int low, int high){
        int sum=0;
        for(int i = low; i<=high; i++ )
          sum+=i;
        return sum;
      }
  }
