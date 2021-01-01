### The Supermarket Queue

<p> There is a queue for the self-checkout tills at the supermarket. Your task is write a function to calculate the total time required for all the customers to check out!

<p> input

-  customers: an array of positive integers representing the queue. Each integer represents a customer, and its value is the amount of time they require to check out.
-  n: a positive integer, the number of checkout tills.

<p> output

-    The function should return an integer, the total time required.

#### *** Important ***

<p> Please look at the examples and clarifications below, to ensure you understand the task correctly :)
Examples

> queueTime([5,3,4], 1)

<p> should return 12, because when there is 1 till, the total time is just the sum of the times

> queueTime([10,2,3,3], 2)

<p> should return 10, because here n=2 and the 2nd, 3rd, and 4th people in the queue finish before the 1st person has finished.

> queueTime([2,3,10], 2)
<p> should return 12

#### *** Clarifications ***

<p> There is only ONE queue serving many tills, and
<p> The order of the queue NEVER changes, and
<p> The front person in the queue (i.e. the first element in the array/list) proceeds to a till as soon as it becomes free.

<p> N.B. You should assume that all the test input will be valid, as specified above.

<p> P.S. The situation in this kata can be likened to the more-computer-science-related idea of a thread pool, with relation to running multiple processes at the same time: https://en.wikipedia.org/wiki/Thread_pool

#### Fundamentals, Arrays, Loops, Control Flow, Basic Language Features
