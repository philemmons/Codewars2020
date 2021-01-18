### Sum of Intervals

<p> Write a function called sumIntervals/sum_intervals() that accepts an array of intervals, and returns the sum of all the interval lengths. Overlapping intervals should only be counted once.

<p> Intervals

- Intervals are represented by a pair of integers in the form of an array. 
- The first value of the interval will always be less than the second value.
- Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.

<p> Overlapping Intervals

- List containing overlapping intervals:
<pre>
[
   [1,4],
   [7, 10],
   [3, 5]
]
</pre>

<p> The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5], which has a length of 4.

<p> Examples:

// null argument
- Interval.sumIntervals(null);  // => 0

// empty intervals
- Interval.sumIntervals(new int[][]{});  // => 0
- Interval.sumIntervals(new int[][]{2,2}, {5,5});  // => 0

// disjoined intervals
- Interval.sumIntervals(new int[][]{{1,2},{3,5}});  // => (2-1) + (5-3) = 3

// overlapping intervals
- Interval.sumIntervals(new int[][]{{1,4},{3,6},{2,8}});  // [1,8] => 7

#### Algorithms, Aggregations, Arithmetic, Mathematics, Numbers, Integers
