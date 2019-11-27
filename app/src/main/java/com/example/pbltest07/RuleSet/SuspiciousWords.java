package com.example.pbltest07.RuleSet;

import com.example.pbltest07.RuleBase;

public class SuspiciousWords extends RuleBase {
    //여기가 '택배'단어 들어가는 클래스임

    private String html;
    private boolean hypothesis = false;

    public SuspiciousWords(String url) {
        super(url);
        html = getHtml();
    }

    public void rule(){

        if(html.contains("택배")){
            setHypothesis(true);
        }

        if(html.contains("도박")){
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
