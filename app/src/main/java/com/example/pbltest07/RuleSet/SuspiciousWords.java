package com.example.pbltest07.RuleSet;

import com.example.pbltest07.Rule;

public class SuspiciousWords extends Rule {
    //여기가 '택배'단어 들어가는 클래스임

    String html;

    public SuspiciousWords(String url) {
        super(url);
        html = getHtml();
    }

    public boolean rule(){

        if(html.contains("택배")){
            return true;
        }
        return false;
    }
}
