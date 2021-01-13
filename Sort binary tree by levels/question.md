### Sort binary tree by levels

<p> You are given a binary tree:

<pre>
 public class Node {
   public Node left;
   public Node right;
   public int value;

   public Node(Node l, Node r, int v) {
     left = l;
     right = r;
     value = v;
   }
 }
</pre>

<p> Your task is to return the list with elements from tree sorted by levels, which means the root element goes first, then root children (from left to right) are second and third, and so on.

<p> Return empty list is root is 'null'.

<p> Example 1 - following tree:

<pre>
                 2
            8        9
          1   3    4   5
</pre>

<p> Should return following list: [2,8,9,1,3,4,5]

<p> Example 2 - following tree:

<pre>
                 1
            8        4
              3        5
                         7
</pre>

<p> Should return following list: [1,8,4,3,5,7]

#### Algorithms, Trees, Data Structures, Binary Search Trees, Binary, Performance
