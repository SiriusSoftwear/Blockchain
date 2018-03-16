package com.company;

import java.security.NoSuchAlgorithmException;

public class Transaction {
    String from;
    String to;
    double amount;
    public Transaction(String from, String to,double amount){
        this.from=from;
        this.to=to;
        this.amount=amount;

    }
    public String getFrom(){
        return from;
    }
    public String getTo(){
        return to;
    }
    public double getAmount(){
        return amount;
    }
    public String getHash() throws NoSuchAlgorithmException {
        return HashingAlgorithm.HashMD5((from+to+String.valueOf(amount)));
    }
}
