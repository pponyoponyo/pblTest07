package com.example.pbltest07.RuleSet;

import com.example.pbltest07.RuleBase;

public class TLD extends RuleBase {

    private String url;
    private boolean hypothesis = false;

    public TLD(String url) {
        super(url);
        this.url = url;
    }

    @Override
    public void rule() {

        if(url.contains(".cn")){
            setHypothesis(true);
        }

        if(url.contains(".ru")){
            setHypothesis(true);
        }
    }

    public boolean isHypothesis() {
        return hypothesis;
    }

    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }
}
