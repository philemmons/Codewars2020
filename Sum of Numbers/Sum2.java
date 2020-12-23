// Authors: Kowski, muirurikin
//O(1)!! Just Awesome

  public class Sum
  {
     public int GetSum(int smaller, int bigger)
     {
        if(bigger<smaller) {
          return GetSum(bigger,smaller);
        }
        else
        {
          /* use Euler's formula to sum up all numbers from 0 to bigger 
          /  and subtract the sum of numbers from 0 to smaller (exclusive)
          */
          return (bigger+smaller)*(bigger-smaller+1)/2;
        }
     }
  }
