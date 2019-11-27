package com.example.pbltest07.RuleSet;

import com.example.pbltest07.Rule;

public class LengthOfURL extends Rule {

    private String url;

    public LengthOfURL(String url) {
        super(url);
        this.url = url;
    }

    public boolean rule(){

        String checkDot = url;
        char [] c ; // null 로 초기화
        c = checkDot.toCharArray(); // 문자열을 char 배열로 설정

        //Length of URL
        if(c.length>40){
          return true;
    }
        return false;
    }
}
