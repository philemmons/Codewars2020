import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Bundesliga {
	
	private int rank= 0;
	private String name= "";
	private int played= 0,
              won= 0,
              tie= 0,
              lost= 0,
              shots= 0,
              gotten= 0,
              points= 0;

	public Bundesliga(int rank, String name, int played, int won, int tie, int lost, int shots, int gotten, int points) {
  		super();
  		this.rank = rank;
  		this.name = name;
  		this.played = played;
  		this.won = won;
  		this.tie = tie;
  		this.lost = lost;
  		this.shots = shots;
  		this.gotten = gotten;
  		this.points = points;
	}
	
	//Table placed with two chars and a dot (" 1.", "12.")
	@Override
	public String toString() {
		  return (String.format("%2d", rank)  + ". " + String.format("%1$-" + 30 + "s", name) + played + "  " + won + "  " + tie + "  " + lost + "  " + shots + ":" + gotten + "  " + points);
	}
	//Based on shots:gotten
	private int getRank() {
		  return rank;
	}
	private void setRank(int rank) {
		  this.rank = rank;
	}
	
	// Name of the team/club padded right up to 30 chars (filled up with spaces).
	protected String getName() {
		  return name;
	}
	protected void setName(String name) {
		  this.name = String.format("%1$" + 30 + "s", name);
	}

	// Differences of goals (shot vs. gotten)
	protected int getShots() {
		  return shots;
	}
	protected void setShots(int shots) {
		  this.shots = shots;
	}
	protected int getGotten() {
		  return gotten;
	}
	protected void setGotten(int gotten) {
		  this.gotten = gotten;
	}

	// Count of points
	private int getPoints() {
		  return points;
	}
  //--end of Bundesliga 
  
  public static void setup(String game, String[] teamName, int[] score, LinkedList<Bundesliga> buLL){
  			
  			teamName[0] = game.substring(4,game.indexOf(" - "));
  			teamName[1]= game.substring(game.indexOf(" - ")+3, game.length() );
  			
  			String score1 = game.substring(0,1), score2 = game.substring(2,3);
  			
  			if(score1.equals("-")) {
    				buLL.add(new Bundesliga(1, teamName[0], 0, 0, 0, 0, 0, 0, 0) );
    				buLL.add(new Bundesliga(1, teamName[1], 0, 0, 0, 0, 0, 0, 0) );
  			}else {
    				score[0] = Integer.valueOf(score1);
    				score[1] = Integer.valueOf(score2);
    
    				if(score[0]>score[1]) {//left team won
      					buLL.add(new Bundesliga(1, teamName[0], 1, 1, 0, 0, score[0], score[1], 3) );
      					buLL.add(new Bundesliga(1, teamName[1], 1, 0, 0, 1, score[1], score[0], 0) );
    				}else if(score[0] == score[1]) {//tie 
      					buLL.add(new Bundesliga(1, teamName[0], 1, 0, 1, 0, score[0], score[1], 1) );
      					buLL.add(new Bundesliga(1, teamName[1], 1, 0, 1, 0, score[1], score[0], 1) );
    				}else {//right team won
      					buLL.add(new Bundesliga(1, teamName[0], 1, 0, 0, 1, score[0], score[1], 0) );
      					buLL.add(new Bundesliga(1, teamName[1], 1, 1, 0, 0, score[1], score[0], 3) );
    				}
  			}
  			Arrays.fill(score, 0);//reset score for next match	
  }
  
  public static void sortBlock(LinkedList<Bundesliga> buLL){
      //SORT BY
		  Collections.sort(buLL, new Comparator<Bundesliga>() {
          public int compare(Bundesliga o1, Bundesliga o2) {
        		  // 1. Points
            	int comp= Integer.compare( o2.getPoints(), o1.getPoints() );
            	// 2. If the points are the same: The difference of goals. (2:0 is better than 1:0)
            	if(comp == 0)
            		comp= Integer.compare(o2.getShots()-o2.getGotten(),o1.getShots()-o1.getGotten());
            	// 3. If the difference of goals is the same: More goals are better! (2:1 is better than 1:0)
            	if(comp == 0)
                	comp= Integer.compare(o2.getShots(), o1.getShots());
              // 4. Otherwise: The teams share the same place, but ordered by the name of the team (case-insensitive!)!
            	if(comp == 0 )
                	comp= comp= o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            	return comp;
            }
        });
  }
  
  public static void byRank(LinkedList<Bundesliga> buLL){
      //BY RANK - based on shots:gotten - overridde below
  		for(int i= 1; i< buLL.size(); i++) {
    			if(buLL.get(i).equals(buLL.get(i-1) ) ) {
    				buLL.get(i).setRank( buLL.get(i-1).getRank() );
    			}else {
    				buLL.get(i).setRank(i+1);
    			}
  		}
  }
  
  @Override 
	public boolean equals(Object obj) {
  		if (this == obj) {
  			return true;
  		}
  		if (obj == null) {
  			return false;
  		}
  		if (getClass() != obj.getClass()) {
  			return false;
  		}
  		Bundesliga other = (Bundesliga) obj;
  		if (gotten != other.gotten) {
  			return false;
  		}
  		if (shots != other.shots) {
  			return false;
  		}
  		return true;
	}

 //Bring it together
  public static String table(String[] results){
      //LL great for sorting obj and OOP
      LinkedList<Bundesliga> buLL = new LinkedList<>();
    
  		//These are used to transform the original string element into two Bundesliga objects.
  		String game;
  		String[] teamName = new String[2];
  		int[] score = new int[] {0,0};

      //setup and instantiate buLL
      for(int i= 0; i< results.length; i++) {
          game = results[i];
          setup(game, teamName, score, buLL);
      }
    
      //sort by block
      sortBlock(buLL);
    
      //set rank
      byRank(buLL);
    
      //Display
      //System.out.println(buLL.toString().replaceAll(", ", "\n").replace("[", "").replace("]", ""));
      return (buLL.toString().replaceAll(", ", "\n").replace("[", "").replace("]", ""));
  
  }
}
