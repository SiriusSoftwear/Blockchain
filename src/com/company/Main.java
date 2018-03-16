package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {
    public static String hash_algo="SHA-256";

    public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException, UnsupportedEncodingException {
        /**Blockchain blockchain= new Blockchain.Builder().build();
        blockchain.pushTransactions(Block.generateTransactions());
        blockchain.pushTransactions(Block.generateTransactions());
        blockchain.pushTransactions(Block.generateTransactions());
        blockchain.save();
        blockchain.print();*/
        Blockchain blockchain= new Blockchain.Builder().FromFile().build();
        blockchain.print();
    }
}
