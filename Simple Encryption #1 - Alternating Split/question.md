### Simple Encryption #1 - Alternating Split

<p> For building the encrypted string: Take every 2nd char from the string, then the other chars, that are not every 2nd char, and concat them as new String.
Do this n times!

<p> Examples:

- "This is a test!", 1 -> "hsi  etTi sats!"
- "This is a test!", 2 -> "hsi  etTi sats!" -> "s eT ashi tist!"

<p> Write two methods:

- String encrypt(final String text, final int n)
- String decrypt(final String encryptedText, final int n)

<p> For both methods:

- If the input-string is null or empty return exactly this value!
- If n is <= 0 then return the input text.

<p> This kata is part of the Simple Encryption Series:

- Simple Encryption #1 - Alternating Split
- Simple Encryption #2 - Index-Difference
- Simple Encryption #3 - Turn The Bits Around
- Simple Encryption #4 - Qwerty

### Fundamentals
- Cryptography, Security, Algorithms, Strings, Arrays
