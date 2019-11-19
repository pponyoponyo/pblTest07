package com.example.pbltest07.RuleSet;

public class BackSlash {

    static public Boolean rule(String url){
        char [] c ;
        c = url.toCharArray();

        for(int i=0; i<c.length; i++){
            if(c[i]=='\\'){
                return true;
            }
        }
        return false;
    }
}
