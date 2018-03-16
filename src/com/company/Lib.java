package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lib {
    public static String address0="C4CA4238A0B923820DCC509A6F75849B";
    public static String address1="C81E728D9D4C2F636F067F89CC14862C";
    public static String address2="ECCBC87E4B5CE2FE28308FD9F2A7BAF3";
    public static String address3="A87FF679A2F3E71D9181A67B7542122C";
    public static String address4="E4DA3B7FBBCE2345D7772B0674A318D5";
    public static String address5="1679091C5A880FAF6FB5E6087EB1B2DC";
    public static String address6="8F14E45FCEEA167A5A36DEDD4BEA2543";
    public static String address7="C9F0F895FB98AB9159F51FD0297E236D";
    public static String address8="45C48CCE2E2D7FBDEA1AFC51C7C6AD26";
    public static String address9="D3D9446802A44259755D38E6D163E820";
    public static String GetAddress(){
        List<String> pool=new ArrayList<>();
        pool.add(address0);
        pool.add(address1);
        pool.add(address2);
        pool.add(address3);
        pool.add(address4);
        pool.add(address5);
        pool.add(address6);
        pool.add(address7);
        pool.add(address8);
        pool.add(address9);
        Random r=new Random();
        return pool.get(r.nextInt(9));
    }
    public static List<String> getPool(){
        List<String> pool=new ArrayList<>();
        pool.add(address0);
        pool.add(address1);
        pool.add(address2);
        pool.add(address3);
        pool.add(address4);
        pool.add(address5);
        pool.add(address6);
        pool.add(address7);
        pool.add(address8);
        pool.add(address9);
        return pool;
    }

}
