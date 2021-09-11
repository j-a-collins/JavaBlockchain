# JavaBlockchain
My first attempt at implementing a blockchain using the [SHA256](https://en.wikipedia.org/wiki/SHA-2) cryptographic algorithm for the fingerprint. This is mostly a proof of concept project for educational purposes - in order to better understand how a [blockchain](https://en.wikipedia.org/wiki/Blockchain) functions. Simply put: a blockchain is an increasing list of records, called ***blocks***, that are linked together using cryptography. 

# Diagram
Here is a simple diagram of the blockchain created in this project:
![Diagram](/BlockChain/img/blockchain.jpg)

As you can see, a blockchain is simply a chain of blocks. Each of the blocks contains some data (in this case a text message), a hash and the hash of the previous block. Each block uses the previous hash in order to partly calculate its own hash. The great thing about this is that if the previous block's data is altered then it's hash will change too (because the data also plays a role in the calculation). Change something and all the hashes of the following blocks change and we can determine whether the chain is valid or has been compromised. In short, try to change history and the digital signatures change and the chain is broken! As you can see, this a brilliant solution to the [double-spending problem](https://www.ussc.gov/sites/default/files/pdf/training/annual-national-training-seminar/2018/Emerging_Tech_Bitcoin_Crypto.pdf)!


<!--# Difficulty Level:

-->
