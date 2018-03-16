# Blockchain
This is a representation of the basic concept of blockchain

## Block
The block object is determined by the following paramters:

-prev_hash: hash value of the previous block. if this is the first block, prev_hash will be the hash_value of "start"

-current_hash: hash value of the current block. the hash is build by hashing prev_hash, the transactions and the timestamp

-timestamp: the time the block was build

-List of the transactions: a list that consists of transaction objects. this list can be searched

## Transaction
The transaction object owns the following parameters:

-String from: wallet that sends currency

-String to: wallet that recieve currency

-double amount: amount of currency

## Wallet
```Wallet wallet = new Wallet(String address)```
You can construct a wallet with an existing address. 
The wallet has the following parameters:

-String address: address of the wallet
-double amount: balance of the wallet
- List of transactions: transaction history of the wallet
