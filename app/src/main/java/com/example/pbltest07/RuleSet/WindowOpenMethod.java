package com.example.pbltest07.RuleSet;

import com.example.pbltest07.Rule;

public class WindowOpenMethod extends Rule {

    private String html;

    public WindowOpenMethod(String url) {
        super(url);
        html = getHtml();
    }

    public boolean rule(){

        if(html.contains("window.open()")){
            return true;
        }
        return false;
    }
}




