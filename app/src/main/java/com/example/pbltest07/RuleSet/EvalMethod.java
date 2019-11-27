package com.example.pbltest07.RuleSet;

import com.example.pbltest07.Rule;

public class EvalMethod extends Rule {

    private String html;

    public EvalMethod(String url) {
        super(url);
        html = getHtml();
    }

    public boolean rule(){

        if(html.contains("eval()")){
            return true;
        }
        return false;
    }

}
