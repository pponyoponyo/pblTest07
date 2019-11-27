package com.example.pbltest07.RuleSet;

public class TLDChina extends TLD {

    static public boolean rule(String url){
        //오버라이딩
        if(url.contains(".cn")){
            return true;
        }
        return false;
    }
}
