package com.example.pbltest07.RuleSet;

import com.example.pbltest07.Rule;

public class Dot extends Rule {

    private String url;

    public Dot(String url) {
        super(url);
        this.url = url;
    }

    public boolean rule(){
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
