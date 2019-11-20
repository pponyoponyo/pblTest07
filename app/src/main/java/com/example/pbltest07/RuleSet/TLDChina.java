package com.example.pbltest07.RuleSet;

public class TLDChina extends TLD {

   static public boolean findTLD(){
        //오버라이딩
        if(url.contains(".cn")){
            return true;
        }
        return false;
    }
}
