package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Block
{
    List<Transaction
            >transactions;
    String prev_hash;
    String current_hash;
    String timestamp;
    public Block(String timestamp,List<Transaction>transactions) throws NoSuchAlgorithmException {
        this.transactions=transactions;
        this.timestamp=timestamp;
        if(Blockchain.list.size()>0){
            this.prev_hash=Blockchain.list.get(Blockchain.list.size()-1).getHash();

        }else{
            this.prev_hash="start";
        }
        this.current_hash=HashingAlgorithm.HashMD5((prev_hash+timestamp+getHashTransactions()));
        System.out.println("prev: " +  prev_hash);
        System.out.println("current: "+current_hash);

    }
    public String getHash(){
        return current_hash;
    }
    public List<Transaction>getTransactions(){
        return transactions;
    }
    private String getHashTransactions() throws NoSuchAlgorithmException {
        String temp="";
        for(int i=0;i<transactions.size();i++){
            temp=temp+transactions.get(i).getHash();
        }
        return HashingAlgorithm.HashMD5(temp);
    }
    public static List<Transaction> generateTransactions() throws NoSuchAlgorithmException {
        List<Transaction>transactions=new ArrayList<>();
        Random r = new Random();
        int range=r.nextInt(5)+50;
        for(int i=0;i<range;i++){
            transactions.add(new Transaction(Lib.GetAddress(),Lib.GetAddress(),r.nextDouble()));

        }
        return transactions;
    }
    private  static List<Transaction> generateNeutralTransactions() throws NoSuchAlgorithmException {
        List<Transaction>transactions=new ArrayList<>();
        Random r = new Random();
        int range=r.nextInt(20)+5;
        transactions.add(new Transaction(HashingAlgorithm.HashMD5(String.valueOf(r.nextInt(1000))),HashingAlgorithm.HashMD5(String.valueOf(r.nextInt(1000))),0));
        return transactions;

    }
    public static List<Transaction> searchTransactions(List<Transaction>transactions,String address){
        List<Transaction> list=new ArrayList<>();
        for(int i=0;i<transactions.size();i++){
            Transaction transaction=transactions.get(i);
            if((transaction.getFrom().matches(address))||(transaction.getTo().matches(address))){
                list.add(transaction);
            }
        }
        return list;
    }
    public static List<Block> getFirstBlock() throws NoSuchAlgorithmException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String date = sdf.format(new Date());
        List<Block>blockchain=new ArrayList<>();
        blockchain.add(new Block(date,generateNeutralTransactions()));
        return blockchain;
    }
}
