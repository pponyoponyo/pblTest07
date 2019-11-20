package com.example.pbltest07.RuleSet;

public class RuleBitly extends RuleSuspiciousWords{
// 여기는 단축 url 관련 클래스임

    static public boolean detectbitly(String url){
        if(url.contains("bit.ly")){
            return true;
        }
        return  false;
    }

}
