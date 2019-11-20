package com.example.pbltest07.RuleSet;

public class RuleSuspiciousWords {
    //여기가 '택배'단어 들어가는 클래스임

    static public boolean suspiciouswordsrule(String html){
        if(html.contains("택배")){
            return true;
        }
        return false;
    }
}
