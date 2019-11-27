package com.example.pbltest07.RuleSet;

import com.example.pbltest07.RuleBase;

public class BackSlash extends RuleBase {

    private String url;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }

    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public BackSlash(String url) {
        super(url);
        this.url = url;
    }

    public void rule(){
        char [] c ;
        c = url.toCharArray();

        for(int i=0; i<c.length; i++){
            if(c[i]=='\\'){
                setHypothesis(true);
            }
        }
    }
}
