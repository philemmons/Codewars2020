import java.util.*;

public class Dinglemouse {
  
  public static class Floor {
  
    protected boolean call= false;
    protected List<Person> peeps;
    protected int story;
    protected Iterator<Person> itr;
  
    public Floor(boolean call, int story) {
      this.call= call;
      this.story= story;
      this.peeps = new LinkedList<>();
    }
  
    @Override
    public String toString() {
      return "Floor: " + story + ", call=" + call + ", peeps=" + peeps;
    }
  
    protected int getStory() {
      return story;
    }
    protected void setStory(int story) {
      this.story = story;
    }
 
    protected boolean getCall() {
      return call;
    }
    protected void setCall(boolean call) {
      this.call = call;
    }
    
    protected boolean containsDir(int dir) {
      itr= peeps.iterator();
      while(itr.hasNext()) {
        Integer d= itr.next().getDir();
        if(dir == d) return true;
      }
      return false;
    }
}

  
  public static class Person {
  
    protected int dest;
    protected int dir;
  
    public Person(int dest, int lvl) {
      super();
      this.dest= dest;
      this.dir= ( dest>lvl ) ? 1 : -1;
    }
  
    @Override
    public String toString() {
      return "" + dest;
    }
  
    protected int getDist() {
      return dest;
    }
    protected void setDist(int dest) {
      this.dest = dest;
    }
  
    protected int getDir() {
      return dir;
    }
    protected void setDir(int dir) {
      this.dir = dir;
    }
}
  
  public static void display(Floor[] fl) {
      for(int i= 0; i< fl.length; i++) {
         System.out.println(fl[i]);
      }
      System.out.println();
  }

  public static int[] theLift(final int[][] q, final int cap ){
        System.out.println("cap: "+ cap+ " q size: "+ q.length);

     
      int dir = 1, // 1=up, -1=down; 
        allPeeps = 0, // tracks all the people in the 'building'
        lvl= 0, // indicates the current floor
        currentWt = 0; // used to measure the ongoing weight
      
      boolean stopped, // indicates if the elevator stopped at a floor
          smartDir; // when the elevator becomes 'intelligent' LOL
      
      // easy to add ints(destination) to the elevator, in order
      List<Integer> elev = new LinkedList<>();
      // used to track if the up/down button was 'called'; all people on the floor are 'queue'; level variable
      Floor[] fl = new Floor[q.length];
      // even easier to convert to array? old school
      List<Integer> history = new ArrayList<>();// 
      
      Iterator<Integer> itr;// traverse the elevator when exiting
      Iterator<Person> itrPer;// traverse the people on the floor when entering the elevator
      
      //load them up!
      for(int i= 0; i< q.length; i++){
        //System.out.print("floor: "+ i+ "  ");
        fl[i]= new Floor(false,i);
        for(int k= 0; k< q[i].length; k++){
          //System.out.print(q[i][k]+ " ");
          if(q[i].length> 0) {//people are in the q
            fl[i].setCall(true);//button pushed
            fl[i].peeps.add(new Person(q[i][k], i));
            allPeeps++;// used to start and inform us the elevator 'ride' is over
          } 
          }
      }
      //starting position and no one in the Garage is waiting to get on the elevator
      if(q[0].length == 0)
        history.add(lvl);
      
      while(allPeeps !=0){
   
        stopped= false;// the elevator is in motion
        //people boarding the elevator at which floor
        if(elev.size()> 0){
          //https://stackoverflow.com/questions/1196586/calling-remove-in-foreach-loop-in-java
          // yes, drill the LL iterator into our minds!!
          itr = elev.iterator();
          while(itr.hasNext()) {
            Integer i = itr.next();
            if(i == lvl) {
              itr.remove();
              allPeeps--;
              currentWt--;
              stopped= true;
            }
          }
        }
        // change direction when at the top floor or the garage, AFTER they exit elevator
        if(lvl == q.length-1) 
          dir= -1;//down
        else if(lvl == 0)
          dir= 1;//up
        
        // ENTER the elevator, was the call button 'pushed'
        if(fl[lvl].getCall() ){
          //assume the elevator is always smart, 
          smartDir= true;
          //are people going the same directionont the current floor as the elevator
          if(fl[lvl].containsDir(dir)) {
          smartDir= false;
          stopped=true;
        }
          
          //this section implements when a change in direction occurs
          //also, very linear and hopefully easier to follow logic
          if(dir== 1) {
            //current to top floor
            for(int i= lvl+1; i< fl.length; i++ ){
              // if there are other calls, same direction, above the current floor
              // OR anyone on the floor going the same direction
              if(fl[i].getCall() || elev.contains(i)){
                smartDir= false;
                break;
              }
            }
            if(smartDir) 
              dir= -1;
          }else{
            //current to bottom floor
            for(int i= lvl-1; i>=0; i-- ){
              if(fl[i].getCall() || elev.contains(i)){
                smartDir= false;
                break;
              }
            }
            if(smartDir) 
              dir= 1;
          }
          // getting people on the elevator from the current floor, in order and directional 
          itrPer = fl[lvl].peeps.iterator();
          while(itrPer.hasNext()) {
            Person p= itrPer.next();
            if(currentWt < cap && p.getDir() == dir) {
              elev.add(p.getDist());
              currentWt++;
              stopped= true;
              itrPer.remove();
            }
          }
          // all people have left the floor
          if(fl[lvl].peeps.isEmpty()) fl[lvl].setCall(false);
        }
        // all stopped conditions add ONE floor level to final answer
        if(stopped) history.add(lvl);
        lvl+= dir;//moves elevator in the direction, smart or not             
      }
      //elevator returns to the garage if not already there 
      if(history.lastIndexOf(0) != history.size()-1)
       history.add(0);
     
      //System.out.println(history.toString()+ "\n");
      
      int[] ans= new int[history.size()];
      for(int i=0; i< ans.length; i++) {
        ans[i] = history.get(i);
      }
      
      return ans;
    }

}
