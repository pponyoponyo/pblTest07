package com.example.pbltest07.RuleSet;

public class Dot {

    static public Boolean rule(String url){
        char [] c ;
        c = url.toCharArray();

        for(int i=0; i<c.length-1; i++){
            if(c[i]=='.'&&c[i+1]=='.'){
               return true;
            }
        }
        return false;
    }
}
