package com.example.pbltest07.RuleSet;

public class TLDRussia extends TLD {

    static public boolean rule(String url){
        //오버라이딩
        if(url.contains(".ru")){
            return true;
        }
        return false;
    }
}
