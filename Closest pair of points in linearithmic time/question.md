### Closest pair of points in linearithmic time

<p> Given a number of points on a plane, your task is to find two points with the smallest distance between them in linearithmic O(n log n) time.

<p> Example
<pre>
  1  2  3  4  5  6  7  8  9
1  
2    . A
3                . D
4                   . F       
5             . C
6              
7                . E
8    . B
9                   . G
</pre>

<p> For the plane above, the input will be:
<pre>
[
  [2,2], // A
  [2,8], // B
  [5,5], // C
  [6,3], // D
  [6,7], // E
  [7,4], // F
  [7,9]  // G
]
=> closest pair is: [[6,3],[7,4]] or [[7,4],[6,3]]
(both answers are valid)
</pre>

<p> The two points that are closest to each other are D and F.

<p> Expected answer should be an array with both points in any order.

<p> Goal

- The goal is to come up with a function that can find two closest points for any arbitrary array of points, in a linearithmic time.

<p> Point class is preloaded for you as:
<pre>
public class Point {
    public double x, y;

    public Point() {
        x = y = 0.0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", x, y);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(x) ^ Double.hashCode(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point other = (Point) obj;
            return x == other.x && y == other.y;
        } else {
            return false;
        }
    }
}
</pre>

<p> More information on wikipedia. https://en.wikipedia.org/wiki/Closest_pair_of_points_problem


#### Algorithms
