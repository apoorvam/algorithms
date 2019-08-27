# Hash Tables/Hashing

Its an approach to implement Symbol Tables. Its better than logarithmic time complexiety and does not support ordered operations. Hashing really at its core is a classic space-time tradeoff.

So idealistically, what we'd like is to be able to take any key and uniformly scramble it to produce a table index. We have two requirements, and one is that we have to be able to compute the thing efficiently in a reasonable amount of time. And the other is that it should be the case that every table index is equally likely for each key.

Most applications use a variation of Horner's Rule.

![Hashcode in Java](/assets/hashcode.png)