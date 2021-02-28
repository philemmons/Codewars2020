### Next smaller number with the same digits

<p> Write a function that takes a positive integer and returns the next smaller positive integer containing the same digits.

<p> For example:
  
<pre>
nextSmaller(21) == 12
nextSmaller(531) == 513
nextSmaller(2071) == 2017
</pre>

<p> Return -1 (for Haskell: return Nothing, for Rust: return None), when there is no smaller number that contains the same digits. Also return -1 when the next smaller number with the same digits would require the leading digit to be zero.

<pre>
nextSmaller(9) == -1
nextSmaller(111) == -1
nextSmaller(135) == -1
nextSmaller(1027) == -1 // 0721 is out since we don't write numbers with leading zeros

    some tests will include very large numbers.
    test data only employs positive integers.
</pre>

<p> The function you write for this challenge is the inverse of this kata: "Next bigger number with the same digits."

#### Algorithms, Numbers, Strings, Integers, Mathematics
