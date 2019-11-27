package com.example.pbltest07.RuleSet;

import com.example.pbltest07.Rule;

public class BackSlash extends Rule {

    String url;

    public BackSlash(String url) {
        super(url);
        this.url = url;
    }

    public boolean rule(){
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
