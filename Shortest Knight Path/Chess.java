import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;


public class Chess {
  
  public static class Node {
    public List<Node> kids;
    public int childRow, childCol, level;// the child level increase is based on the parents level
    
    public Node( ArrayList<Node> al, int r, int c, int l ) {
        childRow= r;
        childCol= c;
        kids= al;
        level= l;// tracks the number of moves or the BFS depth
    }
    @Override
    public String toString() {
        return "\nNode [kids=" + kids + ", childRow=" + childRow + ", childCol=" + childCol + ", level=" + level + "]";
    }
  
    public int getLevel() {                  return level;              } 
    public void setLevel(int level) {        this.level = level;        }
  
    public List<Node> getKids() {            return kids;               }
    public void setKids(List<Node> kids) {   this.kids = kids;          }
  
    public int getChildRow() {               return childRow;           }
    public void setChildRow(int childRow) {  this.childRow = childRow;  }
  
    public int getChildCol() {               return childCol;           }
    public void setChildCol(int childCol) {  this.childCol = childCol;  }
  }
  
    public static int knight(String start, String  finish) {
        //System.out.println("start: "+ start+ " finish: "+ finish);
        if(start.equals(finish)) return 0;
        
        // The board is 8x8, mark array to avoid duplicate children
        boolean[][] visited = new boolean[8][8];
        // convert the chess notation to row,column, with zero, zero top left
        char[] stArr = start.toCharArray(),
               fnArr = finish.toCharArray();
        // Unicode character value
        int stRow= Character.getNumericValue(stArr[1])-1,     stCol= Character.getNumericValue(stArr[0])-10,
            fnRow= Character.getNumericValue(fnArr[1]) -1,    fnCol= Character.getNumericValue(fnArr[0])-10,
            r,// row 
            c;//column
          
        //System.out.println("start: "+ stRow+ ","+stCol+ " finish: "+ fnRow+ ","+ fnCol);
        // init starting position of knight
        Node root = new Node(new ArrayList<>(), stRow, stCol, 0);

        // standard data structure for BFS
        Queue<Node> q = new LinkedList<>();
        // universal placeholder for all the children during the queue
        Node tempNode;
        q.add(root);
  
        while( !q.isEmpty()) {
            tempNode= q.poll();
            r= tempNode.getChildRow();
            c= tempNode.getChildCol();
            
            //up right  -2,+1
            if( -1 < r-2  && r-2 < 8 &&  // check boundaries
                -1 < c+1  && c+1 < 8 &&
                visited[r-2][c+1] == false ) {  // is it a new square?
                if(r-2 == fnRow && c+1 == fnCol) return tempNode.getLevel()+1;  // is it the destination?
                visited[r-2][c+1]= true; // mark the square as it avoid loops
                tempNode.kids.add(new Node(new ArrayList<Node>(), r-2, c+1, tempNode.level+1));  // link the parent to the child node, square, and current level
            }
            //up left -2,-1
            if( -1 < r-2  && r-2 < 8 &&
                -1 < c-1  && c-1 < 8 &&
                visited[r-2][c-1] == false ) {
                if(r-2 == fnRow && c-1 == fnCol) return tempNode.getLevel()+1;
                visited[r-2][c-1]= true;
                tempNode.kids.add(new Node(new ArrayList<Node>(), r-2, c-1, tempNode.level+1));
              }
            //right up  -1,+2
            if( -1 < r-1  && r-1 < 8 &&
                -1 < c+2  && c+2 < 8 &&
                visited[r-1][c+2] == false ) {
                if(r-1 == fnRow && c+2 == fnCol) return tempNode.getLevel()+1;
                visited[r-1][c+2]= true;
                tempNode.kids.add(new Node(new ArrayList<Node>(), r-1, c+2, tempNode.level+1));
              }
            //right down +1,+2
            if( -1 < r+1  && r+1 < 8 &&
                -1 < c+2  && c+2 < 8 &&
                visited[r+1][c+2] == false ) {
                if(r+1 == fnRow && c+2 == fnCol) return tempNode.getLevel()+1;
                visited[r+1][c+2]= true;
                tempNode.kids.add(new Node(new ArrayList<Node>(), r+1, c+2, tempNode.level+1));
              }
            //down right +2,-1
            if( -1 < r+2  && r+2 < 8 &&
                -1 < c+1  && c+1 < 8 &&
                visited[r+2][c+1] == false ) {
                if(r+2 == fnRow && c+1 == fnCol) return tempNode.getLevel()+1;
                visited[r+2][c+1]= true;
                tempNode.kids.add(new Node(new ArrayList<Node>(), r+2, c+1, tempNode.level+1));
              }
            //down left +2,-1
            if( -1 < r+2  && r+2 < 8 &&
                -1 < c-1  && c-1 < 8 &&
                visited[r+2][c-1] == false ) {
                if(r+2 == fnRow && c-1 == fnCol) return tempNode.getLevel()+1;
                visited[r+2][c-1]= true;
                tempNode.kids.add(new Node(new ArrayList<Node>(), r+2, c-1, tempNode.level+1));
              }
            //left up -1,-2
            if( -1 < r+1  && r+1 < 8 &&
                -1 < c-2  && c-2 < 8 &&
                visited[r+1][c-2] == false ) {
                if(r+1 == fnRow && c-2 == fnCol) return tempNode.getLevel()+1;
                visited[r+1][c-2]= true;
                tempNode.kids.add(new Node(new ArrayList<Node>(), r+1, c-2, tempNode.level+1));
              }
            //left down +1,-2
            if( -1 < r-1  && r-1 < 8 &&
                -1 < c-2  && c-2 < 8 &&
                visited[r-1][c-2] == false ) {
                if(r-1 == fnRow && c-2 == fnCol) return tempNode.getLevel()+1;
                visited[r-1][c-2]= true;
                tempNode.kids.add(new Node(new ArrayList<Node>(), r-1, c-2, tempNode.level+1));
              }
            // adds all the children nodes to the queue, rinse, and repeat
            if(!tempNode.kids.isEmpty()) {
                q.addAll(tempNode.getKids());
                
            }
            //System.out.println(tempNode.getKids().size());
            //System.out.println(tempNode.getKids());
            //System.out.println();
         }
         return -1;//not found!!!
     }
}
