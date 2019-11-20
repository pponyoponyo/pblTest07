package com.example.pbltest07.RuleSet;

public class Bitly {

// 여기는 단축 url 관련 클래스임
    static public boolean rule(String url){

        if(url.contains("bit.ly")){
           if(SuspiciousWords.rule(url)){
               return true;
           }
        }
        return false;
    }
}
