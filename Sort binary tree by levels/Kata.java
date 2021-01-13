import java.util.*;

class Kata {

  public static List<Integer> treeByLevels(Node node){
   
    Queue<Node>  q = new LinkedList<>();
    List<Integer> al = new ArrayList<>();
    if(node== null) return al; 
    
    //Algorithm: BFS - For each node, first the node is visited and then it’s child nodes are put in a FIFO queue. 
      Node root = node,
           tempNode;
    
      q.add(root); 
      while(!q.isEmpty()){
          tempNode = q.poll();
          al.add(tempNode.value);
          if(tempNode.left != null)
              q.add(tempNode.left);
          
          if(tempNode.right != null)
              q.add(tempNode.right);
      }
    return al;
  }
}
