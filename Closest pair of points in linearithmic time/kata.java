import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// excellent review and expansive from th ebrute force method! Google a pdf - CMSC 451: Closest Pair of Points 
// this performs at O(nlogn^2), java's collection sort function is merge sort
// https://stackoverflow.com/questions/15154158/why-collections-sort-uses-merge-sort-instead-of-quicksort

public class Kata {
  
    // Pair class linked the coordinates with the distance, 
  	public static class Pair{
      	public Point firstPoint= null;
      	public Point secondPoint= null;
      	public double distance= 0.0;
      	
      	public Pair(Point firstPoint, Point secondPoint, double distance) {
      		  this.firstPoint= firstPoint;
      		  this.secondPoint= secondPoint;
      		  this.distance= distance;
      	}
      	
      	public List<Point> asList() {
      		  return Arrays.asList(new Point[] {firstPoint, secondPoint});	
      	}
    }

  	// determines the distance between all points in the delta strip
  	private static Pair bfStrip(List<Point> lp, double delta) {
  		  double dMinStrip= Double.MAX_VALUE,
  				 dist;
  		  Point[] pArr= new Point[2];
  	    
    	  for(int i=0; i< lp.size()-1; i++){
    		// lp.get(k).y - lp.get(i).y < delta reduces the comparisons significantly!!!!
            for(int k= i+1; k< lp.size() && lp.get(k).y - lp.get(i).y < delta; k++) {
            	dist= distance(lp.get(i), lp.get(k));
            	if(dist < dMinStrip) {
            		dMinStrip = distance(lp.get(i), lp.get(k) );
            		pArr[0]= lp.get(i);
            		pArr[1]= lp.get(k);
    	        	  }
    	        }
    	  }
  	    return new Pair(pArr[0], pArr[1], dMinStrip);
  	}
  	
    // good old fashioned math 
  	private static double distance(Point pA, Point pB) {
  		  return Math.sqrt( Math.pow((pA.x - pB.x),2) + Math.pow((pA.y - pB.y),2) );
  		  //return Math.hypot((pA.x - pB.x), (pA.y - pB.y)); 
  	}
  	
    //sort points list by their x-coordinate
  	private static void xSort(List<Point> points) {
  			Collections.sort(points, new Comparator<Point>() {
  				@Override
  				public int compare(Point obj1, Point obj2) {
  					return  Double.compare(obj1.x, obj2.x);
  				}
  			});
  			//System.out.println("sorted by x: "+ points);
  	}
  	
    //sort points by their y-coordinate
  	private static void ySort(List<Point> points) {
			Collections.sort(points, new Comparator<Point>() {
				@Override
				public int compare(Point obj1, Point obj2) {
					  return  Double.compare(obj1.y, obj2.y);
				}
			});
			//System.out.println("sorted by y: "+ points);
  	}
  	
  	public static Pair cpHelper(List<Point> points) {
    		int numPoints = points.size();
    		Pair d1, 		// left half of the points
             	 d2, 	 	// right half of the points	
             	 deltaPair; // contains the coordinates from either the left or 
    						// right half with the smallest distance
    		double delta; 	// distance used to determine the strip from deltaPair
    		
    		if(numPoints == 1) { 
    			  // one point represents the same point as a pair, 
    			  // and the infinity distance guarantees a single point is a pair
    			  return new Pair( points.get(0), points.get(0), Double.POSITIVE_INFINITY );
    		}else if(numPoints == 2) {
    			  // base case! 
    			  return new Pair( points.get(0), points.get(1), distance(points.get(0),points.get(1)));	 
    		}else {
      			xSort(points);
      			// vertical line index to split into left and right half
      			int vl= numPoints/2;
      			// Divide
      			List<Point> left = points.subList(0, vl),
      						right = points.subList(vl, numPoints);
      			// System.out.println("left: "+ left+ "\nright: "+ right); 
      			// recursively find the distance for each side
      			d1= cpHelper(left);
      			d2= cpHelper(right);
      			// the shortest distanced from left and right half
      			// also, the coordinates are preserved so they can be compared to the strip's coordinates shortest distance
      			deltaPair= (d1.distance < d2.distance) ? d1 : d2;
      			//System.out.println("delta: "+ deltaPair.distance);
      			
      			// create a strip dMin distance from vertical line vl
      			delta= deltaPair.distance;
      			// stores the points within the strip, delta wide
      			List<Point> strip = new ArrayList<>();
      			for(Point p: points) {
      				if( Math.abs(p.x - points.get(vl).x) < delta) {
      					strip.add(p);
      				}
    			  }
    			
      			// sort strip by the y-coordinate, 
      			ySort(strip);
      			//System.out.println("strip ySort: "+ strip);
            
      			// find the closest distance in the delta strip
      			Pair stripPair= bfStrip(strip, delta);
       
      			// compare the left, right and strip pair
      		  return (stripPair.distance < deltaPair.distance) ? stripPair: deltaPair;
    		}
  	}	
    
    
    public static List<Point> closestPair(List<Point> points) {
        //System.out.println("points.size(): "+ points.size() );
        //System.out.println(points);
        //init check for only one point from the get go
        if(points.size() == 1) return points;
  		  return cpHelper(points).asList();
  	}
}
