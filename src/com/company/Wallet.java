package com.company;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    String address;
    double amount;
    List<Transaction> transactions=new ArrayList<>();
    public Wallet(String address){
        this.address=address;
        this.transactions=Blockchain.viewAddress(address);
        this.amount=findAmount();
    }
    public double getAmount(){
        return amount;
    }
    public String getAddress(){
        return address;
    }
    public List<Transaction>getTransactions(){
        return transactions;
    }
    public double findAmount(){
        double balance=0;
        for(int i=0;i<transactions.size();i++){
            if(this.address.matches(transactions.get(i).getTo())){
                balance=balance+transactions.get(i).getAmount();
            }
            if(this.address.matches(transactions.get(i).getFrom())){
                balance=balance-transactions.get(i).getAmount();
            }
        }
        return balance;
    }
}
