package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blockchain {
    public static List<Block> list=new ArrayList<>();
    private Blockchain(Builder builder) throws NoSuchAlgorithmException {
        this.list=builder.blockchain;
    }
    public static class Builder{
        private List<Block>blockchain=Block.getFirstBlock();

        public Builder() throws NoSuchAlgorithmException {
        }

        public Builder Blockchain(List<Block>blockchain){
            this.blockchain=blockchain;
            return this;
        }
        public Builder FromFile(){
            List<Block>p=new ArrayList<>();
            try(Reader reader = new InputStreamReader(new FileInputStream("Output.json"),"UTF-8")){
                Gson gson = new GsonBuilder().create();
                p = gson.fromJson(reader, new TypeToken<List<Block>>(){}.getType());
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.blockchain=p;
            return this;
        }
        public Blockchain build() throws NoSuchAlgorithmException {
            return new Blockchain(this);
        }
    }
    public void pushTransactions(List<Transaction>transactions) throws NoSuchAlgorithmException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        list.add(new Block(sdf.format(new Date()),transactions));
        System.out.println("pushed transactions successfully");

    }
    public boolean isTransactionValid(String address, double amount){
        Wallet wallet = new Wallet(address);
        if(wallet.amount>=amount){
            return true;
        }
        return false;
    }
    public static List<Transaction>viewAddress(String address){
        List<Transaction> address_trans=new ArrayList<>();
        for(int i=0;i<list.size();i++){
           address_trans.addAll(Block.searchTransactions(list.get(i).getTransactions(),address));
        }
        return address_trans;
    }
    public void save(){
        try(Writer writer = new OutputStreamWriter(new FileOutputStream("Output.json") , "UTF-8")){
            Gson gson = new GsonBuilder().create();
            gson.toJson(list,writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String>pool=Lib.getPool();
        for(int i=0;i<pool.size();i++){
            saveWallet(pool.get(i));
        }
    }
    public void print(){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).prev_hash);
            System.out.println(list.get(i).current_hash);
            System.out.println(list.get(i).timestamp);
            List<Transaction>transactions=list.get(i).transactions ;
            for(int m=0;m<transactions.size();m++){
                System.out.println("from "+transactions.get(m).getFrom()+" to "+transactions.get(m).getTo()+" "+transactions.get(m).getAmount());
            }

        }
    }
    private void saveWallet(String address){
        try(Writer writer = new OutputStreamWriter(new FileOutputStream(address+".json") , "UTF-8")){
            Gson gson = new GsonBuilder().create();
            gson.toJson(new Wallet(address),writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
