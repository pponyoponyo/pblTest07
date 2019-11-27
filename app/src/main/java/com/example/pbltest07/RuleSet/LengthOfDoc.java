package com.example.pbltest07.RuleSet;

import com.example.pbltest07.Rule;

public class LengthOfDoc extends Rule {

    private String html;

    public LengthOfDoc(String url) {
        super(url);
        html = getHtml();
    }

    public boolean rule(){

        String checkDocument = html;
        char [] d ; // null 로 초기화
        d = checkDocument.toCharArray(); // htmldocument문자열을 char 배열로 설정

        // Document length
        if(d.length>100){ // 100은 임의 값
            return true;
        }
        return false;
    }
}
