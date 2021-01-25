import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Snail {

	public static void display(int array[][], int size) {
    	System.out.println("array.length: "+ size);
		for(int i= 0; i< size; i++) {
    		for(int k= 0; k< array[i].length; k++) {
    			System.out.print(array[i][k]+ " ");
    		}
    		System.out.println();
    	}
	}
	
	/* pattern 3x3				* add to row, col
	 * number of indexes			* right 0,+1
	 * 3 2 2 1 1 - increment		* down +1,0
	 * r d l u r - direction		* left  0,-1	
	 * 								* up   -1,0
	 */
	
    public static int[] snail(int[][] array) {
    	int size= array.length;
    	// init check empty arrays - note: an array  [[]] has a length of one!
    	if(array.length == 1 && array[0].length == 0) return new int[]{};
    	//display(array, size);
    	
    	int[] ans = new int[size*size];
    	
    	// indicate how many indexes to go in a specific direction
    	Queue<Integer> increment = new LinkedList<>();
    	
    	//add the number of indexes minus the starting position
    	increment.add(size-1);
    	for(int i= size-1; i> 0; i--) {
    		increment.add(i);
    		increment.add(i);
    	}

    	//for(Integer i: increment)System.out.print(i+ "  ");
    	//System.out.println();

    	int direction=0, // let us know when to change direction
    		val, 		 // increment value of the number of advances in the specific direction
    		row= 0, 	
    		col= 0, 
    		index= 1;
    	
    	// init starting position
    	ans[0]= array[0][0];
    	
    	while(!increment.isEmpty()) {
    		val= increment.poll();
    		
    		switch(direction % 4) {
				case 0:{//right
					for(int i=0; i<val;i++) {
						col++;
						ans[index++]= array[row][col];
					}
				}break;
				case 1:{//down
					for(int i=0; i<val;i++) {
						row++;
						ans[index++]= array[row][col];
					}
				}break;
				case 2:{//left
					for(int i=0; i<val;i++) {
						col--;
						ans[index++]= array[row][col];
					}
				}break;
				case 3:{//up
					for(int i=0; i<val;i++) {
						row--;
						ans[index++]= array[row][col];
					}
				}break;
				default:
					throw new IllegalArgumentException("Unexpected value");
			}
    		direction++;
    	}
	
    	return ans;
    } 
	

	public static void main(String[] args) {
        int[][] array
        = {{1, 2, 3},
           {4, 5, 6},
           {7, 8, 9}};
    //{1, 2, 3, 6, 9, 8, 7, 4, 5};
    System.out.println( Arrays.toString( snail(array) ) );
	}

}
