package com.example.pbltest07.RuleSet;

import com.example.pbltest07.Rule;

public class TLD extends Rule {

    private String url;

    public TLD(String url) {
        super(url);
        this.url = url;
    }

    @Override
    public boolean rule() {

        if(url.contains(".cn")){
            return true;
        }

        if(url.contains(".ru")){
            return true;
        }

        return false;
    }
}
