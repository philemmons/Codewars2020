### BasE91 encoding & decoding

<p> BasE91 is a method for encoding binary as ASCII characters. It is more efficient than Base64 and needs 91 characters to represent the encoded data.

<p> http://base91.sourceforge.net/

<p> The following ASCII charakters are used:

<p> 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'!#$%&()*+,./:;<=>?@[]^_`{|}~"'

<p> Create two functions that encode strings to basE91 string and decodes the other way round.

- b91encode('test') = 'fPNKd'
- b91decode('fPNKd') = 'test'

- b91decode('>OwJh>Io0Tv!8PE') = 'Hello World!'
- b91encode('Hello World!') = '>OwJh>Io0Tv!8PE'

<p> Input strings are valid.

#### Algorithms, Encoding, Decoding
