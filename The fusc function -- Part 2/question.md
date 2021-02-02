### The fusc function -- Part 2

<p> This Kata is a continuation of Part 1. The fusc function is defined recursively as follows:
<pre>
fusc(0) = 0
fusc(1) = 1
fusc(2n) = fusc(n)
fusc(2n + 1) = fusc(n) + fusc(n + 1)
</pre>

<p> Your job is to produce the code for the fusc function. In this kata, your function will be tested with large values of n more than 1000 bits (in JS and PHP: at most 52 bits), so you should be concerned about stack overflow and timeouts.

<p> Method suggestion:

<p> Imagine that instead of fusc(n), you were to implement fib(n), which returns the n'th Fibonacci number.

<p> (Thank you 'dan_murder_64' for clarification)

<p> The function is recursively defined by:

<pre>
0.    fib(0) = 0
1.    fib(1) = 1
2.    fib(2) = 1
3.    fib(n + 2) = fib(n) + fib(n + 1), if n + 2 > 1 
</pre>

<p> If one translates the above definition directly into a recursive function, the result is not very efficient. One can try memoization, but that requires lots of space and is not necessary. So, first step is to try and find a tail recursive definition. In order to do that we try to write both sides of equation 3) on the same form. Currently, the left side of the equation contains a single term, whereas the right side is the sum of two terms. A first attempt is to add fib(n + 1) to both sides of the equation:

<pre>
3a.    fib(n + 1) + fib(n + 2) = fib(n) + 2 * fib(n + 1)
</pre>

<p> The two sides of the equation look much more alike, but there is still an essential difference, which is the coefficient of the second term of each side. On the left side of the equation, it is 1 and, on the right, it is 2. To remedy this, we can introduce a variable b:

<pre>
3b.     b * fib(n + 1) + b * fib(n + 2) = b * fib(n) + (b + b) * fib(n + 1)
</pre>

<p> We then subtract both sides by b * fib(n+1)

<pre>
3c.     b * fib(n + 2) = b * fib(n) + b * fib(n + 1)
</pre>

<p> To try and return the tail to the function we add both sides by a * fib(n+1) to each side:

<pre>
3d.     a * fib(n + 1) + b * fib(n + 2) = b * fib(n) + (a + b) * fib(n + 1)
</pre>

<p> Now the two sides have the same form (call it F), this function has the form:

<pre>
3e.     F(c, d, e) = F(a, b, n+1) = F(a, a+b, n) = c * fib(e) + d * fib(e + 1)
</pre>

<p> (Note if your confused by the above equation substitute the values into the furthest right function and you get)

<pre>
3f.     a * fib(n + 1) + b * fib(n + 2) = b * fib(n) + (a + b) * fib(n + 1) = c * fib(n) + d * fib(n + 1)
</pre>

<p> Which we can simplify to:

<pre>
3g.     F(a, b, n + 1) = F(b, a + b, n)
</pre>

<p> We also have, by definition of F and fib:

<pre>
4.     F(a, b, 0) = a * fib(0) + b * fib(1) = b

    (Proove this with general equation)
    F(a, b, n + 1) with n = 0
    c * fib(n) + d * fib(n + 1)
    a * fib(0) + b * fib(0 + 1) as fib(0) = 0, fib(1) = 1
    b
</pre>

<p> Also, by definition of F:

<pre>
5.     fib(n) = F(1, 0, n) with a = 1, b = 0

    (Proove this with general equation)
    c * fib(e) + d * fib(e + 1)
    1 * fib(n) + 0 * fib(n + 1)
    1 * fib(n)

6.     F(a, b, 1) = a * fib(1) + b * fib(2) = a + b

    (Proove this with general equation)
    F(a, b, n + 1) with n = 1
    c * fib(n) + d * fib(n + 1)
    a * fib(1) + b * fib(1 + 1) as fib(1) = fib(2) = 1
    a + b
</pre>

<p> The next step is to translate the above into code:

<pre>
def fib(n):
    if n == 0: return 0    # see 6. above
    def F(a, b, n):
        if n == 1: return a + b    # see 6. above
        return F(b, a + b, n - 1)  # see 3g. above (F(a, b, n + 1) = F(b, a + b, n)) use n = n - 1
    return F(1, 0, n)              # see 5. above
</pre>

<p> The final step (optional for languages that support tail call optimization) is to replace the tail recursive function F with a loop:

<pre>
def fib(n):
    if n == 0: return 0            # see 4. above
    a, b = 1, 0                    # see 5. above
    while n > 1:    
        a, b, n = b, a + b, n - 1  # see 3g. above
    # n = 1 at this point
    return a + b<>                   # see 6. above 
</pre>

<p> Voila! Now, go do the same with fusc.

#### Algorithms
