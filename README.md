# Blockchain
This is a representation of the basic concept of blockchain

## Block
The block object is determined by the following paramters:
*prev_hash: hash value of the previous block. if this is the first block, prev_hash will be the hash_value of "start"
*current_hash: hash value of the current block. the hash is build by hashing prev_hash, the transactions and the timestamp
*timestamp: the time the block was build
*List of the transactions: a list that consists of transaction objects. this list can be searched
