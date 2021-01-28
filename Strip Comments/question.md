### Strip Comments

<p> Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any whitespace at the end of the line should also be stripped out.

<p> Example:

<p> Given an input string of:
<pre>
apples, pears # and bananas
grapes
bananas !apples
</pre>

<p> The output expected would be:
<pre>
apples, pears
grapes
bananas
</pre>

<p> The code would be called like so:

<pre>
var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
// result should == "apples, pears\ngrapes\nbananas"
</pre>

#### Algorithms, Strings
