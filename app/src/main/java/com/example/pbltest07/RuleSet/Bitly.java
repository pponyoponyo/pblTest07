package com.example.pbltest07.RuleSet;

import com.example.pbltest07.Rule;

public class Bitly extends Rule {

    private String url;

    public Bitly(String url) {
        super(url);
        this.url = url;
    }

    // 여기는 단축 url 관련 클래스임
    public boolean rule(){
        if(url.contains("bit.ly")){
           return true;
        }
        return false;
    }
}
