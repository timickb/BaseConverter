package com.example.baseconverter;

import java.util.HashMap;

public class Converter {
    private String number;
    private int fromBase, toBase;

    public Converter(String number, int fromBase, int toBase) {
        this.number = number;
        this.fromBase = fromBase;
        this.toBase = toBase;
    }
    public boolean valid() {
        if(toBase > 36 || fromBase > 36) return false;
        for(int i = 0; i < number.length(); i++) {
            if(Values.table.get(number.charAt(i)) == null || Values.table.get(number.charAt(i)) >= fromBase)
                return false;
        }
        return true;
    }

    public String convert() {
        int base10 = 0;
        for(int i = 0; i < number.length(); i++) {
            base10 += Values.table.get(number.charAt(i))*Math.pow(fromBase, number.length()-i-1);
        }
        String result = "";
        while(base10 > 0) {
            result =  Values.reversedTable.get(base10 % toBase) + result;
            base10 /= toBase;
        }
        return result;
    }
}
