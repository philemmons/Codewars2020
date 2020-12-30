import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public int cutOffRank(int cutOffRank, int num, int[] scores) {
        if(cutOffRank== 0 ) return 0;
        
        Arrays.sort(scores);//ascending
        
        int[] rank = new int[num];
        int index= 1, up= 0;
        rank[num-1]= index;
        
        for(int i= num-2; i>-1 ; i--){
            index++;
            if(scores[i] == scores[i+1]){
                rank[i]= rank[i+1];
            }else{
                rank[i]= index;
            }
        }
        for(int i: rank){
            if(i<= cutOffRank)up++;
        }
        return up;
        //Note that players with equal scores will have equal ranks, 
        //but the player with the next lowest score will be ranked based on the position within the list of all players' scores. 
        //For example, if there are four players, and three players tie for first place, their ranks would be 1,1,1, and 4. 
        //Also, no player with a score of O can level up, no matter what their rank.
        
    }
}
